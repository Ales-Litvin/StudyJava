package by_epam.аlgorithmization_2.subroutines.task11;

public class IsLonger {
    public static void main(String[] args) {
        System.out.println(isLonger(+12, 321));
    }

    public static int isLonger(int a, int b){
        return String.valueOf(a).length() > String.valueOf(b).length() ? a : b;
    }


}
