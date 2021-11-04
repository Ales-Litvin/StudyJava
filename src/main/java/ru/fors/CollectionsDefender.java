package ru.fors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class CollectionsDefender {

    public void get(Collection c){
        System.out.println("Collection");
    }

    public void get(HashSet s){
        System.out.println("HashSet");
    }

    public void get(ArrayList a){
        System.out.println("ArrayList");
    }
}
