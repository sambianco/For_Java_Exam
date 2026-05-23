package it.unibo.shapes.impl;

import it.unibo.shapes.api.Polygon;

public class Square implements Polygon{

    private double side;
    static final int SQUARE_EDGES = 4;

    public Square(final double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return side * 4;
    }

    @Override
    public int getEdgeCount() {
        return SQUARE_EDGES;
    }
    
}
