package javarush.task.task16.task1630;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
        secondFileName = reader.readLine();
        reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);

    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        try {
            System.out.println(f.getFileContent());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent() throws FileNotFoundException, IOException;

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface{
        private String fullFileName;
        private List<String> listFile = new ArrayList<>();
        private String stringFile = "";

        @Override
        public void run() {
            try {

                FileInputStream inputStream = new FileInputStream(fullFileName);
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String str;
                while ((str = reader.readLine()) != null) {
                    listFile.add(str);
                }
            }
            catch (Exception e){
                e.getMessage();
            }
        }

        @Override
        public void setFileName(String fullFileName){ // Устанавливает имя файла
            this.fullFileName = fullFileName;
        }

        @Override
        public String getFileContent(){
                String s = "";
                for (String string: listFile){
                    s = s + " " + string;
                }
                return s;
        }
    }
}

// G:\Test.txt
// G:\Test2.txt