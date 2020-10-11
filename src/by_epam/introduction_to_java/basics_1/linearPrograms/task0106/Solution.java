package by_epam.basics_1.linearPrograms.task0106;

public class Solution {
    public static void main(String[] args) {
        int x = -3;
        int y = -2;

        if (0 <= y && y < 4 && -2 < x && x < 2){
            System.out.println(true);
        } else if (0 >= y && y > -3 && -4 < x && x < 4){
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
