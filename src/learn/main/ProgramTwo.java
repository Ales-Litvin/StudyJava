package learn.main;

public class ProgramTwo {
    public static void main(String[] args) {
        Object obj = new Object();
        Class clazz = obj.getClass();
        System.out.print(clazz.getSuperclass() + ", ");
        Class clazzClass = clazz.getClass();
        System.out.print(clazzClass.getSuperclass());
    }
}

