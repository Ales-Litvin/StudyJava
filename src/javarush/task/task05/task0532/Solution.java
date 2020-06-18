package javarush.task.task05.task0532;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = Integer.parseInt(reader.readLine());

        if (maximum > 0){
            int[] n = new int[maximum];
            for (int i = 0; i < maximum; i++){
                n[i] =  Integer.parseInt(reader.readLine());
            }
            int s;
            for (int i = 0; i < maximum - 1; i++) {
                for (int j = 0; j < maximum - i - 1; j++) {
                    if (n[j] >= n[j + 1]) {
                    } else {
                        s = n[j];
                        n[j] = n[j + 1];
                        n[j + 1] = s;
                    }
                }

            }
            int k = n[0];
            System.out.println(k);
        }
    }
}