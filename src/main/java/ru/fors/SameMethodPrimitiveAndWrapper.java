package ru.fors;

public class SameMethodPrimitiveAndWrapper {

    public static String exec(Integer i){
        System.out.println("exec with 'Integer'=" + i);
        return String.valueOf(i);
    }

    public static String exec(int i){
        System.out.println("exec with 'int'=" + i);
        return String.valueOf(i);
    }



    public static void main(String[] args) {
        Integer i = new Integer(12);
        exec(i);
        exec(new Integer(12));
        exec(new Integer(280));
        exec(null);
        exec(12);
        exec((int) i);
    }
}
