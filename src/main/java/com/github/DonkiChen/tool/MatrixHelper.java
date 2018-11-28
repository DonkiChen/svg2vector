package com.github.DonkiChen.tool;

import com.github.DonkiChen.svg.bean.Point;

import Jama.Matrix;

public class MatrixHelper {

    private Matrix mMatrix = WrapperMatrix.newMatrix();
    /**
     * 缩放矩阵 避免位移/旋转带来的影响
     */
    private Matrix mScaleMatrix = WrapperMatrix.newMatrix();
    private WrapperMatrix mMatrix2 = WrapperMatrix.newMatrix();

    public void setTranslate(double translateX, double translateY) {
        WrapperMatrix.reset(mMatrix);
        preTranslate(translateX, translateY);
    }

    public void setRotate(double degree, double px, double py) {
        WrapperMatrix.reset(mMatrix);
        preRotate(degree, px, py);
    }

    public void setScale(double scaleX, double scaleY) {
        WrapperMatrix.reset(mMatrix);
        WrapperMatrix.reset(mScaleMatrix);
        preScale(scaleX, scaleY);
    }

    public void setSkew(double skewX, double skewY) {
        WrapperMatrix.reset(mMatrix);
        preSkew(skewX, skewY);
    }

    public void preTranslate(double translateX, double translateY) {
        mMatrix2.setTranslate(translateX, translateY);
        mMatrix = mMatrix.times(mMatrix2);
    }

    public void preRotate(double degrees, double px, double py) {
        preTranslate(px, py);
        mMatrix2.setRotate(degrees);
        mMatrix = mMatrix.times(mMatrix2);
        preTranslate(-px, py);
    }

    public void preScale(double scaleX, double scaleY) {
        mMatrix2.setScale(scaleX, scaleY);
        mMatrix = mMatrix.times(mMatrix2);
        mScaleMatrix = mScaleMatrix.times(mMatrix2);
    }

    public void preSkew(double degreesX, double degreesY) {
        mMatrix2.setSkew(degreesX, degreesY);
        mMatrix = mMatrix.times(mMatrix2);
    }

    public void transform(double[] row1, double[] row2) {
        if (row1 != null && row1.length != 3) {
            return;
        }
        if (row2 != null && row2.length != 3) {
            return;
        }
        mMatrix2.reset();
        mMatrix2.getArray()[0] = row1;
        mMatrix2.getArray()[1] = row2;
        mMatrix = mMatrix.plus(mMatrix2);
        mMatrix2.reset();
    }

    public void setTransform(double[] row1, double[] row2) {
        WrapperMatrix.reset(mMatrix);
        transform(row1, row2);
    }

    /**
     * 用于rx的缩放
     */
    public double applyTransformRx(double x) {
        Matrix matrix = new Matrix(new double[][]{
                {x},
                {0},
                {1}
        });

        double[][] tempArray = mScaleMatrix.getArray();
        WrapperMatrix temp = WrapperMatrix.newMatrix();
        temp.setScale(tempArray[0][0], tempArray[1][1]);

        Matrix result = temp.times(matrix);
        //结果应该是3行1列
        //x0
        //0
        //1
        double[][] array = result.getArray();
        return array[0][0];
    }

    /**
     * 用于ry的缩放
     */
    public double applyTransformRy(double y) {
        Matrix matrix = new Matrix(new double[][]{
                {0},
                {y},
                {1}
        });

        double[][] tempArray = mScaleMatrix.getArray();
        WrapperMatrix temp = WrapperMatrix.newMatrix();
        temp.setScale(tempArray[0][0], tempArray[1][1]);

        Matrix result = temp.times(matrix);
        //结果应该是3行1列
        //0
        //y0
        //1
        double[][] array = result.getArray();
        return array[1][0];
    }

    public void applyTransformToPoints(Point... points) {
        if (points != null && points.length > 0) {
            for (Point point : points) {
                applyTransformToPoint(point);
            }
        }
    }

    public void applyTransformToPoint(Point point) {
        Matrix matrix = new Matrix(new double[][]{
                {point.x},
                {point.y},
                {1},
        });

        Matrix result = mMatrix.times(matrix);
        //结果应该是3行1列
        //x0
        //y0
        //1
        double[][] array = result.getArray();
        point.x = array[0][0];
        point.y = array[1][0];
    }

    public Matrix getMatrix() {
        return mMatrix;
    }

    static class WrapperMatrix extends Matrix {
        private static final Matrix IDENTITY_MATRIX = new Matrix(new double[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        });

        private WrapperMatrix(int m, int n) {
            super(m, n);
        }

        static WrapperMatrix newMatrix() {
            WrapperMatrix matrix = new WrapperMatrix(3, 3);
            matrix.reset();
            return matrix;
        }

        static void reset(Matrix matrix) {
            matrix.setMatrix(0, 2, 0, 2, IDENTITY_MATRIX);
        }

        void reset() {
            setMatrix(0, 2, 0, 2, IDENTITY_MATRIX);
        }

        /**
         * 1,0,x
         * 0,1,y
         * 0,0,1
         */
        void setTranslate(double translateX, double translateY) {
            reset();
            set(0, 2, translateX);
            set(1, 2, translateY);
        }

        /**
         * cos,-sin,0
         * sin,cos,0
         * 0,0,1
         *
         * @param degrees 角度
         */
        void setRotate(double degrees) {
            reset();
            set(0, 0, MathHelper.cos(degrees));
            set(0, 1, -MathHelper.sin(degrees));
            set(1, 0, MathHelper.sin(degrees));
            set(1, 1, MathHelper.cos(degrees));
        }

        /**
         * x,0,0
         * 0,y,0
         * 0,0,1
         */
        void setScale(double scaleX, double scaleY) {
            reset();
            set(0, 0, scaleX);
            set(1, 1, scaleY);
        }

        /**
         * 1,tan(x),0
         * tan(y),1,0
         * 0,0,1
         */
        void setSkew(double degreesX, double degreesY) {
            reset();
            set(0, 1, MathHelper.tan(degreesX));
            set(1, 0, MathHelper.tan(degreesY));
        }
    }
}
