package javarush.task.task14.task1419;

import java.io.*;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

/*
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        // # 1
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут 10 ваших исключений

        // # 2
        try{
            int a = Integer.parseInt("Хер преобразуешь в int");
        }
        catch (NumberFormatException e){
            exceptions.add(e);
        }

        // # 3
        try {
            FileInputStream inputStream = new FileInputStream("asfsa45");
        } catch (FileNotFoundException e) {
            exceptions.add(e);
        }

        // # 4
        try{
            int[] array = new int[10];
            array[15] = 15;
        }
        catch (ArrayIndexOutOfBoundsException e){
            exceptions.add(e);
        }

        // # 5
        try{
            throw new IndexOutOfBoundsException();
        }
        catch (IndexOutOfBoundsException e){
            exceptions.add(e);
        }

        // # 6
        try{
            throw new SocketException();
        }
        catch (SocketException e){
            exceptions.add(e);
        }

        // # 7
        try{
            throw new IOException();
        }
        catch (IOException e){
            exceptions.add(e);
        }

        // # 8
        try{
            throw new RuntimeException();
        }
        catch (RuntimeException e){
            exceptions.add(e);
        }

        // # 9
        try{
            throw new IllegalArgumentException();
        }
        catch (IllegalArgumentException e){
            exceptions.add(e);
        }

        // # 10
        try{
            throw new Exception();
        }
        catch (Exception e){
            exceptions.add(e);
        }

    }
}