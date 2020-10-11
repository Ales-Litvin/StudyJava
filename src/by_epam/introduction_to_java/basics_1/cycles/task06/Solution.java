package by_epam.basics_1.cycles.task06;

public class Solution {
    public static void main(String[] args) {
        printAllSymbol();
    }

    public static void printAllSymbol(){
        for (int i = 0; i <= 6500; i++){
            char c = (char) i;
            System.out.println(i + " - " + "'" + c + "'");
        }
    }
}