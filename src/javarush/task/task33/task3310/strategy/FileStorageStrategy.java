package javarush.task.task33.task3310.strategy;

public class FileStorageStrategy implements StorageStrategy{

    static final int DEFAULT_INITIAL_CAPACITY = 16;

    static final long DEFAULT_BUCKET_SIZE_LIMIT = 10000;

    FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];

    public FileStorageStrategy() {
        table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
        for (int i = 0; i < table.length; i++){
            table[i] = new FileBucket();
        }
    }

    int size;

    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;

    long maxBucketSize;

    // getters and setters
    public long getBucketSizeLimit() { return bucketSizeLimit; }
    public void setBucketSizeLimit(long bucketSizeLimit) { this.bucketSizeLimit = bucketSizeLimit; }

    int hash(Long key) {
        key ^= (key >>> 20) ^ (key >>> 12);
        return (int) (key ^ (key >>> 7) ^ (key >>> 4));
    }

    int indexFor(int hash, int length){
        return hash & (length - 1);
    }

    Entry getEntry(Long key){
        int hash = (key == null) ? 0 : hash(key);
        int bucketIndex = indexFor(hash, table.length);

        FileBucket bucket = table[bucketIndex];
        for (Entry e = bucket.getEntry(); e != null; e = e.next){
            Long k = e.key;
            if (e.hash == hash && key.equals(k)){
                return e;
            }
        }
        return null;
    }

    void resize(int newCapacity){
        FileBucket[] newTable = new FileBucket[newCapacity];
        for (FileBucket bucket : newTable){
            bucket = new FileBucket();
        }

        transfer(newTable);
        table = newTable;
    }

    void transfer(FileBucket[] newTable) {
        int newCapacity = newTable.length;

        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) continue;
            Entry entry = table[i].getEntry();

            while (entry != null){
                Entry next = entry.next;
                int bucketIndex = indexFor(entry.hash, newCapacity);
                entry.next = newTable[bucketIndex].getEntry();
                newTable[bucketIndex].putEntry(entry);
                entry = next;
            }
            table[i].remove();
            table[i] = null;
        }
    }

    void addEntry(int hash, Long key, String value, int bucketIndex){
        Entry e = table[bucketIndex].getEntry();
        table[bucketIndex].putEntry(new Entry(hash, key, value, e));

        FileBucket bucket = table[bucketIndex];
        if (bucket.getFileSize() >= bucketSizeLimit)
            resize(2 * table.length);
    }

    void createEntry(int hash, Long key, String value, int bucketIndex){
        table[bucketIndex] = new FileBucket();
        table[bucketIndex].putEntry(new Entry(hash, key, value, null));
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        if (value == null) return false;

        for (FileBucket bucket : table){
            if (bucket != null) {
                Entry e = bucket.getEntry();
                for (; e != null; e = e.next) {
                    if (e.value.equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash((long) key.hashCode());
        int bucketIndex = indexFor(hash, table.length);

        FileBucket bucket = table[bucketIndex];
        if (bucket == null) {
            createEntry(hash, key, value, bucketIndex);
        } else {
            Entry entry = bucket.getEntry();
            for (Entry e = entry; e != null; e = e.next) {
                Long k = e.key;
                if (e.hash == hash && k.equals(key)) {
                    e.value = value;
                    bucket.putEntry(entry);
                    return;
                }
            }
            size++;
            addEntry(hash, key, value, bucketIndex);
        }
    }

    @Override
    public Long getKey(String value) {
        for (FileBucket bucket : table){
            if (bucket == null) continue;
            for (Entry e = bucket.getEntry(); e != null; e = e.next){
                if (e.value.equals(value)){
                    return e.key;
                }
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        if(this.containsKey(key)) {
            return getEntry(key).getValue();
        }
        return null;
    }
}