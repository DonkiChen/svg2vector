package com.github.DonkiChen.svg.shape.path;

import com.github.DonkiChen.svg.bean.Point;
import com.github.DonkiChen.tool.TransformMatrix;

/**
 * C/c
 * x1,y1 x2,y2 x,y
 */
class CubicBezierCurveTo extends BasePath {
    @Override
    public PathState performTransform(PathState pathState, String command, String[] values, TransformMatrix transformMatrix) {
        Point point = pathState.lastPoint;
        if (values.length == 6) {
            StringBuilder path = new StringBuilder();
            path.append("C");
            calLastPoint(point, command, values[4], values[5], transformMatrix);
            Point controlPoint1 = new Point(values[0], values[1]);
            Point controlPoint2 = new Point(values[2], values[3]);
            transformMatrix.applyTransformToPoints(controlPoint1, controlPoint2);
            //x1,y1
            path.append(controlPoint1.toString()).append(" ")
                    //x2,y2
                    .append(controlPoint2.toString()).append(" ")
                    //x,y
                    .append(point.toString());
            pathState.transformedPath = path.toString();
        }
        return pathState;
    }
}
