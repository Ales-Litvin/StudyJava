package javarush.task.task05.task0529;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum=0;
        while (true){
            String s = br.readLine();
            if (s.equals("сумма"))
                break;
            else {
                sum = sum + Integer.parseInt(s);
            }
        }
        System.out.println(sum);
    }

}
