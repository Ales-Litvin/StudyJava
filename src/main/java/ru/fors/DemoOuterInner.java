package ru.fors;

public class DemoOuterInner {
    public static void main(String[] args) {
        Outer outer = new Outer("Some other");
        outer.someMethod();

        // создан через instance outer class
        Outer.Inner inner = outer.new Inner();
    }
}
