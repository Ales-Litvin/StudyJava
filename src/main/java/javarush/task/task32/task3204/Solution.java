package javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/*
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while(true){
            StringBuffer sb = new StringBuffer();
            for (char c : Integer.toHexString(
                    (int) (Math.random() * 1000000000)).toCharArray()){
                if ((int) (Math.random() * 10) > 5){
                    c = Character.toUpperCase(c);
                }
                sb.append(c);
            }

            if (sb.length() == 8 && sb.toString().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$")){
                try {
                    byteArrayOutputStream.write(sb.toString().getBytes());
                } catch (IOException e) {

                }
                break;
            }
        }
        return byteArrayOutputStream;
    }
}