package javarush.task.task15.task1519;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        Solution.reader();

    }

    // Считывание данных с консоли
    public static void reader() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String string = reader.readLine();
            if ("exit".equals(string))
                break;
            else
                methodOption(string);
        }
    }

    public static void methodOption(String string){
        if (string.indexOf(".") >= 0){
            Solution.print((Double) Double.valueOf(string));
        }
        else {
            try {
                if (Integer.parseInt(string) < 128 && Integer.parseInt(string) > 0) {
                    Solution.print((short) Short.valueOf(string));
                } else if (Integer.parseInt(string) <= 0 || Integer.parseInt(string) >= 128) {
                    Solution.print((Integer) Integer.parseInt(string));
                }
            }
            catch (Exception e) {
                Solution.print(string);
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}

/*
1.1
100
-1
test
exit
 */