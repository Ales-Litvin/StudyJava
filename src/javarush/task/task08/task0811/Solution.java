package javarush.task.task08.task0811;

import java.util.*;

public class Solution {
    public static List getListForGet(){
        //напишите тут ваш код
        ArrayList array = new ArrayList();
        LinkedList linked = new LinkedList();
        for (int i = 0; i < 100000; i++){
            array.add(1);
            linked.add(1);
        }
        Date time1_1 = new Date();
        for (int i = 0; i < 100000; i++){
            array.get(1);
        }
        Date time1_2 = new Date();
        for (int i = 0; i < 100000; i++){
            linked.get(1);
        }
        Date time1_3 = new Date();
        if (time1_2.getTime() - time1_1.getTime() < time1_3.getTime() - time1_2.getTime()){
            return array;
        }
        else {
            return linked;
        }
    }

    public static List getListForSet() {
        //напишите тут ваш код
        ArrayList array = new ArrayList();
        LinkedList linked = new LinkedList();
        for (int i = 0; i < 100000; i++){
            array.add(1);
            linked.add(1);
        }
        Date time1_1 = new Date();
        for (int i = 0; i < 100000; i++){
            array.set(i, 0);
        }
        Date time1_2 = new Date();
        for (int i = 0; i < 100000; i++){
            linked.set(i, 0);
        }
        Date time1_3 = new Date();
        if (time1_2.getTime() - time1_1.getTime() < time1_3.getTime() - time1_2.getTime()){
            return array;
        }
        else {
            return linked;
        }
    }

    public static List getListForAddOrInsert() {
        //напишите тут ваш код
        ArrayList array = new ArrayList();
        LinkedList linked = new LinkedList();
        Date time1_1 = new Date();
        for (int i = 0; i < 100000; i++){
            array.add(1);
        }
        Date time1_2 = new Date();
        for (int i = 0; i < 100000; i++){
            linked.add(1);
        }
        Date time1_3 = new Date();
        if (time1_2.getTime() - time1_1.getTime() < time1_3.getTime() - time1_2.getTime()){
            return array;
        }
        else {
            return linked;
        }
    }

    public static List getListForRemove() {
        //напишите тут ваш код
        ArrayList array = new ArrayList();
        LinkedList linked = new LinkedList();
        for (int i = 0; i < 100000; i++){
            array.add(1);
            linked.add(1);
        }
        Date time1_1 = new Date();
        for (int i = 0; i < 100000; i++){
            array.remove(0);
        }
        Date time1_2 = new Date();
        for (int i = 0; i < 100000; i++){
            linked.remove(0);
        }
        Date time1_3 = new Date();
        if (time1_2.getTime() - time1_1.getTime() < time1_3.getTime() - time1_2.getTime()){
            return array;
        }
        else {
            return linked;
        }
    }

    public static void main(String[] args) {

    }

}
