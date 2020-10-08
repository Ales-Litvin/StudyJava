package by_epam.algorithmization_2.docomposition_using_methods.task04;

/*
 * Условие задачи:
 * 4. На плоскости заданны своими координатами n точек. Написать метод (методы), определяющие,
 *    между какими из пар точек самое большое расстояние. Указание. Координаты точек занести в массив.
 */

public class Solution {
    public static void main(String[] args) {
        int[][] points = {
                //x
                {1,  3, 0, 4},
                //y
                {2, -4, 0, 7}};

        isMaxDistance(points);
    }

    /**
     * Calculates the max distance between points and prints result
     * @param points a array of points
     * @return max distance between points
     */
    public static double isMaxDistance(int[][] points){
        int x1 = points[0][0];
        int y1 = points[1][0];
        int x2 = points[0][1];
        int y2 = points[1][1];

        double maxDistance = isDistance(x1, y1, x2, y2);

        for (int i = 0; i < points.length; i++){
            for (int j = 0; j < points[1].length; j++){
                if (maxDistance < isDistance(points[0][i], points[1][i], points[0][j], points[1][j])){

                    maxDistance = isDistance(points[0][i], points[1][i], points[0][j], points[1][j]);

                    x1 = points[0][i];
                    y1 = points[1][i];
                    x2 = points[0][j];
                    y2 = points[1][j];
                }
            }
        }
        System.out.printf("Point 1 : [%d,%d]\n" +
                "Point 2 : [%d,%d]\n" +
                "Distance : %f", x1, y1, x2, y2, maxDistance);
        return maxDistance;
    }


    /**
     * Calculates the distance between points
     * @param x1 coordinate 'x' of the first point
     * @param y1 coordinate 'y' of the first point
     * @param x2 coordinate 'x' of the second point
     * @param y2 coordinate 'y' of the second point
     * @return distance between points first and second
     */
    public static double isDistance(int x1, int y1, int x2, int y2){
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
}
