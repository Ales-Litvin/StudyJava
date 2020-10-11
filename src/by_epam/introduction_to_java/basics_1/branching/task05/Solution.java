package by_epam.basics_1.branching.task05;

public class Solution {
    public static void main(String[] args) {

    }

    public static int isSolution(int x){
        int result;
        if (x <= 3){
            result = (x * x * x) - (3 * x) + 9;
        } else {
            result = 1 / ((x * x * x) + 6);
        }
        return result;
    }
}
