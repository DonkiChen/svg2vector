package com.github.DonkiChen.tool;

import java.text.DecimalFormat;

public strictfp class MathHelper {
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.####");

    public static double cos(double degrees) {
//        return Math.round(Math.cos(Math.toRadians(degrees)) * 100D) / 100D;
        return Math.round(Math.cos(Math.toRadians(degrees)) * 10000000D) / 10000000D;
    }

    public static double sin(double degrees) {
//        return Math.round(Math.sin(Math.toRadians(degrees)) * 100D) / 100D;
        return Math.round(Math.sin(Math.toRadians(degrees)) * 10000000D) / 10000000D;
    }

    public static double tan(double degrees) {
//        return Math.round(Math.sin(Math.toRadians(degrees)) * 100D) / 100D;
        return Math.round(Math.tan(Math.toRadians(degrees)) * 10000000D) / 10000000D;
    }

    public static double parseDouble(String string) {
        if (string.startsWith(".")) {
            string = "0".concat(string);
        }
        try {
            return Double.parseDouble(string);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static String prettyDouble(double d) {
        return DECIMAL_FORMAT.format(d);
    }
}
