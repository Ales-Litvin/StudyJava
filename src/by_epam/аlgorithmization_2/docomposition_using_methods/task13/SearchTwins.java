package by_epam.аlgorithmization_2.subroutines.task13;

public class SearchTwins {
    public static void main(String[] args) {
        searchTwins(34);

    }

    public static void searchTwins(int n){
        for (int i = 2; i < 2 * n; i++){
            if ((i + 2) < (2 * n)){
                printIfAreTwins(i, i + 2);
            }
        }
    }

    public static void printIfAreTwins(int a, int b){
            System.out.println("[" + a + ", " + b + "]");
    }
}
