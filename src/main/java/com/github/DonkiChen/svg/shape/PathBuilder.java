package com.github.DonkiChen.svg.shape;

import com.github.DonkiChen.svg.bean.Point;

public class PathBuilder {
    private StringBuilder mPath = new StringBuilder();

    private PathBuilder() {
    }

    public static PathBuilder newBuilder() {
        return new PathBuilder();
    }

    public PathBuilder arcTo(double rx, double ry, double endX, double endY) {
        mPath.append(PathHelper.arcTo(rx, ry, endX, endY));
        return this;
    }

    public PathBuilder rArcTo(double rx, double ry, double endX, double endY) {
        mPath.append(PathHelper.rArcTo(rx, ry, endX, endY));
        return this;
    }

    public PathBuilder moveTo(double x, double y) {
        mPath.append(PathHelper.moveTo(x, y));
        return this;
    }

    public PathBuilder rMoveTo(double x, double y) {
        mPath.append(PathHelper.rMoveTo(x, y));
        return this;
    }

    public PathBuilder moveTo(Point point) {
        mPath.append(PathHelper.moveTo(point));
        return this;
    }

    public PathBuilder rMoveTo(Point point) {
        mPath.append(PathHelper.rMoveTo(point));
        return this;
    }

    public PathBuilder horizontalTo(double x) {
        mPath.append(PathHelper.horizontalTo(x));
        return this;
    }

    public PathBuilder rHorizontalTo(double x) {
        mPath.append(PathHelper.rHorizontalTo(x));
        return this;
    }

    public PathBuilder verticalTo(double y) {
        mPath.append(PathHelper.verticalTo(y));
        return this;
    }

    public PathBuilder rVerticalTo(double y) {
        mPath.append(PathHelper.rVerticalTo(y));
        return this;
    }

    public PathBuilder lineTo(double x, double y) {
        mPath.append(PathHelper.lineTo(x, y));
        return this;
    }

    public PathBuilder rLineTo(double x, double y) {
        mPath.append(PathHelper.rLineTo(x, y));
        return this;
    }

    public PathBuilder lineTo(Point point) {
        mPath.append(PathHelper.lineTo(point));
        return this;
    }

    public PathBuilder rLineTo(Point point) {
        mPath.append(PathHelper.rLineTo(point));
        return this;
    }

    public PathBuilder close() {
        mPath.append(PathHelper.close());
        return this;
    }

    public int length() {
        return mPath.length();
    }

    public String build() {
        return mPath.toString();
    }
}
