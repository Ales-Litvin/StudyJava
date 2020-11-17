package javarush.task.task39.task3910;

/*
isPowerOfThree
 */

public class Solution {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(1));
        System.out.println(isPowerOfThree(6));
        System.out.println(isPowerOfThree(15));
        System.out.println(isPowerOfThree(3));
        System.out.println(isPowerOfThree(9));
        System.out.println(isPowerOfThree(27));
        System.out.println(isPowerOfThree(81));
    }

    public static boolean isPowerOfThree(int n){
        int x = 1;
        while (x < n){
            x = x * 3;
        }
        return x == n;
    }
}
