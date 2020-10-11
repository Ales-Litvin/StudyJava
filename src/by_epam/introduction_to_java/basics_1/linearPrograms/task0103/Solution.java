package by_epam.basics_1.linearPrograms.task0103;

public class Solution {
    public static void main(String[] args) {
        double x = 1;
        double y = 1;
        double z = ((Math.sin(x) + Math.cos(y)) / (Math.cos(x) - Math.sin(y))) * Math.tan(x * y);
        System.out.println(z);
    }
}