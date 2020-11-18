package javarush.task.task39.task3905;

import java.awt.*;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class PhotoPaint {
    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {
        if (!checkPoint(image, x, y, null, desiredColor)) return false;

        Queue<Point> points = new LinkedBlockingQueue<>();
        points.add(new Point(x, y));

        Color findColor = image[y][x];

        Point point;
        while ((point = points.poll()) != null){
            image[point.y][point.x] = desiredColor;

            if (checkPoint(image, point.x + 1, point.y, findColor, desiredColor )){
                points.add(new Point(point.x + 1, point.y));
            }
            if (checkPoint(image, point.x - 1, point.y, findColor, desiredColor )){
                points.add(new Point(point.x - 1, point.y));
            }
            if (checkPoint(image, point.x, point.y + 1, findColor, desiredColor )){
                points.add(new Point(point.x, point.y + 1));
            }
            if (checkPoint(image, point.x, point.y - 1, findColor, desiredColor )){
                points.add(new Point(point.x, point.y - 1));
            }
        }

        image[y][x] = desiredColor;
        return true;
    }


    private boolean checkPoint(Color[][] image, int x, int y, Color colorFind, Color desiredColor) {
        boolean firstCheck =
                image != null &&
                desiredColor != null &&
                y >= 0 &&
                y < image.length &&
                x >= 0 &&
                x < image[y].length;

        if (colorFind == null) {
            return firstCheck && image[y][x] != desiredColor;
        } else {
            return firstCheck && image[y][x] == colorFind;
        }
    }
}