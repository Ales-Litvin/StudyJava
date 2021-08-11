package javarush.task.task30.lessons.BitMasks;

public class Lesson {
    public static void main(String[] args) {

        /*
         * Битовая маска – это когда мы храним много различных логических значений
         * (true/false) в виде одного целого числа.
         *
         * Числа-степени двойки (1,2,4,8,16,32,…) занимают в
         * двоичном представлении числа всего по одному биту:
         */
        System.out.println(Integer.toUnsignedString(1, 2)); //  0000 0001
        System.out.println(Integer.toUnsignedString(2, 2)); //  0000 0010
        System.out.println(Integer.toUnsignedString(4, 2)); //  0000 0100
        System.out.println(Integer.toUnsignedString(8, 2)); //  0000 1000
        System.out.println(Integer.toUnsignedString(16, 2)); // 0001 0000
        System.out.println(Integer.toUnsignedString(32, 2)); // 0010 0000
        System.out.println("============================");

        // Вот как можно хранить различные логические значения в одном числе:
        boolean a = true;
        boolean b = false;
        boolean c = true;
        boolean d = false;

        int result = 0;
        if (a) result += 1; //1 == 20 — нулевой бит -- result = result + 1 = 1;
        if (b) result += 2; //2 == 21 — первый бит
        if (c) result += 4; //4 == 22 — второй бит
        if (d) result += 8; //8 == 23 — третий бит

        //0000 0101

        System.out.println(Integer.toUnsignedString(result, 2));

        /*
         * Нужно узнать, установлен ли 5-й бит числа в единицу или нет
         * (2 в пятой степени – это 32). Вот как это можно проверить:
         */

        // Соединяем числа в одно:
        int a1 = 32; //25 == 0010 0000
        int b1 = 8; //23 == 0000 1000
        int c1 = 2; //21 == 0000 0010

        // Восстанавливаем обратное значение – проверяем установлен ли определенный бит:
        int result1 = a1+b1+c1; //32+8+2 == 42 == 0010 1010

        int a2 = result & 32; // 0010 1010 & 0010 0000 = 0010 0000
        int b2 = result & 8; // 0010 1010 & 0000 1000 = 0000 1000
        int c2 = result & 2; // 0010 1010 & 0000 0010 = 0000 0010
    }
}
