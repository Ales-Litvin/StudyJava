package javarush.task.task39.task3909;

/*
Одно изменение
Реализуй метод isOneEditAway(String first, String second)
который будет возвращать true, если возможно изменить/добавить/удалить один символ в одной из строк и получить другую.
Символы в анализируемой строке ограничены кодировкой ASCII.
Регистр символов учитывается.
Требования:
1. Метод isOneEditAway должен корректно работать для строк одинаковой длины.
2. Метод isOneEditAway должен корректно работать для строк разной длины.
3. Метод isOneEditAway должен корректно работать для пустых строк.
4. Метод isOneEditAway должен быть публичным.
*/

public class
Solution {
    public static void main(String[] args) {
        System.out.println(isOneEditAway("vna  ;dljd", "vna;dljd") + " : false");
        System.out.println(isOneEditAway("ботинок", "почтичто") + " : false");
        System.out.println(isOneEditAway("dddddd", "dd  dddd") + " : false");
        System.out.println(isOneEditAway("123", "1023")  + " : true");
        System.out.println(isOneEditAway("01", "12")  + " : true");
        System.out.println(isOneEditAway("123", "1453")  + " : true");
        System.out.println(isOneEditAway("01", "102")  + " : false");
        System.out.println(isOneEditAway("dddddd", " dddddd")  + " : true");
        System.out.println(isOneEditAway("123", "1423") + " : true");
        System.out.println(isOneEditAway("2", "33") + " : false");

    }

    // разделить на 2 случая строки одинаковой длинны и строки разной длинны
    public static boolean isOneEditAway(String first, String second) {
        int len1 = first.length();
        int len2 = second.length();
        int delta = Math.abs(len1 - len2);

        if (delta > 1) return false;

        if (first.equals("") && second.equals("")) return true;

        if(first.equals(second)) return true;

        StringBuffer s1 = (first.length() >= second.length()) ? new StringBuffer(first) : new StringBuffer(second);
        StringBuffer s2 = (first.length() < second.length()) ? new StringBuffer(first) : new StringBuffer(second);

        // s2.length < s1.length
        for (int i = 0; i < s2.length(); i++) {

            if (s1.charAt(i) != s2.charAt(i)) {

                if (delta != 0) {
                    s1.deleteCharAt(i);
                } else {
                    s1.deleteCharAt(i);
                    s2.deleteCharAt(i);
                }

                break;
            }
        }

        if (s1.length() != s2.length()) s1.deleteCharAt(s1.length() - 1);

        return s1.toString().equals(s2.toString());
    }
}
