package javarush.task.task06.task0622;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        int[] array = new int[5];

        for (int i = 0; i < 5; i++) {
            int a = Integer.parseInt(reader.readLine());
            array[i] = a;
        }

            int s;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 - 1; j++){
                if (array[j] <= array[j+1]) {
                }
                    else {
                        s = array[j+1];
                        array[j+1] = array[j];
                        array[j] = s;
                    }
            }
        }
        for (int i = 0; i < 5; i++){
            System.out.println(array[i]);
        }
    }
}