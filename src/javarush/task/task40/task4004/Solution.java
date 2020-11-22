package javarush.task.task40.task4004;

import java.util.ArrayList;
import java.util.List;

/*
Принадлежность точки многоугольнику
*/

class Point {
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Vector {
    public int x;
    public int y;
    public int z;

    Vector(int x, int y) {
        this.x = x;
        this.y = y;
        this.z = 0;
    }

    Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Solution {
    public static void main(String[] args) {
        List<Point> polygon = new ArrayList<>();
        polygon.add(new Point(0, 0));
        polygon.add(new Point(0, 10));
        polygon.add(new Point(10, 10));
        polygon.add(new Point(10, 0));

        System.out.println(isPointInPolygon(new Point(5, 5), polygon));
        System.out.println(isPointInPolygon(new Point(100, 100), polygon));


        List<Point> polygon_Two = new ArrayList<>();
        polygon.add(new Point(118, 513));
        polygon.add(new Point(163, 286));
        polygon.add(new Point(281, 185));
        polygon.add(new Point(319, 275));
        polygon.add(new Point(445, 227));
        polygon.add(new Point(374, 554));
        polygon.add(new Point(230, 600));

        System.out.println(isPointInPolygon(new Point(239, 300), polygon)); // true
        System.out.println(isPointInPolygon(new Point(353, 414), polygon)); // true
        System.out.println(isPointInPolygon(new Point(820, 370), polygon)); // false


        List<Point> polygon_Three = new ArrayList<>();
        polygon.add(new Point(20, 20));
        polygon.add(new Point(600, 20));
        polygon.add(new Point(330, 180));
        polygon.add(new Point(20, 400));

        System.out.println(isPointInPolygon(new Point(150, 150), polygon)); // true
        System.out.println(isPointInPolygon(new Point(120, 250), polygon)); // true
        System.out.println(isPointInPolygon(new Point(600, 400), polygon)); // false

    }

    public static boolean isPointInPolygon(Point point, List<Point> polygon) {
        // Используется метод индекса точки
        // устанавливаем сумму углов равным '0'

        int sumAngles = 0;
        for (int i = 0; i < polygon.size(); i++){
            Point point1 = polygon.get(i);

            Point point2;
            if (i == polygon.size()  - 1){
                point2 = polygon.get(0);
            } else {
                point2 = polygon.get(i + 1);
            }

            Vector vector1 = new Vector(
                    point1.x - point.x,
                    point1.y - point.y);

            Vector vector2 = new Vector(
                    point2.x - point.x,
                    point2.y - point.y);

            Vector multiply = vectorMultiply(vector1, vector2);

            /*
             * Для более коректной работы следует определится с знаками:
             * Векторное произведение этих же векторов смотрит на нас, значит
             * прибавляем к сумме.
             */
            double angleBetweenVectors = angleBetweenVectors(vector1, vector2);

            if (multiply.z > 0){
                sumAngles -= angleBetweenVectors;
            } else {
                sumAngles += angleBetweenVectors;
            }
        }

        int indexPoint = sumAngles / 360;

        return indexPoint == -1 || indexPoint == 1;
    }

    public static double angleBetweenVectors(Vector one, Vector two){
        double cos = scalarMultiply(one, two) / (moduleVector(one) * moduleVector(two));
        double rad = Math.acos(cos);
        return rad * (360 / (2 * Math.PI ));
    }

    public static Vector vectorMultiply(Vector one, Vector two){
        int i = one.y * two.z - one.z * two.y;
        int j = one.z * two.x - one.x * two.z;
        int k = one.x * two.y - one.y * two.x;
        return new Vector(i, j, k);
    }

    private static int scalarMultiply(Vector one, Vector two){
        return one.x * two.x + one.y * two.y;
    }

    private static double moduleVector(Vector vector){
        return Math.sqrt(
                vector.x * vector.x +
                vector.y * vector.y +
                vector.z * vector.z);
    }
}
