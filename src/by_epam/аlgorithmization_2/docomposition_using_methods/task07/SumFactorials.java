package by_epam.аlgorithmization_2.subroutines.task07;

public class SumFactorials {
    public static void main(String[] args) {
        System.out.println(factorial(1));
        System.out.println(sumFactorialsAllOdd(1, 9));

    }

    public static int sumFactorialsAllOdd(int from, int to){
        int result = 0;
        for (int i = from; i < to; i++){
            if (i % 2 != 0){
                result += factorial(i);
            }
        }
        return result;
    }

    public static int factorial(int a){
        if (a != 1){
            return a = a * factorial(a - 1);
        } else {
            return 1;
        }
    }


}
