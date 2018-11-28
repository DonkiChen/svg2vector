package com.github.DonkiChen.svg.attribute;


import com.github.DonkiChen.svg.attribute.style.Attributes;

public interface IAttribute {
    void resolve(String data, Attributes attributes);
}
