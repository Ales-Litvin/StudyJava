package by_epam.аlgorithmization_2.subroutines.task08;

public class SumElements {
    public static void main(String[] args) {
        int[] arrayOne = {1, 2, 3, 4, 5, 6};

    }

    public static int sumElements(int[] array, int fromIndex, int toIndex){
        int result = 0;
        for (int i = fromIndex; i < toIndex; i++){
            result += array[i];
        }
        return result;
    }
}
