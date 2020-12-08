package learn.main;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

final class Name implements Serializable {
    public static void main(String[] args) {
        Class clazz;

    }
}

class Animal {
    Number defineAge() {
        System.out.println("I'm a big animal");
        return 10;
    }
}

class Dog extends Animal {
    @Override
    protected Float defineAge() {
        System.out.println("I want to be bigger");
        return 5f;
    }
}

class Main {
    public static void main(String[] args) {
        A a = new B();
        a.method(42);
    }
}

class A {
    public void method(Object obj) {
        System.out.println("A");
    }
}

class B extends A {
    public void method(Integer obj) {
        System.out.println("B");
    }
}

class Quest {
    public void method(Number obj) {
        System.out.print("1");
    }

    public void method(Character obj) {
        System.out.print("2");
    }

    private static void method(Integer obj) {
        System.out.print("3");
    }

    public void method(int i) {
        System.out.print("4");
    }

    public void method(double d) {
        System.out.print("5");
    }

    public static void main(String[] args) {
        Quest quest = new Quest();
        Number n = 67;
        Integer i = 78;
        quest.method(n);
        quest.method(i);
    }
}

class Math{
    public static void main(String[] args) {
        System.out.println(5 / 10);
        System.out.println(7/4);
    }
}

class D{

    public D(String name) {
        super();
        this.name = name;
    }

    private String name;
    {
        name = "First Name";
    }

    {
        name = "adldsfj";
    }

    public static void method(){
        Object o;
    }

    {
        name = "adldsfj";
    }
}

class C extends D implements Cloneable,
        Serializable, Externalizable, Comparable<C>{

    D d = new C("alsdjf");

    String name;

    public void waitObjectD(D d){

    }


    public C(String name) {
        super(name);
    }

    public void method(Integer c){
        waitObjectD(new C("asldfj"));
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        C c = new C(name);
        return c;
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = (String) in.readObject();
    }

    @Override
    public int compareTo(C o) {
        return Objects.compare(name, o.name, Comparator.naturalOrder());
    }
}

interface SomeInterface{

    String o = "LSK:JDFS:LKDJF";

}

class GenericClass<T>{

    public static void main(String[] args) throws IOException {
        try {
            throw new IOException("Just Exception!");
        } catch (Exception e){
            
        } finally {

        }
    }


}
