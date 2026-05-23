package it.unibo.shapes.impl;

import it.unibo.shapes.api.Polygon;

public class Rectangle implements Polygon{

    private double base;
    private double height;
    static final int RECTANGLE_EDGES = 4;

    public Rectangle(final double base, final double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return this.base * this.height;
    }

    @Override
    public double getPerimeter() {
        return (this.base + this.height) * 2;
    }

    @Override
    public int getEdgeCount() {
        return RECTANGLE_EDGES;
    }
    
}
