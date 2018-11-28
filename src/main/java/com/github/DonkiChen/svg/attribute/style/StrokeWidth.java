package com.github.DonkiChen.svg.attribute.style;

import com.github.DonkiChen.svg.attribute.IAttribute;

public class StrokeWidth implements IAttribute {
    @Override
    public void resolve(String data, Attributes attributes) {
        attributes.style.strokeWidth = data;
    }
}
