package by_epam.basics_1.branching.task03;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isLine(4 ,5 , 2 ,4 ,6 ,6));
        System.out.println(isLine(0 ,5 , 0 ,4 ,0 ,6));
    }

    public static boolean isLine(int x1, int y1, int x2, int y2, int x3, int y3){
        // y = kx + b
        if (x1 == x2 && x2 == x3 || y1 == y2 && y2 == y3){
            return true;
        } else {
            int k = (y1 - y2) / (x1 - x2);
            int b = y1 - k * x1;
            return y3 == k * x3 + b;
        }
    }
}
