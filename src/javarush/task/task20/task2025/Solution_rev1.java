package javarush.task.task20.task2025;

/*
Алгоритмы числа
 */

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Solution_rev1 {
    public static long[] getNumbers(long N) {
        long[] result = null;
        if (N >= 0L) {
            Set<Long> set = new TreeSet<>();
            for (long i = 0; i < N; i++) {
                int length = getCountsOfDigits(i);
                int [] array = getOfNumbers(i, length);
                if(ArraySort(array, length)){
                    long number = numberSum(array, length);
                    if (number <= N) {
                        int length_2 = getCountsOfDigits(number);
                        int [] array_2 = getOfNumbers(number, length_2);
                        long number_2 = numberSum(array_2, length_2);
                        if (number == number_2) {
                            set.add(number);
                        }
                    }
                }
            }

            result = new long[set.size()];
            int i = 0;
            for (long s : set) {
                result[i] = s;
                i++;
            }
        }
        return result;
    }

    // подсчет суммы числа "армстронга" при выполнении условия метода ArraySort
    public static long numberSum(int [] array, int length){
        long l = 0L;
            for (int s : array){
                l = l + numberExtent(s, length);
            }
        return l;
    }

    /*
    проверка что любая цифра не меньше предыдущей
    и не больше последующей.
    Например: 12, 1557, 333 и т.д.
     */
    public static boolean ArraySort(int[] array, int length){
        boolean ifArraySort = false;
        if (length == 1)
            return true;
        for (int i = 0; i < array.length - 1; i++){
            if (array[i] <= array[i+1]) {
                ifArraySort = true;
            }
            else {
                ifArraySort = false;
                break;
            }
        }
        return ifArraySort;
    }


    // возведение числа в степень
    public static long numberExtent(int n, int length){
        long result = n;
        for (int i = 1; i < length; i++){
            result = result * n;
        }
        return result;
    }

    // получение массива чисел
    public static int[] getOfNumbers(long n, int i){
        int[] result = new int[i];
        while(n > 0L){
            result[i - 1] = (int) (n % 10);
            i--;
            n /= 10;
        }
        return result;
    }

    // нахождение длинны числа
    public static int getCountsOfDigits(Long n) {
        int count = (n == 0) ? 1 : 0; while (n != 0) {
            count++; n /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
        //System.out.println(numberSum(new int[]{1,2,5}, 3));
        //System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
    }
}