package com.github.DonkiChen.svg.bean;

import com.github.DonkiChen.tool.MathHelper;

import java.util.Locale;

public class Point {

    public double x;
    public double y;

    public Point() {
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(String x, String y) {
        this.x = MathHelper.parseDouble(x);
        this.y = MathHelper.parseDouble(y);
    }

    @Override
    public String toString() {
        return String.format(Locale.CHINA, "%s,%s", MathHelper.prettyDouble(x),
                MathHelper.prettyDouble(y));
    }

    public Point center(Point endPoint) {
        return new Point((x + endPoint.x) / 2, (y + endPoint.y) / 2);
    }
}
