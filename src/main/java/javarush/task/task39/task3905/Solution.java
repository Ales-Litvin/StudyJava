package javarush.task.task39.task3905;

import java.util.Random;

import static javarush.task.task39.task3905.Color.BLUE;
import static javarush.task.task39.task3905.Color.ORANGE;


/*
Залей меня полностью
*/

public class Solution {
    public static void main(String[] args) {
        Color[][] image = new Color[][] { {BLUE} };
        new PhotoPaint().paintFill(image, 0, 0, ORANGE);
        System.out.println(image[0][0].name());

        Color[][] paint = TestPhotoPaint.getRandomColorMatrix(5, null);
        TestPhotoPaint.printMatrix(paint);

        System.out.println("========================");

        new PhotoPaint().paintFill(paint, 0, 0, ORANGE);
        TestPhotoPaint.printMatrix(paint);
    }
}