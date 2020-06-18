package javarush.task.task06.task0606;

import java.io.*;

public class Solution {

        public static int even;
        public static int odd;



    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int l = n.length();
        for (int i = 0; i < l; i++){
            if ((Character.getNumericValue(n.charAt(i)))%2 == 0 ){
                even++;
            }
            else {
                odd++;
            }
        }

        System.out.println("Even: " + even + " Odd: " + odd);


    }

}
