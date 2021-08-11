package javarush.task.task15.task1529;

/*
Осваивание статического блока
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

    }

    static {
        //add your code here - добавьте код тут
        try {
            Solution.reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static CanFly result;

    public static void reset() throws IOException {
        //add your code here - добавьте код тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        if ("helicopter".equals(str)){
            Solution.result = new Helicopter();
        }
        else if ("plane".equals(str)){
            int n_Person = Integer.parseInt(reader.readLine());
            Solution.result = new Plane(n_Person);
        }
        else {
            reader.close();
        }
    }
}