package com.github.DonkiChen.svg.shape.path;

import com.github.DonkiChen.svg.bean.Point;
import com.github.DonkiChen.tool.MatrixHelper;

/**
 * Q/q
 * x1,y1 x,y
 */
class QuadBezierCurveTo extends BasePath {
    @Override
    public PathState performTransform(PathState pathState, String command, String[] values, MatrixHelper matrixHelper) {
        Point point = pathState.lastPoint;
        if (values.length == 6) {
            StringBuilder path = new StringBuilder();
            path.append("Q");
            calLastPoint(point, command, values[2], values[3], matrixHelper);
            Point controlPoint = new Point(values[0], values[1]);
            matrixHelper.applyTransformToPoint(controlPoint);
            //x1,y1
            path.append(controlPoint.toString()).append(" ")
                    //x,y
                    .append(point.toString());
            pathState.transformedPath = path.toString();
        }
        return pathState;
    }
}
