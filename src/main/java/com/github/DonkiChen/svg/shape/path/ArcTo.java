package com.github.DonkiChen.svg.shape.path;

import com.github.DonkiChen.svg.bean.Point;
import com.github.DonkiChen.tool.MatrixHelper;

/**
 * A/a
 * rx,ry x-axis-rotation large-arc-flag,sweepflag x,y
 */
class ArcTo extends BasePath {
    @Override
    public PathState performTransform(PathState pathState, String command, String[] values, MatrixHelper matrixHelper) {
        Point point = pathState.lastPoint;
        if (values.length == 7) {
            StringBuilder path = new StringBuilder();
            path.append("A");
            calLastPoint(point, command, values[5], values[6], matrixHelper);
            //rx,ry
            path.append(values[0]).append(",").append(values[1]).append(" ")
                    //x-axis-rotation large-arc-flag
                    .append(values[2]).append(" ").append(values[3]).append(" ")
                    //sweepflag
                    .append(values[4]).append(" ")
                    //x,y
                    .append(point.toString());
            pathState.transformedPath = path.toString();
        }
        return pathState;
    }
}
