package ru.fors;

import java.util.Collection;
import java.util.HashSet;

public class DemoCollections {

    public static void main(String[] args) {
        CollectionsDefender defender = new CollectionsDefender();
        Collection c = new HashSet();
        defender.get(c);
    }
}
