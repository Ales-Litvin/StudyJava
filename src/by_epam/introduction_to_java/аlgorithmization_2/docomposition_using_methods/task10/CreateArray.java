package by_epam.introduction_to_java.аlgorithmization_2.docomposition_using_methods.task10;

import java.util.Arrays;

public class CreateArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(toArray(13548135)));
    }

    public static int[] toArray(int n){
        String string = String.valueOf(n);
        char[] chars = string.toCharArray();

        int[] result = new int[string.length()];

        for (int i = 0; i <  chars.length; i++){
            result[i] = Integer.parseInt(String.valueOf(chars[i]));
        }
        return result;
    }

}
