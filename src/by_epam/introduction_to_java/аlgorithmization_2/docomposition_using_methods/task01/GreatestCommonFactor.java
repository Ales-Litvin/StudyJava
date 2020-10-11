package by_epam.introduction_to_java.аlgorithmization_2.docomposition_using_methods.task01;

public class GreatestCommonFactor {
    public static void main(String[] args) {
        System.out.println(greatestCommonFactor(12,36));

        System.out.println(leastCommonDivisor(12,36));
    }


    public static int greatestCommonFactor(int a, int b){
        if (a != 0 && b != 0){
            if (a > b){
                a = a % b;
            } else {
                b = b % a;
            }
            return greatestCommonFactor(a, b);
        } else {
            return a + b;
        }
    }

    public static int leastCommonDivisor(int a, int b){
        return (a * b) / greatestCommonFactor(a, b);
    }

}
