package com.github.DonkiChen.svg.shape.path;

import com.github.DonkiChen.svg.bean.Point;
import com.github.DonkiChen.tool.MathHelper;
import com.github.DonkiChen.tool.TransformMatrix;

import java.util.Locale;

public abstract class BasePath {
    /**
     * 将相对命令转为绝对命令, 处理坐标变换
     *
     * @param pathState    保留上一终点的坐标点
     * @param command      命令
     * @param values       值
     * @param transformMatrix 坐标变换
     * @return 包含当前命令的终点以及坐标转换后的path
     */
    abstract PathState performTransform(PathState pathState, String command, String[] values, TransformMatrix transformMatrix);

    public boolean isRelativeCommand(String command) {
        return command.toLowerCase(Locale.CHINA).equals(command);
    }

    public void calLastPoint(Point point, String command, String x, String y, TransformMatrix transformMatrix) {
        double x1 = MathHelper.parseDouble(x);
        double y1 = MathHelper.parseDouble(y);
        if (isRelativeCommand(command)) {
            point.x += x1;
            point.y += y1;
        } else {
            point.x = x1;
            point.y = y1;
        }
        transformMatrix.applyTransformToPoint(point);
    }

    public static class PathState {
        //用于相对坐标的计算
        public Point lastPoint = new Point(0, 0);
        public String transformedPath = "";

        public void cleanPath() {
            transformedPath = "";
        }
    }
}
