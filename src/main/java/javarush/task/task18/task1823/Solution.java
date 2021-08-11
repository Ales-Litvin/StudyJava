package javarush.task.task18.task1823;

import java.util.*;
import java.io.*;

/*
G:\Test.txt
G:\Test1.txt
G:\Test2.txt
G:\Test3.txt
 */

/*
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();

        String fileName;
        while (!("exit".equals(fileName = br.readLine()))){
            list.add(fileName);
        }
        br.close();

        for (String s : list){
            new ReadThread(s).start();
        }

    }

    public static class ReadThread extends Thread {
        private FileInputStream inputStream;
        private String fileName;
        private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        public ReadThread(String fileName) throws IOException{
            //implement constructor body
            this.fileName = fileName;
            this.inputStream = new FileInputStream(fileName);
        }

        // implement file reading here - реализуйте чтение из файла тут
        public void run (){
            try {
                while (inputStream.available() > 0){
                    int i = inputStream.read();
                    if (map.containsKey(i))
                    map.put(i, map.get(i) + 1);
                else
                    map.put(i, 1);
                }
                inputStream.close();
            }
            catch (IOException e){
                e.getMessage();
            }
            resultMapAdd();
        }

        public synchronized void resultMapAdd(){
            int byteMax = 0;
            int countMax = 0;

            for (Map.Entry<Integer, Integer> pair : map.entrySet()){
                int key = pair.getKey();
                int value = pair.getValue();
                if (value > countMax){
                    countMax = value;
                    byteMax =  key;
                }
            }
            resultMap.put(this.fileName, byteMax);
        }

    }
}