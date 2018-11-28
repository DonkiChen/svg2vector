package com.github.DonkiChen.svg.attribute.style;

import java.util.HashMap;
import java.util.Locale;

public class ColorParser {
    private static final HashMap<String, Integer> COLOR_MAP = new HashMap<>();

    static {
        COLOR_MAP.put("transparent", 0x0);
        COLOR_MAP.put("none", 0x0);
        COLOR_MAP.put("black", 0xFF000000);
        COLOR_MAP.put("darkgray", 0xFF444444);
        COLOR_MAP.put("gray", 0xFF888888);
        COLOR_MAP.put("lightgray", 0xFFCCCCCC);
        COLOR_MAP.put("white", 0xFFFFFFFF);
        COLOR_MAP.put("red", 0xFFFF0000);
        COLOR_MAP.put("green", 0xFF00FF00);
        COLOR_MAP.put("blue", 0xFF0000FF);
        COLOR_MAP.put("yellow", 0xFFFFFF00);
        COLOR_MAP.put("cyan", 0xFF00FFFF);
        COLOR_MAP.put("magenta", 0xFFFF00FF);
        COLOR_MAP.put("aqua", 0xFF00FFFF);
        COLOR_MAP.put("fuchsia", 0xFFFF00FF);
        COLOR_MAP.put("darkgrey", 0xFF444444);
        COLOR_MAP.put("grey", 0xFF888888);
        COLOR_MAP.put("lightgrey", 0xFFCCCCCC);
        COLOR_MAP.put("lime", 0xFF00FF00);
        COLOR_MAP.put("maroon", 0xFF800000);
        COLOR_MAP.put("navy", 0xFF000080);
        COLOR_MAP.put("olive", 0xFF808000);
        COLOR_MAP.put("purple", 0xFF800080);
        COLOR_MAP.put("silver", 0xFFC0C0C0);
        COLOR_MAP.put("teal", 0xFF008080);
    }

    public static String parseColor(String color) {
        if (color.startsWith("#")) {
            return color.toUpperCase(Locale.CHINA);
        }
        return toHex(COLOR_MAP.getOrDefault(color, 0));
    }

    private static String toHex(int color) {
        return String.format("#%08x", color);
    }
}
