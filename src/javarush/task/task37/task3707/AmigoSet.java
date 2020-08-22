package javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object ();
    private transient HashMap<E, Object> map;

    public AmigoSet(){ this.map = new HashMap<>(); }

    public AmigoSet(Collection<? extends E> collection){
        int capacity = Math.max(16, (int) Math.floor(collection.size()/.75f +1));
        this.map = new HashMap<>(capacity);
        for (E e : collection){
            this.map.put(e, PRESENT);
        }
    }

    @Override
    public boolean add(E e){ return null == map.put(e, PRESENT); }

    @Override
    public Iterator<E> iterator(){ return map.keySet().iterator(); }

    @Override
    public int size(){ return map.size(); }

    @Override
    public boolean isEmpty(){ return map.isEmpty(); }

    @Override
    public boolean contains(Object o){ return map.containsKey(o); }

    @Override
    public void clear(){ map.clear(); }

    @Override
    public boolean remove(Object o){ return map.remove(o) == null; }

    @Override
    public Object clone(){
        AmigoSet<E> amigoSet;
        try {
            amigoSet = new AmigoSet<E>();
            amigoSet.map = (HashMap<E, Object>) map.clone();
        } catch (Exception e){
            throw new InternalError();
        }
        return amigoSet;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        int capacity = HashMapReflectionHelper.callHiddenMethod(map, "capacity");
        out.writeInt(capacity);
        float loadFactor = HashMapReflectionHelper.callHiddenMethod(map, "loadFactor");
        out.writeFloat(loadFactor);
        out.writeInt(map.size());
        for (E e : map.keySet()){
            out.writeObject(e);
        }
    }

    private void readObject(ObjectInputStream in)
            throws IOException, ClassNotFoundException{
        in.defaultReadObject();
        int capacity = in.readInt();
        float loadFactor = in.readFloat();
        map = new HashMap<>(capacity, loadFactor);
        int size = in.readInt();
        for (int i = 0; i < size; i++){
            map.put((E) in.readObject(), PRESENT);
        }
    }

    HashSet e;
}