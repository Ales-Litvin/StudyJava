package learn.primitives.doubles;

import java.math.BigDecimal;

/*
 * <сильные > Выводы
 * - Десятичные числа - это приближения, а не значение, которое вы назначили.
 *   Любая интуиция, полученная в математическом мире, больше не применяется. Ожидайте a+b = a и a != a/3 + a/3 + a/3
 * - Избегайте использования ==, сравнивайте с некоторым допуском или используйте команды >= или <=
 * - Java - это WYSINWYG! Никогда не верьте, что значение, которое вы печатаете/записываете, является приблизительным
 *   значением, поэтому всегда читайте/записывайте десятичные числа в том же формате.
 * - Соблюдайте осторожность, чтобы не переполнять свой двойник, чтобы не превратить ваш двойник в состояние
 *   ± бесконечность или NaN. В любом случае ваши расчеты могут оказаться не такими, как вы ожидали.
 *   Возможно, вам будет полезно всегда проверять эти значения перед возвратом значения в ваши методы.
 */
public class DoubleTrapDemo {

    public static void main(String[] args) {

        // Десятичные числа - это приближения
        System.out.println(0.2 + 0.2 + 0.2 + 0.2 + 0.2); // 1.0

        System.out.println(0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f); // 1.0000001
        System.out.println(0.1d + 0.1d + 0.1d + 0.1d + 0.1d + 0.1d + 0.1d + 0.1d + 0.1d + 0.1d); //  0.9999999999999999

        System.out.println(0.3 == 0.1d + 0.1d + 0.1d); // false

        // Переполнение двойников
        double big = 1.0e307 * 2000 / 2000;
        System.out.println(big == 1.0e307); // false

        // Крупные и маленькие не друзья!
        System.out.println(1234.0d + 1.0e-13d == 1234.0d); // true

        // Десятичные числа нельзя сравнивать напрямую

        // WYSINWYG - то, что вы видите, не то, что вы получаете
        // What You See Is Not What You Get
        System.out.println(0.1d); // 0.1

        double d1 = 2.2999999999999996d;
        double d2 = 2.2999999999999997d;
        System.out.println(d1 + " " + (2.3d == d1)); // 2.2999999999999994 false
        System.out.println(d2 + " " + (2.3d == d2)); // 2.3 true

        System.out.println(new BigDecimal(2.3d)); // 2.29999999999999982236431605997495353221893310546875

        System.out.println(0.1f); // 0.1
        System.out.println(Double.toString(0.1f)); // 0.10000000149011612
        System.out.println(0.1d); // 0.1

        // Разделение на 0
        System.out.println(22.0 / 0.0);  // Infinity
        System.out.println(-13.0 / 0.0); // -Infinity
        System.out.println(0.0 / 0.0);   // NaN

        System.out.println(22.0 / 0.0); // Infinity
        System.out.println(22.0 / -0.0); // -Infinity
        System.out.println(0.0 == -0.0); //  true

        // Бесконечность странная
        double infinity = 1.0 / 0.0;
        System.out.println(infinity + 1);           // Infinity
        System.out.println(infinity / 1e300);       // Infinity
        System.out.println(infinity / infinity);    // NaN
        System.out.println(infinity - infinity);    // NaN

        double d = 2.0, d22 = d - 2.0;
        System.out.println("even: " + (d % 2 == 0) + " odd: " + (d % 2 == 1)); // even: true odd: false
        d = d / d22;
        System.out.println("even: " + (d % 2 == 0) + " odd: " + (d % 2 == 1)); // even: false odd: false

        double nan = 0.0 / 0.0, infinity1 = 1.0 / 0.0;
        System.out.println(Double.MAX_VALUE != infinity1); // true
        System.out.println(Double.MAX_VALUE != nan);      // true
        System.out.println(infinity1 != nan);      // true

        System.out.println(nan + 1.0); // NaN
    }
}
