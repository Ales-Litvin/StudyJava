package javarush.task.task20.task2025;

/*
Алгоритмы числа
 */

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static long[] getNumbers(long N) {
        long[] result = null;
        if (N >= 0L) {
            Set<Long> set = new TreeSet<>();
            for (long i = 0; i < N; i++) {

                if (i == numberSum(i)) {
                    set.add(i);
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

    // подсчет суммы числа "армстронга"
    public static long numberSum(long n){
        long l = 0L;
        int length = getCountsOfDigits(n);
        for (int s : getOfNumbers(n, length)){
            l = l + numberExtent(s, length);
        }
        return l;
    }

    /*
    проверка что любая цифра не меньше предыдущей и не больше последующей. Например: 12, 1557, 333 и т.д.
     */
    public static boolean ArraySort(int[] array){
        boolean ifArraySort = false;
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
    public static long numberExtent(long n, int extent){
        long result = n;
        for (int i = 1; i < extent; i++){
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
        System.out.println(Arrays.toString(getNumbers(100_000_000)));
        //System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
    }
}
