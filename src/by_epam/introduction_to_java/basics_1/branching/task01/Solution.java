package by_epam.basics_1.branching.task01;

public class Solution {
    public static void main(String[] args) {
        int angleOne = 45;
        int angleTwo = 45;
        if (180 - (angleOne + angleTwo) > 0){
            System.out.print("Треугольни существует и он - ");
            if (180 - (angleOne + angleTwo) == 90){
                System.out.print("прямоуольный");
            } else {
                System.out.print("не прямоуольный");
            }
        }
    }
}
