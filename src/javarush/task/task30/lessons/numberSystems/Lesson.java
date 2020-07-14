package javarush.task.task30.lessons.numberSystems;

public class Lesson {
    static final byte aByte = Byte.MAX_VALUE;  // 8 бит от -128 до 127
    static final short aShort = Short.MAX_VALUE; // 16 бит от -32768 до 32767
    static final char aChar = Character.MAX_VALUE; // 16 бит	беззнаковое целое число, представляющее собой символ UTF-16 (буквы и цифры)
    static final int anInt = Integer.MAX_VALUE; // 32 бит	от -2147483648 до 2147483647
    static final long aLong = Long.MAX_VALUE;


    /*
     * Алгоритм перевода чисел из одной системы счисления в другую
     * Перевод целых десятичных чисел в любую другую системы счисления осуществляется
     * делением числа на основание новой системы счисления до тех пор,
     * пока в остатке не останется число меньшее основания новой системы счис­ления.
     *
     * Новое число записывается в виде остатков деления, начиная с последнего.
     * Перевод правильной десятичной дроби в другую ПСС осуществляется умножением
     * только дробной части числа на основание новой системы счисления до тех пор пока
     * в дробной части не останутся все нули или пока не будет достигнута заданная точность перевода.
     *
     * В результате выполнения каждой операции умножения формируется одна цифра нового числа
     * начиная со старшего.
     *
     * Делим на 2 и записываем остатки от деления о или 1
     */


    public static void main(String[] args) {
        byte nine = 9;
        byte five = 5;
        System.out.println(Integer.toUnsignedString(nine, 2));
        System.out.println(Integer.toUnsignedString(five, 2));
        System.out.println("============================");
        System.out.println(Integer.toUnsignedString(nine & five, 2)); // побитовое И
        System.out.println("============================");
        System.out.println(Integer.toUnsignedString(nine | five, 2)); // побитовое ИЛИ
        System.out.println("============================");
        System.out.println(Integer.toUnsignedString(nine ^ five, 2)); // исключающие ИЛИ
        System.out.println("============================");
        System.out.println(Integer.toUnsignedString(~nine, 2)); // побитовая инверсия
        System.out.println("============================");
        /* Сдвиг двоичного представления числа "a" (1001) на n позиций влево и право

         * Стар-шие биты теряются, младшие заполняются нулями.
         * Фактически в данном случае идет речь об умножении числа "a" на 2 в степени n
         * (так рассчитывает-ся результат, само число "a" при этом не меняется).
         */
        System.out.println(Integer.toUnsignedString(nine << 1, 2)); // сдвиг влево
        System.out.println(Integer.toUnsignedString(nine << 2, 2)); // сдвиг влево
        System.out.println(Integer.toUnsignedString(nine << 3, 2)); // сдвиг влево
        System.out.println("============================");
        System.out.println(Integer.toUnsignedString(nine >> 1, 2)); // сдвиг вправо
        System.out.println(Integer.toUnsignedString(nine >> 2, 2)); // сдвиг вправо
        System.out.println(Integer.toUnsignedString(nine >> 3, 2)); // сдвиг вправо
        System.out.println("============================");
        /* Сдвиг двоичного представления числа (1001) на n позиций влево и право
         * Отличие оператора >>> от оператора >> состоит в том, что биты слева заполняются нулями.
         */
        System.out.println(Integer.toUnsignedString(52, 2));
        System.out.println(Integer.toUnsignedString(52 >>> 1, 2)); // сдвиг вправо
        System.out.println(Integer.toUnsignedString(52 >>> 2, 2)); // сдвиг вправо
        System.out.println(Integer.toUnsignedString(52 >>> 3, 2)); // сдвиг вправо

    }
}
