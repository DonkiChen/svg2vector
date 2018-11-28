package com.github.DonkiChen.svg.attribute;

import com.github.DonkiChen.svg.attribute.group.Transform;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.github.DonkiChen.svg.attribute.shape.PathData;
import com.github.DonkiChen.svg.attribute.shape.Style;
import com.github.DonkiChen.svg.attribute.style.Attributes;
import com.github.DonkiChen.svg.attribute.style.FillColor;
import com.github.DonkiChen.svg.attribute.style.FillRule;
import com.github.DonkiChen.svg.attribute.style.StrokeColor;
import com.github.DonkiChen.svg.attribute.style.StrokeWidth;
import com.github.DonkiChen.svg.constant.ShapeAttribute;
import com.github.DonkiChen.svg.constant.StyleAttribute;

public class AttributeDispatcher {
    private static final Map<String, IAttribute> ATTRIBUTE_MAP = new HashMap<>();

    static {
        ATTRIBUTE_MAP.put(StyleAttribute.FILL, new FillColor());
        ATTRIBUTE_MAP.put(StyleAttribute.FILL_RULE, new FillRule());
        ATTRIBUTE_MAP.put(StyleAttribute.STROKE, new StrokeColor());
        ATTRIBUTE_MAP.put(StyleAttribute.STROKE_WIDTH, new StrokeWidth());
        ATTRIBUTE_MAP.put(StyleAttribute.TRANSFORM, new Transform());
        ATTRIBUTE_MAP.put(ShapeAttribute.D, new PathData());
        ATTRIBUTE_MAP.put(ShapeAttribute.STYLE, new Style());
    }

    /**
     * attributes属性填充
     */
    public static void dispatch(String name, String value, Attributes attributes) {
        IAttribute iAttribute = ATTRIBUTE_MAP.get(name.toLowerCase(Locale.CHINA));
        if (iAttribute != null) {
            iAttribute.resolve(value.trim(), attributes);
        }
    }
}
