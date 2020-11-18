package javarush.task.task39.task3905;

import java.util.Arrays;

public class TestPhotoPaint {
    public static void main(String[] args) {
        test();
    }

    private static final int MAX_SIZE = 15;
    private static final int COUNT_TESTS = 3;

    public static Color[][] getRandomColorMatrix(int order, Color color){
        int size = order == 0 ? (int) (Math.random() * MAX_SIZE) : order;
        Color[][] paint = new Color[size][size];
        if (color != null){
            randomFilingMatrix(paint, color);
        } else {
            randomFilingMatrix(paint);
        }
        return paint;
    }

    private static Color getRandomColor(){
        Color[] colors = Color.values();
        return colors[(int) (Math.random() * colors.length)];
    }

    public static void randomFilingMatrix(Color[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = getRandomColor();
            }
        }
    }

    public static void randomFilingMatrix(Color[][] matrix, Color color){
        for (Color[] colors : matrix) {
            Arrays.fill(colors, color);
        }
    }

    public static void printMatrix(Color[][] matrix){
        for (Color[] colors : matrix){
            System.out.println(Arrays.toString(colors));
        }
    }

    public static void test(){
        for (int i = 0; i < COUNT_TESTS; i++){
            Color[][] paint = getRandomColorMatrix(0, null);
            printMatrix(paint);

            PhotoPaint photoPaint = new PhotoPaint();


            int randomX = (int) (Math.random() * paint.length);
            int randomY = (int) (Math.random() * paint.length);
            Color color = getRandomColor();

            System.out.printf(
                    "Paints x:%d, y:%d to %s color\n",
                    randomX, randomX, color.toString());

            photoPaint.paintFill(paint, randomX, randomY, color);

            printMatrix(paint);
        }
    }


}
