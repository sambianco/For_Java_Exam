package it.unibo.shapes.impl;

import it.unibo.shapes.api.Polygon;

public class Triangle implements Polygon{

    private double base;
    private double height;
    static final int TRIANGLE_EDGES = 3;
    private double sideA;
    private double sideB;

    //costruttori che modellano un triangolo euqilatero, scaleno, isoscele
    public Triangle(final double base, final double height, final double sideA, final double sideB) {
        this.base = base;
        this.height = height;
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public Triangle(final double base, final double height, final double sideA) {
        this.base = base;
        this.height = height;
        this.sideA = sideA;
        this.sideB = sideA;
    }

    public Triangle(final double base, final double height) {
        this.base = base;
        this.height = height;
        this.sideA = base;
        this.sideB = base;
    }


    @Override
    public double getArea() {
        return (this.base * this.height) / 2;
    }

    @Override
    public double getPerimeter() {
        return this.base + this.sideA + this.sideB;
    }

    @Override
    public int getEdgeCount() {
        return TRIANGLE_EDGES;
    }   
}
