package by_epam.introduction_to_java.аlgorithmization_2.docomposition_using_methods.task14;

public class Armstrong {
    public static void main(String[] args) {
        searchArmstrongNumber(10000);
    }

    public static void searchArmstrongNumber(int k){
        for (int i = 1; i < k; i++){
            if (isArmstrongNumbers(i)){
                System.out.println(i);
            }
        }
    }

    public static boolean isArmstrongNumbers(int number){
        long sum = 0;
        String string = String.valueOf(number);

        for (char c : string.toCharArray()){
            sum = sum + power(Integer.parseInt(String.valueOf(c)), string.length());
        }

        if (sum == number) {
            return true;
        } else {
            return false;
        }
    }

    public static int power(int number, int power){
        int result = 1;
        while (power != 0){
            result = result * number;
            power--;
        }
        return result;
    }
}
