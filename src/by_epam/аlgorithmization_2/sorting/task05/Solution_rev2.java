package by_epam.algorithmization_2.sorting.task05;

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

public class Solution_rev2 {
    public static void main(String[] args) {
        int[] arrayOne = {1, 5, 8, 9, 4, 3, 5, 7, 20, 4};
        int[] arrayTwo = {1, 4, 5, 8, 8, 10, 12, 16, 18, 20, 22};
        int[] arrayThree = {1, 2, 4, 3, 5, 16, 22, 12, 17, 20, 4};
        int[] arrayFour = {1, 4, 5, 8, 9, 3, 22, 12, 17, 20, 4};
        int[] arrayFive = {2, 5, 8, 10, 4, 3, 30, 22, 15, 220, 4, 1, 5, 8, 9, 4, 3, 5, 7, 20, 4};
        /*
        System.out.println(binarySearch(arrayThree, 4, 0, 6));
        System.out.println(binarySearch(arrayOne, 4, 0, 3));
        System.out.println(binarySearch(arrayFour, 3, 0, 4));
        */
        System.out.println(binarySearch(arrayFive, 1, 0, 2));

        myInsertionSortTwo(arrayOne);
        myInsertionSortTwo(arrayTwo);
        myInsertionSortTwo(arrayThree);
        myInsertionSortTwo(arrayFour);
        myInsertionSortTwo(arrayFive);

        System.out.println(Arrays.toString(arrayOne));
        System.out.println(Arrays.toString(arrayTwo));
        System.out.println(Arrays.toString(arrayThree));
        System.out.println(Arrays.toString(arrayFour));
        System.out.println(Arrays.toString(arrayFive));

    }



    // This just sort, it don't has binarySearch
    public static void myInsertionSort(int[] array){
        // Start with first element, because it's sorting
        for (int i = 1; i < array.length; i++){
            for (int j = i; j > 0 && array[j - 1] > array[j]; j--){
                swap(array, j - 1, j); // change element
            }
        }
    }

    // This method change element
    public static void swap(int[] array, int first, int second){
        int data = array[first];
        array[first] = array[second];
        array[second] = data;
    }

    public static void myInsertionSortTwo(int[] array){
        for (int i = 1; i < array.length; i++){
            for (int j = i; j > 0 && array[j - 1] > array[j]; j--){
                int index = binarySearch(array, array[j], 0, j); // change element
                insertAndShift(array, index - 1, j);
                break; // if called method "insertAndShift"
            }
        }

    }


    public static void insertAndShift(int[] array, int index, int j){
        int data = array[j];
        for (int i = j - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = data;
    }

    public static int indexForInsertFromTo(int[] array, int j){
        int value = array[j];
        int index = ((j - 1) / 2) - 1;
        while (true){
            if (array[index] == value) return index;

            if (array[index] <= value && array[index + 1] >= value) return index;
            if (array[index] >= value && array[index - 1] <= value) return index - 1;

            if (array[index] < value){
                index = (index + index / 2) - 1;
            } else {
                index = (index / 2) + 1;
            }
        }
    }

    // low - низкий
    // high - высокий
    // I think it was GOOD, very good. Eea
    // Use this method for binary Search
    public static int binarySearch(int[] sortedArray, int key, int low, int high){
        int index = -1;

        while (low < high) {
            int mid = (low + high) / 2; // middle
            if (sortedArray[mid] < key){
                low = mid + 1;
                if (mid == 0) return 0; // This String need delete for correct work method
                index = mid + 1; // This String need delete for correct work method
            } else if (sortedArray[mid] > key){
                high = mid - 1;
                if (mid == 0) return 0; // This String need delete for correct work method
                index = mid + 1; // This String need delete for correct work method
            } else if (sortedArray[mid] == key){
                index = mid;
                break;
            }
        }
        return index;
    }

    public static int indexForInsert(int[] array, int value){
        int index = (array.length / 2) - 1;
        while (true){
            if (array[index] == value) return index;

            if (array[index] < value && array[index + 1] > value) return index;
            if (array[index] > value && array[index - 1] < value) return index;

            if (array[index] < value){
                index = (index + index / 2) - 1;
            } else {
                index = (index / 2) + 1;
            }
        }
    }
}
