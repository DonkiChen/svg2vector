package com.github.DonkiChen.svg.attribute.shape;

import com.github.DonkiChen.svg.attribute.AttributeDispatcher;
import com.github.DonkiChen.svg.attribute.IAttribute;
import com.github.DonkiChen.svg.attribute.style.Attributes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Style implements IAttribute {
    private static final Pattern PATTERN = Pattern.compile("([-\\w]+):\\s*(\\S+)");

    @Override
    public void resolve(String data, Attributes attributes) {
        String[] styles = data.split(";");
        for (String style : styles) {
            Matcher matcher = PATTERN.matcher(style.trim());
            if (matcher.find()) {
                String styleName = matcher.group(1);
                String value = matcher.group(2);
                AttributeDispatcher.dispatch(styleName, value, attributes);
            }
        }
    }
}
