package javarush.task.task04.task0442;

/*
Суммирование
 */

import java.io.*;

public class Solution {
    public static void main (String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k;
        int s = 0;
        while (true) {
            k = Integer.parseInt(br.readLine());
            if (k == -1 ) {
                s = s + k;
                break;
            }
            else {
                s = s + k;
                continue;
                }
            }
        System.out.println(s);


        }
    }
