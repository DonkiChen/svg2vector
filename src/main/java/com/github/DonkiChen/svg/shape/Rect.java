package com.github.DonkiChen.svg.shape;

import com.github.DonkiChen.svg.SvgHelper;
import com.github.DonkiChen.svg.attribute.style.Attributes;
import com.github.DonkiChen.svg.bean.Point;
import com.github.DonkiChen.svg.constant.ShapeAttribute;

import org.dom4j.Element;

public class Rect extends BaseShape {

    @Override
    public String resolvePath(Element shape, Attributes attributes) {
        double width = SvgHelper.getAttributeDouble(shape, ShapeAttribute.WIDTH);
        double height = SvgHelper.getAttributeDouble(shape, ShapeAttribute.HEIGHT);
        double maxRadius = Math.max(width, height) / 2;
        Point leftTopPoint = new Point();
        leftTopPoint.x = SvgHelper.getAttributeDouble(shape, ShapeAttribute.X);
        leftTopPoint.y = SvgHelper.getAttributeDouble(shape, ShapeAttribute.Y);
        Point rightTopPoint = new Point(leftTopPoint.x + width, leftTopPoint.y);
        Point leftBottomPoint = new Point(leftTopPoint.x, leftTopPoint.y + height);
        Point rightBottomPoint = new Point(rightTopPoint.x, leftBottomPoint.y);
        attributes.matrixHelper.applyTransformToPoints(leftTopPoint, rightTopPoint, leftBottomPoint, rightBottomPoint);
        double rx = SvgHelper.getAttributeDouble(shape, ShapeAttribute.Rect.RX);
        double ry = SvgHelper.getAttributeDouble(shape, ShapeAttribute.Rect.RY);
        rx = Math.min(attributes.matrixHelper.applyTransformRx(rx), maxRadius);
        ry = Math.min(attributes.matrixHelper.applyTransformRy(ry), maxRadius);
        PathBuilder builder = PathBuilder.newBuilder();
        if (rx != 0 || ry != 0) {
            //有圆角
            builder.moveTo(leftTopPoint.x + rx, leftTopPoint.y)
                    .lineTo(rightTopPoint.x - rx, rightTopPoint.y)
                    .arcTo(rx, ry, rightTopPoint.x, rightTopPoint.y + ry)
                    .lineTo(rightTopPoint.center(rightBottomPoint))
                    .arcTo(rx, ry, rightBottomPoint.x - rx, rightBottomPoint.y)
                    .lineTo(leftBottomPoint.x + rx, leftBottomPoint.y)
                    .arcTo(rx, ry, leftBottomPoint.x, leftBottomPoint.y - ry)
                    .lineTo(leftBottomPoint.center(leftTopPoint))
                    .arcTo(rx, ry, leftTopPoint.x + rx, leftTopPoint.y)
                    .close();
        } else {
            //无圆角
            builder.moveTo(leftTopPoint)
                    .lineTo(rightTopPoint)
                    .lineTo(rightBottomPoint)
                    .lineTo(leftBottomPoint)
                    .close();
        }
        return builder.build();
    }
}
