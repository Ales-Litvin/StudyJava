package javarush.task.task30.lessons.lesson10;

public class Lesson {
    public static void main(String[] args) {
        System.out.println(Double.MAX_VALUE / Double.POSITIVE_INFINITY); // Infinity - Бесконечность
        System.out.println(Double.MAX_VALUE / Double.NEGATIVE_INFINITY);
        System.out.println(Double.NEGATIVE_INFINITY);
        System.out.println(0 / Double.NEGATIVE_INFINITY);
        System.out.println(Double.NEGATIVE_INFINITY - Double.NEGATIVE_INFINITY); // NaN – Not-a-Number
    }
}
