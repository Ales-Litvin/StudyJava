package javarush.task.task34.task3403;

/*
Разложение на множители с помощью рекурсии
 */
public class Solution {
    public static void main(String[] args) {
        /*
        recurse(132); // 2 2 3 11
        recurse(360); // 2 2 2 3 3 5
        recurse(144); // 2 2 2 2 3 3

         */
    }

    public void recurse(int n) {
        if (n > 1) {
            for (int i = 2; i <= n; i++) {
                if (n % i == 0) {
                    System.out.print(i + " ");
                    n = n / i;
                    recurse(n);
                    return;
                }
            }
        }
    }
}
