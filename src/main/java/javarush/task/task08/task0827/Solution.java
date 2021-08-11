package javarush.task.task08.task0827;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("January 2 2020"));
    }

    public static boolean isDateOdd(String date) throws ParseException {
        DateFormat df = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH);
        Date date1 = df.parse(date);
        int d = 4;
        char[] ch = new char[4];
        for (int i = 0; i < 4; i++){
            ch[i] = date.charAt(date.length()-d);
            --d;
        }
        String controlDate = new String (ch);
        controlDate = "January 1 " + controlDate;
        Date date2 = df.parse(controlDate);
        int l = (int) (((date1.getTime() - date2.getTime())/(60*60*24*1000))+1);
        boolean t = false;
        if (l%2 != 0){
            t = true;
        }
        System.out.println(l);
        return t;
    }
}