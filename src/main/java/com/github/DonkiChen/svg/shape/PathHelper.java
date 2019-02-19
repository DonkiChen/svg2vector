package com.github.DonkiChen.svg.shape;

import com.github.DonkiChen.svg.bean.Point;
import com.github.DonkiChen.tool.MathHelper;

import java.util.Locale;

public class PathHelper {
    /**
     * A rx,ry x-axis-rotation large-arc-flag sweep-flag x,y
     * 含义
     * A x半径,y半径 x轴的旋转角度 是否是大弧(0:小弧,1:大弧) 绘制方向(0:逆时针,1:顺时针) 终点x,终点y
     * 解释:确定起点终点可以画4个弧形(起点,终点,椭圆圆心在同一直线时为2个),靠large-arc-flag sweep-flag 搭配
     */
    public static String arcTo(double rx, double ry, double xRotation, boolean largeArc, boolean clockwise,
                               double endX, double endY) {
        return String.format(Locale.CHINA, "A%s,%s %s %d %d %s,%s",
                MathHelper.prettyDouble(rx), MathHelper.prettyDouble(ry),
                MathHelper.prettyDouble(xRotation), largeArc ? 1 : 0, clockwise ? 1 : 0,
                MathHelper.prettyDouble(endX), MathHelper.prettyDouble(endY));
    }

    public static String arcTo(double rx, double ry, double endX, double endY) {
        return arcTo(rx, ry, 0, false, true, endX, endY);
    }

    public static String rArcTo(double rx, double ry, double xRotation, boolean largeArc, boolean clockwise,
                                double dx, double dy) {
        return String.format(Locale.CHINA, "A%s,%s %s %d %d %s,%s",
                MathHelper.prettyDouble(rx), MathHelper.prettyDouble(ry),
                MathHelper.prettyDouble(xRotation), largeArc ? 1 : 0, clockwise ? 1 : 0,
                MathHelper.prettyDouble(dx), MathHelper.prettyDouble(dy));
    }

    public static String rArcTo(double rx, double ry, double dx, double dy) {
        return rArcTo(rx, ry, 0, false, true, dx, dy);
    }

    public static String moveTo(double x, double y) {
        return String.format(Locale.CHINA, "M%s,%s ",
                MathHelper.prettyDouble(x), MathHelper.prettyDouble(y));
    }

    public static String rMoveTo(double x, double y) {
        return String.format(Locale.CHINA, "m%s,%s ",
                MathHelper.prettyDouble(x), MathHelper.prettyDouble(y));
    }

    public static String moveTo(Point point) {
        return moveTo(point.x, point.y);
    }

    public static String rMoveTo(Point point) {
        return rMoveTo(point.x, point.y);
    }

    public static String horizontalTo(double x) {
        return String.format(Locale.CHINA, "H%s ", MathHelper.prettyDouble(x));
    }

    public static String rHorizontalTo(double x) {
        return String.format(Locale.CHINA, "h%s ", MathHelper.prettyDouble(x));
    }

    public static String verticalTo(double y) {
        return String.format(Locale.CHINA, "V%s ", MathHelper.prettyDouble(y));
    }

    public static String rVerticalTo(double y) {
        return String.format(Locale.CHINA, "v%s ", MathHelper.prettyDouble(y));
    }

    public static String lineTo(double x, double y) {
        return String.format(Locale.CHINA, "L%s,%s ",
                MathHelper.prettyDouble(x), MathHelper.prettyDouble(y));
    }

    public static String rLineTo(double x, double y) {
        return String.format(Locale.CHINA, "l%s,%s ",
                MathHelper.prettyDouble(x), MathHelper.prettyDouble(y));
    }

    public static String lineTo(Point point) {
        return lineTo(point.x, point.y);
    }

    public static String rLineTo(Point point) {
        return rLineTo(point.x, point.y);
    }

    public static String close() {
        return "Z ";
    }
}
