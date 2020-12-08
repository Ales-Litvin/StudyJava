package learn.main;

public class Point {
    public int x;
    public int y;
    

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        Point p = (Point) obj;
        return x == p.x && y == p.y;
    }
}