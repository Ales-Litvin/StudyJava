package javarush.task.task22.task2212;

/*
Проверка номера телефона
*/

/*
 * Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
 *
 * Критерии валидности:
 * 1) если номер начинается с '+', то он содержит 12 цифр
 * 2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
 * 3) может содержать 0-2 знаков '-', которые не могут идти подряд
 * 4) может содержать 1 пару скобок '(' и ')' , причем если она есть, то она расположена левее знаков '-'
 * 5) скобки внутри содержат четко 3 цифры
 * 6) номер не содержит букв
 * 7) номер заканчивается на цифру
 *
 * Примеры:
 * +380501234567 - true
 * +38(050)1234567 - true
 * +38050123-45-67 - true
 * 050123-4567 - true
 * +38)050(1234567 - false
 * +38(050)1-23-45-6-7 - false
 * 050ххх4567 - false
 * 050123456 - false
 * (0)501234567 - false
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) return false;
        String telNumberOnlyNumber = telNumber.replaceAll("\\D", "");
        if (telNumberOnlyNumber.length() == 12){
            return telNumber.matches("^\\+\\d+(\\(\\d{3}\\))?\\d+-?\\d+-?\\d+$");
        }
        if (telNumberOnlyNumber.length() == 10){
            return telNumber.matches("^\\d+(\\(\\d{3}\\))?\\d+-?\\d+-?\\d+$");
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("+380501234567");
        list.add("+38(050)1234567");
        list.add("+38050123-45-67");
        list.add("050123-4567");
        list.add("+38)050(1234567");
        list.add("+38(050)1-23-45-6-7");
        list.add("050ххх4567");
        list.add("050123456");
        list.add("(0)501234567");

       for (String s : list){
           System.out.printf("%s - %s\n", s, checkTelNumber(s));
       }

    }
}