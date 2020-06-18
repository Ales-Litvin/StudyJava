package javarush.task.task22.task2211;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/*
Смена кодировки
*/

/*
 * В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
 * В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое
 *  первого файла в кодировке UTF-8.
 */

/*
G:\Programming\Work\Hlam\src\javarush\task\task22\task2211\file_1.txt
G:\Programming\Work\Hlam\src\javarush\task\task22\task2211\file_2.txt
 */

public class Solution {
    public static void main(String[] args) throws IOException {
        Charset windows1251 = Charset.forName("windows-1251");

        FileInputStream fileInputStream = new FileInputStream(args[0]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[1]);

        while (fileInputStream.available() > 0){
            byte[] buffer = new byte[1000];
            fileInputStream.read(buffer);
            String data = new String(buffer, windows1251);
           fileOutputStream.write(data.getBytes());

        }
        fileInputStream.close();
        fileOutputStream.close();

    }
}