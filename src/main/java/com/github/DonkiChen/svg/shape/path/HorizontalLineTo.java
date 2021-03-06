package com.github.DonkiChen.svg.shape.path;

import com.github.DonkiChen.svg.bean.Point;
import com.github.DonkiChen.tool.MathHelper;
import com.github.DonkiChen.tool.MatrixHelper;

/**
 * H/h
 * x
 */
class HorizontalLineTo extends BasePath {
    @Override
    public PathState performTransform(PathState pathState, String command, String[] values, MatrixHelper matrixHelper) {
        Point point = pathState.lastPoint;
        if (values.length == 1) {
            StringBuilder path = new StringBuilder();
            path.append("H");
            calLastPoint(point, command, values[0], "0", matrixHelper);
            path.append(MathHelper.prettyDouble(point.x));
            pathState.transformedPath = path.toString();
        }
        return pathState;
    }
}
