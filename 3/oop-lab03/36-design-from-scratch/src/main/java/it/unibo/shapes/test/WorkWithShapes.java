package it.unibo.shapes.test;

import it.unibo.shapes.impl.Circle;
import it.unibo.shapes.impl.Rectangle;
import it.unibo.shapes.impl.Square;
import it.unibo.shapes.impl.Triangle;

public class WorkWithShapes {

    public static void main(String[] args) {
        //creo una struttura per tipo
        Circle shapeCircle = new Circle(2.1);
        Square shapeSquare = new Square(3);
        Rectangle shapeRectangle = new Rectangle(2, 3);
        Triangle shapeTriangle = new Triangle(2, 3);
        Triangle shapeTriangle2 = new Triangle(2, 3, 4);
        Triangle shapeTriangle3 = new Triangle(2, 3, 4, 5);

        //ricavo i permiteri
        System.out.println("Circle perimeter: " + shapeCircle.getPerimeter());
        System.out.println("Square perimeter: " + shapeSquare.getPerimeter());
        System.out.println("Rectangle perimeter: " + shapeRectangle.getPerimeter());
        System.out.println("Triangle perimeter: " + shapeTriangle.getPerimeter());
        System.out.println("Triangle2 perimeter: " + shapeTriangle2.getPerimeter());
        System.out.println("Triangle3 perimeter: " + shapeTriangle3.getPerimeter());

        //ricavo le aree
        System.out.println("Circle area: " + shapeCircle.getArea());
        System.out.println("Square area: " + shapeSquare.getArea());
        System.out.println("Rectangle area: " + shapeRectangle.getArea());
        System.out.println("Triangle area: " + shapeTriangle.getArea());
        System.out.println("Triangle2 area: " + shapeTriangle2.getArea());
        System.out.println("Triangle3 area: " + shapeTriangle3.getArea());
    
    }
}
