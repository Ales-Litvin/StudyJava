package by_epam.аlgorithmization_2.subroutines.task17;

public class SumNumbers {
    public static void main(String[] args) {
        System.out.println(countOperation(1238934));
    }

    public static int countOperation(int number){
        int count = 0;
        while (number != 0){
            number -= sumNumbers(number);
            count++;
        }
        return count;
    }


    public static int sumNumbers(int number){
        int result = 0;
        for (char c : String.valueOf(number).toCharArray()){
            result += Integer.parseInt(String.valueOf(c));
        }
        return result;
    }

}
