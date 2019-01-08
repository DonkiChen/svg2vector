package com.github.DonkiChen.svg.attribute.group;

import com.github.DonkiChen.svg.attribute.IAttribute;
import com.github.DonkiChen.svg.attribute.group.transform.TransformDispatcher;
import com.github.DonkiChen.svg.attribute.style.Attributes;

public class Transform implements IAttribute {
    @Override
    public void resolve(String data, Attributes attributes) {
        TransformDispatcher.dispatch(data, attributes.mTransformMatrix);
    }
}
