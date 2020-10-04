package by_epam.basics_1.linearPrograms.task0102;

public class Solution {
    public static void main(String[] args) {
        double a = 1d;
        double b = 3d;
        double c = 4d;
        double z = ((b + Math.sqrt(b * b + 4 * a * c)) / (2 * a)) - (a * a * a * c) + 1 / (b * b);
        System.out.println(z);
    }
}
