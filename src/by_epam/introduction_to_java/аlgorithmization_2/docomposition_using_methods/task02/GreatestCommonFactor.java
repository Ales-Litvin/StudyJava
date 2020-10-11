package by_epam.introduction_to_java.аlgorithmization_2.docomposition_using_methods.task02;

public class GreatestCommonFactor {
    public static void main(String[] args) {
        System.out.println(greatestCommonFactors(12, 36, 102, 14));

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

    public static int greatestCommonFactors(int ... a){
        int result = greatestCommonFactor(a[0], a[1]);
        for (int i = 2; i < a.length; i++){
            result = greatestCommonFactor(a[i], result);
        }
        return result;
    }

}
