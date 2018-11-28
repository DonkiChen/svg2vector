package com.github.DonkiChen.svg.shape;

import com.github.DonkiChen.svg.attribute.AttributeDispatcher;
import com.github.DonkiChen.svg.attribute.style.Attributes;
import com.github.DonkiChen.svg.constant.SupportShape;
import com.github.DonkiChen.xml.XmlPathNode;

import org.dom4j.Element;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ShapeDispatcher {
    private static final Map<String, BaseShape> SHAPE_MAP = new HashMap<>();

    static {
        SHAPE_MAP.put(SupportShape.RECT, new Rect());
        SHAPE_MAP.put(SupportShape.CIRCLE, new Circle());
        SHAPE_MAP.put(SupportShape.LINE, new Line());
        SHAPE_MAP.put(SupportShape.PATH, new Path());
        SHAPE_MAP.put(SupportShape.ELLIPSE, new Ellipse());
        SHAPE_MAP.put(SupportShape.POLYLINE, new Poly());
        SHAPE_MAP.put(SupportShape.POLYGON, new Poly());
    }


    public static boolean isShapeSupported(String name) {
        return SHAPE_MAP.containsKey(name);
    }

    public static XmlPathNode dispatch(Element shape, Attributes attributes) {
        String lowerCaseName = shape.getName().toLowerCase(Locale.CHINA);
        if (isShapeSupported(lowerCaseName)) {
            BaseShape baseShape = SHAPE_MAP.get(lowerCaseName);
            if (attributes == null) {
                attributes = new Attributes();
            }
            return baseShape.toPathNode(shape, attributes);
        }
        return null;
    }
}
