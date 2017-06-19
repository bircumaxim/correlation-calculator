package com.correlation.maxim.domain.model;

/**
 * Created by Maxim Bircu on 6/19/17.
 */

public class DomainEntry {
    private double x;
    private double y;

    public DomainEntry(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
