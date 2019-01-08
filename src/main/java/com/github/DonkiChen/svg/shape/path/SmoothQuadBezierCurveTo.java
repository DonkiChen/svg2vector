package com.github.DonkiChen.svg.shape.path;

import com.github.DonkiChen.svg.bean.Point;
import com.github.DonkiChen.tool.TransformMatrix;

/**
 * T/t
 * x,y
 */
class SmoothQuadBezierCurveTo extends BasePath {
    @Override
    public PathState performTransform(PathState pathState, String command, String[] values, TransformMatrix transformMatrix) {
        Point point = pathState.lastPoint;
        if (values.length == 2) {
            StringBuilder path = new StringBuilder();
            path.append("T");
            calLastPoint(point, command, values[0], values[1], transformMatrix);
            path.append(point.toString());
            pathState.transformedPath = path.toString();
        }
        return pathState;
    }
}
