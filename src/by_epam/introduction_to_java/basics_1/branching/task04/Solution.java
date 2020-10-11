package by_epam.basics_1.branching.task04;

public class Solution {
    public static void main(String[] args) {
        int A = 2;
        int B = 5;

        int x = 2;
        int y = 6;
        int z = 10;

        boolean is;

        if (x <= A){
            is = y <= B || z <= B;
        } else if (y <= A){
            is = x <= B || z <= B;
        } else if (z <= A){
            is = x <= B || y <= B;
        } else {
            is = false;
        }
        System.out.println(is);
    }
}
