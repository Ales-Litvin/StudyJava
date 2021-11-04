package ru.fors;

public class Outer {
    private String name;

    public Outer(String name) {
        this.name = name;
    }

    public void someMethod(){
        Inner inner = new Inner();
        inner.print();
    }

    class Inner {
        private String name;

        void print(){
            System.out.println(Outer.this.name);
        }
    }
}
