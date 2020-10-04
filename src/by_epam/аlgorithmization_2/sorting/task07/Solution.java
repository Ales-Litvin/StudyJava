package by_epam.аlgorithmization_2.sorting.task07;

public class Solution {
    public static void main(String[] args) {
        int[] arrayOne = {1, 4, 8, 10, 12, 14, 20, 26, 30, 36};
        int[] arrayTwo = {1, 4, 3, 3, 6, 7, 10, 20};

        isIndexOfInsert(arrayOne, 3);
        isIndexOfInsert(arrayOne, 11);
    }

    public static void isIndexOfInsert(int[] array, int key){
        for (int i = 1; i < array.length; i++){
            if (array[i - 1] <= key && array[i] > key){
                System.out.println(i);
                break;
            }
        }
    }
}
