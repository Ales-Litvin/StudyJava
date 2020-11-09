package by_epam.introduction_to_java.аlgorithmization_2.docomposition_using_methods.task08;

/*
 * Условие задачи:
 * 8. Задан массив D. Определить следующие суммы:
 *    D[1] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6].
 *    Пояснение.  Составить  метод(методы)  для вычисления суммы трех
 *    последовательно расположенных элементов массива с номерами от k до m.
 */

public class SumElements {
    public static void main(String[] args) {
        int[] d = {1, 2, 3, 4, 5, 6, 9, 8, 7};

        System.out.println(sum(d, 3, 5));

    }

    public static int sum(int[] array, int fromIndex, int toIndex){
        int result = 0;
        for (int i = fromIndex; i < toIndex; i++){
            result += array[i];
        }
        return result;
    }
}
