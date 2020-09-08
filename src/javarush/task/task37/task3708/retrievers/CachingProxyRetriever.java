package javarush.task.task37.task3708.retrievers;

import javarush.task.task37.task3708.cache.LRUCache;
import javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever{
    OriginalRetriever originalRetriever;
    LRUCache<Long, Object> cache = new LRUCache(10);

    public CachingProxyRetriever(Storage storage){
        this.originalRetriever = new OriginalRetriever(storage);
    }

    @Override
    public Object retrieve(long id){
        Object object = cache.find(id);

        if (object != null){
            return object;
        } else {
            object = originalRetriever.retrieve(id);
            cache.set(id, object);
        }
        return object;
    }

}