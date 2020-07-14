package javarush.task.task30.task3010;


import java.math.BigInteger;

/*
Минимальное допустимое основание системы счисления
*/
public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try {
            if (!args[0].matches("\\w+")) {
                System.out.println("incorrect");
                return;
            }
        } catch (Exception  e){
            // нечего не печатать
        }

        for (int i = 2; i <= 36; i++) {
            try {
                BigInteger big = new BigInteger(args[0], i);
                System.out.println(i);
                break;
            } catch (Exception  e){
                continue;
            }
        }
    }
}