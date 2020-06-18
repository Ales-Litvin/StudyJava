package javarush.task.task04.task0441;

/*
Как-то средненько
 */

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        usl(a, b, c);
        usl(b, a, c);
        usl(b, c, a);
        usl(a, c, b);
        usl(c, a, b);
        usl(c, b, a);

        usl2(a, b, c);
        usl2(a, c, b);
        usl2(b, c, a);

        usl3(a , b, c);


    }

    public static void usl(int a, int b, int c){  // находит среднее число при условии их неравенства
        if ( a < b && b < c)
            System.out.println(b);
        else {
        }
    }

    public static void usl2(int a, int b, int c){   // находит среднее число при условии их равенства
        if (a == b && a != c) {
            System.out.println(a);
        }

        else {

        }
    }

    public static void usl3(int a, int b, int c) { // опредление равенства чисел
        if (a == b && a == c) {
            System.out.println(a);
        }
        else {

        }
    }

}
