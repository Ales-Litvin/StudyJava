package learn.main;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LearnMain {
    public static void main(String[] args) {

    /*
        System.out.println("hello Java");
        System.out.println(42);
        System.out.println("java " + 11);
        //System.exit(10);
        System.out.println(3);
        int _int;
        int _2_;
        int $int;


        //double d1 = 0.0f;
        Double d2 = new Double(.0f);
        //Double d3 = 0.0f;
        //Double d4 = new Double("1L");
        Double d5 = 0.d;
        //Double d6 = 1L;

        int i1 = Integer.parseInt("14");
        Integer i2 = 85;
        //int i3 = Integer.decode('12');
        int i4 = Integer.valueOf("21");
        //int i5 = Integer.valueOf(null);
        int i6 = new Integer("15");

        //Integer integer = new Integer(null);

        //System.out.println(new Integer(null));
        //System.out.println(new String(null));
        System.out.println(new String("null"));
        //System.out.println((char[]) null);
        System.out.println((true?null:0));
        System.out.println((String) null);

        Byte b = new Byte("3");  // line 1
        System.out.println(b.floatValue() + " " + b.getClass().getName());  // line 2

        Double d = Double.POSITIVE_INFINITY;
        System.out.println(d.intValue());
        double d1 = d.intValue() + Double.NEGATIVE_INFINITY;
        System.out.println(d1);

        Integer integer = new Integer(0);
        System.out.println(integer);

        //int var1 = 356f;
        double var2 = 356f;
        float var3 = 356f;
        //char var4 = 356f;
        //long var5 = 356f;
        //Integer var6 = 356f;
        //Character var7 = 356f;
        Object var8 = 356f;

        char c = 17;
        int i = 's';
        float f = 7.0f;

        Integer number = 32;
        // Binary number format
        String convert = Integer.toBinaryString(number);
        System.out.print(convert + " ");
        // Octagonal number format
        convert = Integer.toOctalString(number);
        System.out.print(convert + " ");
        // Hexadecimal number format
        convert = Integer.toHexString(number).toUpperCase();
        System.out.print(convert + " ");
        */

//        long a = 2147483647000L;
//        int b = 1;
//        b += a;
//        Object ab = (Object) b;
//        System.out.println(ab.getClass().getName() + " value: " + ab);


        /*
        BigDecimal b1 = new BigDecimal("23.43");
        BigDecimal b2 = new BigDecimal("23.43");
        BigDecimal b3 = new BigDecimal("24");
        System.out.println(b1.compareTo(b2) == 0); //1
        System.out.println(b1.compareTo(b3) == 1); //2
        System.out.println(b1.equals(b2)); //3
        System.out.println(b1.equals(new BigDecimal("23.43"))); //4
        System.out.println(b1 == b2); //5
        b2 = b2.add(new BigDecimal("0.57"));
        System.out.println(b3.equals(b2)); //6
        */

        /*int[] mas1 = new int[24];
        Integer mas2[] = new Integer[24];
        //char[] mas3 = new Character[] {'a', 'b', 'c'};
        //Solution [] mas4 = new Solution {new Solution(), new Solution()};
        double[] mas5 = {1, 2, 3, 4};
        int[] mas6 [] = new int[4][5];
        int mas7[][] = new int[4][];*/

        /*int a1[] = {};
        int a2[] = new int[]{1, 2, 3};
        //int a3 = new int[](1, 2, 3);
        int a4[] = new int[3];
        //int a5[] = new int[3]{1, 2, 3};*/

        int[] arrMain = {2, 5, 7, 8, 3, 0};
        new Example(arrMain);

        Arrays.toString(arrMain);

        Pattern e;
        Matcher m;
    }

    static class Example{
        static int[] arr;
        static {
            int val = arr[0];
        }
        public Example(int[] arrMain) {
            this.arr = arrMain;
        }
    }

    Object object;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LearnMain)) return false;
        LearnMain learnMain = (LearnMain) o;
        return Objects.equals(object, learnMain.object);
    }

    @Override
    public int hashCode() {
        return Objects.hash(object);
    }
}

