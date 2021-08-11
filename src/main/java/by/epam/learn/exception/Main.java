package by.epam.learn.exception;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class Main {
    static void main(String[] args) {
        try {
            File file = new File("file.txt");
            Scanner scan = new Scanner(file);
        }
        catch (IOException ex) {
            System.out.println("1 ex");
        } finally {
            System.out.println("finally");
        }
    }
}
