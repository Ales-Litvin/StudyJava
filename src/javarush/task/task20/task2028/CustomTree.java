package javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/*
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;

    public CustomTree() {
        this.root = new Entry<String>("root");
    }

    @Override
    public boolean add(String s) {
        Queue<Entry<String>> queue = new ArrayDeque<>();
        queue.add(root);
        Entry<String> thisEntry = null;
        while (!queue.isEmpty()) {
            thisEntry = queue.poll();
            if (thisEntry != null){
                if (thisEntry.isAvailableToAddChildren()) {
                    break;
                } else {
                    if (thisEntry.leftChild != null) queue.add(thisEntry.leftChild);
                    if (thisEntry.rightChild != null) queue.add(thisEntry.rightChild);
                }
            }
        }

        if (thisEntry != null && thisEntry.isAvailableToAddChildren()){
            addLeftOrRightChild(s, thisEntry);
            return true;
        } else {
            restore();
            return add(s);
        }
    }

    private void addLeftOrRightChild(String s, Entry<String> thisEntry) {
        if (thisEntry.availableToAddLeftChildren){
            thisEntry.leftChild = new Entry<String>(s);
            thisEntry.availableToAddLeftChildren  = false;
            thisEntry.leftChild.parent = thisEntry;
        } else {
            thisEntry.rightChild = new Entry<String>(s);
            thisEntry.availableToAddRightChildren  = false;
            thisEntry.rightChild.parent = thisEntry;
        }
    }

    private void restore(){
        Queue<Entry<String>> queue = new ArrayDeque<>();
        queue.add(root);
        Entry<String> thisEntry = null;
        while (!queue.isEmpty()) {
            thisEntry = queue.poll();
            if (thisEntry != null){
                if (thisEntry.leftChild == null) {
                    thisEntry.availableToAddLeftChildren = true;
                } else {
                    queue.add(thisEntry.leftChild);
                }

                if (thisEntry.rightChild == null) {
                    thisEntry.availableToAddRightChildren = true;
                } else {
                    queue.add(thisEntry.rightChild);
                }
            }
        }
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        Queue<Entry<String>> queue = new ArrayDeque<>();
        queue.add(root);
        int count = -1;
        while (!queue.isEmpty()) {
            Entry<String> thisEntry = queue.poll();
            if (thisEntry != null){
                count += 1;
                if (thisEntry.leftChild != null) queue.add(thisEntry.leftChild);
                if (thisEntry.rightChild != null) queue.add(thisEntry.rightChild);
            }
        }
        return count;
    }

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof String)) throw new UnsupportedOperationException();
        Queue<Entry<String>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Entry<String> thisEntry = queue.poll();
            if (thisEntry != null){
                if (thisEntry.elementName.equals((String) o)) {
                    if (thisEntry.parent.rightChild != null && thisEntry.parent.rightChild.elementName.equals((String) o)) {
                        thisEntry.parent.rightChild = null;
                    } else if (thisEntry.parent.leftChild.elementName.equals((String) o)){
                        thisEntry.parent.leftChild = null;
                    }
                    return true;
                }
                if (thisEntry.leftChild != null) queue.add(thisEntry.leftChild);
                if (thisEntry.rightChild != null) queue.add(thisEntry.rightChild);
            }
        }
        return false;
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    public String getParent(String s) {
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Entry<String> thisEntry = queue.poll();
            if (thisEntry != null){
                if (thisEntry.elementName.equals(s)) {
                    return thisEntry.parent.elementName;
                }
                if (thisEntry.leftChild != null) queue.add(thisEntry.leftChild);
                if (thisEntry.rightChild != null) queue.add(thisEntry.rightChild);
            }
        }
        return null;
    }

    static class Entry<T> implements Serializable{
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren(){
            return availableToAddLeftChildren | availableToAddRightChildren;
        }
    }
}