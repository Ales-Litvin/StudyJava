package learn.main;

public class Program {
    public static void main(String[] args) {
        Cat sam = new SiameseCat(); //1
        sam.zzz(); //2
    }
}

abstract class Cat {
    abstract void eat();

    void zzz() {
        System.out.println("Sleeps whole day");
    }
}

class SiameseCat extends Cat {
    @Override
    void eat() {

    }
} //3
