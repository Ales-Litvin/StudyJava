package by.epam.learn.io;

import java.io.*;

public class InputMain {
    public static void main(String[] args) {
        String path = "src/" +
                InputMain.class.getSimpleName().replace('.', '/') +
                "/data/info.txt";

        FileInputStream input = null;
        try {
            input = new FileInputStream(path);
            if (input.available() > 0) {
                byte[] buffer = new byte[1028];
                int data = input.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}