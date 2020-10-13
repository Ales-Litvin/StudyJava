package by_epam.introduction_to_java.programming_with_classes_4.simplest_classes_and_objects.task07;

/*
 * Условие задачи:
 * 7. Описать класс, представлющий треугольник.
 *    Предусмотреть методы для создания объектов, вычисления площади, периметра и точки пересечения медиан.
 */
public class Triangle {
    // method for testing
    public static void main(String[] args) throws Exception {
        // Создаем треугольник
        Triangle triangle = new Triangle(0,0,0,4,4,0);

        // Площадь треугольника
        System.out.println("Area : " + triangle.getArea());

        // Периметр треугольника
        System.out.println("Perimeter : " + triangle.getPerimeter());

        // Точка пересечения треугольника
        System.out.println("Medians' intersection point : " + triangle.getMedianIntersectionPoint());

        // Пытаемся создать не существующий треугольник
        System.out.println(new Triangle(0,2,0,3,0,8));
    }

    private final Point a;
    private final Point b;
    private final Point c;

    public Triangle(int x_1, int y_1, int x_2, int y_2, int x_3, int y_3) throws Exception {
        this.a = new Point(x_1,y_1);
        this.b = new Point(x_2,y_2);
        this.c = new Point(x_3,y_3);
        if (areOnStraightLine()){
            throw new Exception("Triangle with points : " +
                    a + ", " + c + ", " + b +
                    " can not exist.");
        }
    }

    /**
     * Checks points are on straight line or isn't.
     * @return true if points are on straight line, else false.
     */
    private boolean areOnStraightLine(){
        return (a.x - b.x) * (c.y - b.y) == (c.x - b.x) * (a.y - b.y);
    }

    /**
     * Returns the medians' intersection point.
     * @return the medians' intersection point.
     */
    public Point getMedianIntersectionPoint(){
        double x = (a.x + b.x + c.x) / 3;
        double y = (a.y + b.y + c.y) / 3;
        return new Point(x,y);
    }

    /**
     * Returns the area of the triangle.
     * @return the area of the triangle.
     */
    public double getArea(){
        return 0.5d * Math.abs((a.x - c.x)*(b.y - c.y)-(b.x - c.x)*(a.y-c.y));
    }

    /**
     * Returns the perimeter of the triangle.
     * @return the perimeter of the triangle.
     */
    public double getPerimeter(){
        return Point.isDistance(a,b) + Point.isDistance(b,c) + Point.isDistance(c,a);
    }

    /**
     * This class describe of the point
     */
    static class Point{
        double x; // coordinate X
        double y; // coordinate Y

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return Double.compare(point.x, x) == 0 &&
                    Double.compare(point.y, y) == 0;
        }

        @Override
        public String toString() {
            return "[" + x + ", " + y + "]";
        }

        /**
         * Returns distance between points first and second.
         * @param a the point first
         * @param b the point second
         * @return distance between points first and second.
         */
        public static double isDistance(Point a, Point b){
            double result = Math.sqrt((b.x - a.x)*(b.x - a.x) + (b.y - a.y)*(b.y - a.y));
            return result;
        }
    }

}
