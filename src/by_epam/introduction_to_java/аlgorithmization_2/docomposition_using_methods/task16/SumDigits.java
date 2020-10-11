package by_epam.introduction_to_java.аlgorithmization_2.docomposition_using_methods.task16;

public class SumDigits {
    public static void main(String[] args) {
        System.out.println(sumNumber(4));
    }


    public static int sumNumber(int n){
        int result = 0;
        for (int i = initialValue(n); i < initialValue(n) * 10; i++){
            result += sumNumbersContainsOdd(i);
        }

        System.out.println("Количество четных цифр : " + countOdd(result));

        return result;
    }

    public static int sumNumbersContainsOdd(int number){
        int result = 0;

        for (char c : String.valueOf(number).toCharArray()){
            int n = Integer.parseInt(String.valueOf(c));

            if (n % 2 == 0 && n != 0){
                result += n;
            } else {
                return 0;
            }
        }
        return result;
    }

    public static int initialValue(int n){
        int result = 1;
        n--;
        while (n != 0){
            result = result * 10;
            n--;
        }
        return result;
    }

    public static int countOdd(int number){
        int result = 0;
        for (char c : String.valueOf(number).toCharArray()){
            int n = Integer.parseInt(String.valueOf(c));

            if (n % 2 == 0 && n != 0){
                result++;
            }
        }
        return result;
    }
}
