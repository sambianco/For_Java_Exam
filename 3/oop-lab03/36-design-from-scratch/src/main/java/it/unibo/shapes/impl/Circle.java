package it.unibo.shapes.impl;

import it.unibo.shapes.api.Shape;

public class Circle implements Shape{

    private double radius;

    public Circle(final double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }
    
}
