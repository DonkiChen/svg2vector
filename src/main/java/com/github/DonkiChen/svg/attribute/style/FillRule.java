package com.github.DonkiChen.svg.attribute.style;


import com.github.DonkiChen.svg.attribute.IAttribute;
import com.github.DonkiChen.svg.constant.StyleValue;

public class FillRule implements IAttribute {
    @Override
    public void resolve(String data, Attributes attributes) {
        if (StyleValue.FillRule.EVEN_ODD.equalsIgnoreCase(data)) {
            attributes.style.fillType = StyleValue.FillRule.EVEN_ODD;
        } else if (StyleValue.FillRule.NON_ZERO.equalsIgnoreCase(data)) {
            attributes.style.fillType = StyleValue.FillRule.NON_ZERO;
        }
    }
}
