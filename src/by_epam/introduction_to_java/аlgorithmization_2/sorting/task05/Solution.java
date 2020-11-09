package by_epam.introduction_to_java.аlgorithmization_2.sorting.task05;

/*
 * Условие задчи:
 * 5. Сортировка вставками. Дана последовательность числе а(1), а(2),...,а(n). Требуется переставить числа в порядке
 * возрастания. Делается это следующим образом. Пусть a(1), a(2),...,а(i) - упорядоченная последоваетльность. т.е.
 * a(1)<=a(2)<=...<=a(n). Берется следующее число a(i+1) и вставляется в последовательность так, чтобы новая
 * последовательность была тоже возврастающей. Процесс производится до тех пор, пока все элементы от i+1 до n не будут
 * перебраны. Примечание. Место помещения очередного элемента в отсортированную часть производить с помощью двоичного
 * поиска. Двоичный поиск оформить в виде отдельной функции.
 */

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        testSort(20);
    }

    /**
     * Sorts array use method "sorting inserting" with binary search.
     * @param array the array to be sorting.
     */
    public static void insertionSort(int[] array){
        for (int i = 1; i < array.length; i++){
            if (array[i - 1] > array[i]){
                int index = binarySearch(array, array[i], 0, i - 1); // change element
                insertAndShift(array, index, i);
            }
        }
    }

    /**
     * Inserts and shifts element with index {@param index} to index {@param j}
     * @param array the array to be sorted
     * @param index index for insert value to array
     * @param j index beginner element
     */
    public static void insertAndShift(int[] array, int index, int j){
            int data = array[j];
            for (int i = j - 1; i >= index; i--) {
                array[i + 1] = array[i];
            }
            array[index] = data;
    }

    /**
     * Searches a index using the binary search algorithm.
     * @param sortedArray the array.
     * @param key the value to be searched for.
     * @param low the index of the first element (inclusive) to be
     *            searched.
     * @param high the index of the last element to be searched.
     * @return index of the search key.
     */
    public static int binarySearch(int[] sortedArray, int key, int low, int high){
        int index = -1;
        int length = high;
        while (low <= high) {
            int mid = (low + high) / 2;            if (sortedArray[mid] < key){
                low = mid + 1;
            } else if (sortedArray[mid] > key){
                high = mid - 1;
            } else if (sortedArray[mid] == key){
                index = mid;
                break;
            }

            if (mid == 0 && low == 0) {
                return 0;
            } else if (mid == 0 && length % 2 == 0){
                return 1;
            } else if (mid == 0){
                return 0;
            } else if (mid == high){
                return high;
            } else if (sortedArray[mid - 1] < key && sortedArray[mid] > key){
                return index = mid;
            } else if (sortedArray[mid] < key && sortedArray[mid + 1] > key ){
                return index = mid + 1;
            }
        }
        return index;
    }

    /**
     * Returns a random array
     * @return a random array
     */
    public static int[] getRandomArray(){
        int[] array = new int[(int) (Math.random() * 100)];
        for (int i = 0; i < array.length; i++){
            array[i] = (int) (Math.random() * 100);
        }
        return array;
    }

    /**
     * Tests work method "insertionSort"
     * @param n a count of arrays for testing
     */
    public static void testSort(int n){
        for (int i = 0; i < n; i++){
            int[] randomArray = getRandomArray();
            insertionSort(randomArray);

            int[] sorArray = Arrays.copyOf(randomArray, randomArray.length);
            Arrays.sort(sorArray);

            if (Arrays.equals(randomArray, sorArray)){
                System.out.println("Method 'insertionSort' works right : ");
                System.out.println(Arrays.toString(randomArray));
                System.out.println("============================");
            }
        }
    }
}
