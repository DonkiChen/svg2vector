package com.github.DonkiChen.svg.shape;

import com.github.DonkiChen.svg.bean.Point;
import com.github.DonkiChen.tool.MathHelper;

import java.util.Locale;

public class PathHelper {
    public static String arcTo(double rx, double ry, double endX, double endY) {
        return String.format(Locale.CHINA, "A%s,%s 0 1 1 %s,%s ",
                MathHelper.prettyDouble(rx), MathHelper.prettyDouble(ry),
                MathHelper.prettyDouble(endX), MathHelper.prettyDouble(endY));
    }

    public static String rArcTo(double rx, double ry, double endX, double endY) {
        return String.format(Locale.CHINA, "a%s,%s 0 1 1 %s,%s ",
                MathHelper.prettyDouble(rx), MathHelper.prettyDouble(ry),
                MathHelper.prettyDouble(endX), MathHelper.prettyDouble(endY));
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
