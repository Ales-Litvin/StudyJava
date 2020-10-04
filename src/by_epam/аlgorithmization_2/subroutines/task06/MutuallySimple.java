package by_epam.аlgorithmization_2.subroutines.task06;

public class MutuallySimple {
    public static void main(String[] args) {
        System.out.println(areMutuallySimple(6 , 8, 9));
        System.out.println(areMutuallySimple(8 , 15, 19));

        System.out.println(isGreatestCommonFactor(6 ,8));

    }

    /*
     * Нахождение НОД трех и большего количества чисел

     * Нахождение наибольшего общего делителя трех и большего количества чисел
     *  может быть сведено к последовательному нахождению НОД двух чисел.
     *  Мы об этом упоминали, при изучении свойств НОД.
     *  Там мы сформулировали и доказали теорему:
     *  наибольший общий делитель нескольких чисел a1, a2, …, ak равен числу dk,
     *  которое находится при последовательном вычислении НОД(a1, a2)=d2,
     *  НОД(d2, a3)=d3, НОД(d3, a4)=d4, …, НОД(dk-1, ak)=dk.
     */

    public static boolean areMutuallySimple(int a, int b, int c){
        return isGreatestCommonFactor(isGreatestCommonFactor(a, b), c) == 1;
    }

    public static int isGreatestCommonFactor(int a, int b){
        if (a != 0 && b != 0){
            if (a > b){
                a = a % b;
            } else {
                b = b % a;
            }
            return isGreatestCommonFactor(a, b);
        } else {
            return a + b;
        }
    }
}
