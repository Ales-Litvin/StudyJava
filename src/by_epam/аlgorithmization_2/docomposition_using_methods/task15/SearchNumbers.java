package by_epam.аlgorithmization_2.subroutines.task15;

public class SearchNumbers {
    public static void main(String[] args) {
        searchIncreasingSequence(0, Integer.MAX_VALUE);
    }

    public static void searchIncreasingSequence(int from, int to){
        for (int i = from; i < to; i++){
            if (isIncreasingSequence(i)){
                System.out.println(i);
            }
        }
    }

    public static boolean isIncreasingSequence(int n){
        char[] chars = String.valueOf(n).toCharArray();
        for (int i = 1; i < chars.length; i++){
            int numberOne = Integer.parseInt(String.valueOf(chars[i - 1]));
            int numberTwo = Integer.parseInt(String.valueOf(chars[i]));
            if (numberOne >= numberTwo) return false;
        }
        return true;
    }
}
