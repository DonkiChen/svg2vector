package com.github.DonkiChen.svg.shape;

import com.github.DonkiChen.svg.bean.Point;
import com.sun.istack.internal.Nullable;

public class PathBuilder {
    private StringBuilder mPath = new StringBuilder();
    //仅做了移动操作的, 到时候不予输出
    private boolean mJustMove = true;

    private PathBuilder() {
    }

    public static PathBuilder newBuilder() {
        return new PathBuilder();
    }

    public PathBuilder arcTo(double rx, double ry, double xRotation, boolean largeArc, boolean clockwise,
                             double endX, double endY) {
        mPath.append(PathHelper.arcTo(rx, ry, xRotation, largeArc, clockwise, endX, endY));
        mJustMove = false;
        return this;
    }

    public PathBuilder arcTo(double rx, double ry, double endX, double endY) {
        mPath.append(PathHelper.arcTo(rx, ry, endX, endY));
        mJustMove = false;
        return this;
    }

    public PathBuilder rArcTo(double rx, double ry, double xRotation, boolean largeArc, boolean clockwise,
                              double dx, double dy) {
        if (dx == 0 && dy == 0) {
            return this;
        }
        mPath.append(PathHelper.rArcTo(rx, ry, xRotation, largeArc, clockwise, dx, dy));
        mJustMove = false;
        return this;
    }

    public PathBuilder rArcTo(double rx, double ry, double dx, double dy) {
        if (dx == 0 && dy == 0) {
            return this;
        }
        mPath.append(PathHelper.rArcTo(rx, ry, dx, dy));
        mJustMove = false;
        return this;
    }

    public PathBuilder moveTo(double x, double y) {
        mPath.append(PathHelper.moveTo(x, y));
        return this;
    }

    public PathBuilder rMoveTo(double x, double y) {
        if (x == 0 && y == 0) {
            return this;
        }
        mPath.append(PathHelper.rMoveTo(x, y));
        return this;
    }

    public PathBuilder moveTo(Point point) {
        mPath.append(PathHelper.moveTo(point));
        return this;
    }

    public PathBuilder rMoveTo(Point point) {
        if (point.x == 0 && point.y == 0) {
            return this;
        }
        mPath.append(PathHelper.rMoveTo(point));
        return this;
    }

    public PathBuilder horizontalTo(double x) {
        mPath.append(PathHelper.horizontalTo(x));
        mJustMove = false;
        return this;
    }

    public PathBuilder rHorizontalTo(double x) {
        if (x == 0) {
            return this;
        }
        mPath.append(PathHelper.rHorizontalTo(x));
        mJustMove = false;
        return this;
    }

    public PathBuilder verticalTo(double y) {
        mPath.append(PathHelper.verticalTo(y));
        mJustMove = false;
        return this;
    }

    public PathBuilder rVerticalTo(double y) {
        if (y == 0) {
            return this;
        }
        mPath.append(PathHelper.rVerticalTo(y));
        mJustMove = false;
        return this;
    }

    public PathBuilder lineTo(double x, double y) {
        mPath.append(PathHelper.lineTo(x, y));
        mJustMove = false;
        return this;
    }

    public PathBuilder rLineTo(double x, double y) {
        if (x == 0 && y == 0) {
            return this;
        }
        mPath.append(PathHelper.rLineTo(x, y));
        mJustMove = false;
        return this;
    }

    public PathBuilder lineTo(Point point) {
        mPath.append(PathHelper.lineTo(point));
        mJustMove = false;
        return this;
    }

    public PathBuilder rLineTo(Point point) {
        if (point.x == 0 && point.y == 0) {
            return this;
        }
        mPath.append(PathHelper.rLineTo(point));
        mJustMove = false;
        return this;
    }

    public PathBuilder close() {
        mPath.append(PathHelper.close());
        return this;
    }

    public int length() {
        return mPath.length();
    }

    @Nullable
    public String build() {
        if (mJustMove) {
            return null;
        }
        if (mPath.indexOf("z") == -1 && mPath.indexOf("Z") == -1) {
            close();
        }
        return toString();
    }

    @Override
    public String toString() {
        return mPath.toString();
    }
}
