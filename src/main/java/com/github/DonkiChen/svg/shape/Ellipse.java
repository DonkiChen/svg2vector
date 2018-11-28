package com.github.DonkiChen.svg.shape;

import com.github.DonkiChen.svg.SvgHelper;
import com.github.DonkiChen.svg.attribute.style.Attributes;
import com.github.DonkiChen.svg.bean.Point;
import com.github.DonkiChen.svg.constant.ShapeAttribute;

import org.dom4j.Element;

class Ellipse extends BaseShape {
    @Override
    String resolvePath(Element shape, Attributes attributes) {
        double cx = SvgHelper.getAttributeDouble(shape, ShapeAttribute.Ellipse.CX);
        double cy = SvgHelper.getAttributeDouble(shape, ShapeAttribute.Ellipse.CY);
        double rx = SvgHelper.getAttributeDouble(shape, ShapeAttribute.Ellipse.RX);
        double ry = SvgHelper.getAttributeDouble(shape, ShapeAttribute.Ellipse.RY);
        Point point = new Point(cx, cy);
        rx = attributes.matrixHelper.applyTransformRx(rx);
        ry = attributes.matrixHelper.applyTransformRy(ry);
        attributes.matrixHelper.applyTransformToPoint(point);
        return PathBuilder.newBuilder()
                .moveTo(point)
                .rMoveTo(-rx, 0)
                .rArcTo(rx, ry, 2 * rx, 0)
                .rArcTo(rx, ry, -2 * rx, 0)
                .build();
    }
}
