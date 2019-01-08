package com.github.DonkiChen.svg.attribute.style;

import com.github.DonkiChen.tool.TransformMatrix;

public class Attributes {
    public TransformMatrix mTransformMatrix = new TransformMatrix();
    public Style style = new Style();

    /**
     * 复制一个,防止子Path的style影响了父的样式
     */
    public Attributes copy() {
        Attributes attributes = new Attributes();
        attributes.style.fillColor = style.fillColor;
        attributes.style.fillType = style.fillType;
        attributes.style.strokeWidth = style.strokeWidth;
        attributes.style.strokeColor = style.strokeColor;
        attributes.mTransformMatrix = mTransformMatrix;
        return attributes;
    }

    public static class Style {
        public String fillColor = "#FF000000";
        public String fillType = "";
        public String strokeWidth = "0";
        public String strokeColor = "#FF000000";
    }
}
