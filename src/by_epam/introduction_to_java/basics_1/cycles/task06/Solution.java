package by_epam.introduction_to_java.basics_1.cycles.task06;

/*
 * Условие задачи:
 * 6. Вывести на экран соответствий между символами и их численными
 *    обозначениями в памяти компьютера.
 */
public class Solution {
    public static void main(String[] args) {
        printAllSymbol();
    }

    /**
     * Prints symbol and his code.
     */
    public static void printAllSymbol(){
        for (int i = 0; i <= 6500; i++){
            char c = (char) i;
            System.out.println(i + " - " + "'" + c + "'");
        }
    }
}