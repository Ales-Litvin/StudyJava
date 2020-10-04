package by_epam.basics_1.cycles.task05;

public class Solution {
    public static void main(String[] args) {
        System.out.println(returnSumRow(2, 5, 1));
    }

    public static int returnSumRow(int m, int n, int e){
        int result = 0;
        for (int i = m; i < n; i++){
            int a = 2;
            int b = 3;
            for (int k = 1; k < m; k++){
                a = a * 2;
                b = b * 3;
            }
            if (Math.abs(a + b) >= e) {
                result += a + b;
            }
        }
        return result;
    }
}
