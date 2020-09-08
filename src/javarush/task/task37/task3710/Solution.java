package javarush.task.task37.task3710;

import javarush.task.task37.task3710.decorators.RedShapeDecorator;
import javarush.task.task37.task3710.shapes.Circle;
import javarush.task.task37.task3710.shapes.Rectangle;
import javarush.task.task37.task3710.shapes.Shape;

/*
Decorator
*/
public class Solution {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("Simple circle");
        circle.draw();

        System.out.println("\nApplied RedShapeDecorator to the circle");
        redCircle.draw();

        System.out.println("\nApplied RedShapeDecorator to the rectangle");
        redRectangle.draw();
    }
}