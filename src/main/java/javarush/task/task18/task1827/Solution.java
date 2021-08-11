package javarush.task.task18.task1827;

/*
Прайсы
 */

/*
G:\CrUD.txt
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameCrUD = bufferedReader.readLine();
        bufferedReader.close();
        try {
            if (args[0].equals("-c") && args[1] != null && args[2] != null && args[3] != null) {
                BufferedReader fileReader = new BufferedReader(new InputStreamReader(
                        new FileInputStream(fileNameCrUD)));

                String string;
                int id = 0;
                while ((string = fileReader.readLine()) != null) {
                    char[] chars = string.toCharArray();
                    StringTokenizer tokenizer = new StringTokenizer(
                            new String(chars, 0, 8));
                    id = Integer.max(id, Integer.parseInt(tokenizer.nextToken()));
                }
                fileReader.close();

                String productName = args[1];
                while (productName.length() < 30) {
                    productName = productName + " ";
                }

                String price = args[2];
                while (price.length() < 8) {
                    price = price + " ";
                }

                String quantity = args[3];
                while (quantity.length() < 4) {
                    quantity = quantity + " ";
                }

                String stringId = String.valueOf(id + 1);
                while (stringId.length() < 8) {
                    stringId = stringId + " ";
                }


                String stringCruD = "\n" + stringId + productName + price + quantity;

                FileOutputStream fileOutputStream = new FileOutputStream(fileNameCrUD, true);
                fileOutputStream.write(stringCruD.getBytes());
                fileOutputStream.close();

            } else {
                System.out.println("Набор параметров не опознан.");
            }
        }
        catch (Exception e){
            System.out.print(e.getStackTrace().toString());
        }
    }
}


