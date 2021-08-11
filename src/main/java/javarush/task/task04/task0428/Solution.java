package javarush.task.task04.task0428;

/*
Положительное число
 */

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int d = plus(a) + plus(b) + plus(c);
        System.out.println(d);
    }
    public  static int plus(int a) {
        int c;
        if (a > 0)
            c = 1;
        else
            c = 0;
                    return c;
    }
}
