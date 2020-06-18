package javarush.task.task14.task1420;

/*
НОД
 */

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                int a = Integer.parseInt(reader.readLine());
                if (a <= 0) {
                    throw new Exception();
                }
                int b = Integer.parseInt(reader.readLine());
                if (b <= 0) {
                    throw new Exception();
                }
                reader.close();

                int NOD;

                while (a != 0 | b != 0) {
                    if (a == 0 | b == 0)
                        break;
                    if (a > b) {
                        a = a % b;
                    } else {
                        b = b % a;
                    }
                }
                NOD = a + b;
                System.out.println(NOD);
            }

    }
