package learn.main;



class Base {
    public static void print() {
        System.out.println("Base");
    }
}

class SubClass extends Base {
    public static void print() {
        System.out.println("SubClass");

        Number.one.ordinal();
    }

}

enum Number{
    one,
    two,
    three;
}

