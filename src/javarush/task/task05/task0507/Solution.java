package javarush.task.task05.task0507;

import java.io.*;
import java.net.SocketOption;

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i=0;
        int k;
        double s = 0.0;
        double sr;

        while (true){
            k = Integer.parseInt(br.readLine());
            if (k != -1) {
                i++;
                s = (s + k);
                continue;
            }
            else {

                break;
            }
        }
        sr = s / i;

        System.out.println(sr);
    }
}
