package com.github.DonkiChen.svg.attribute.group.transform;

import com.github.DonkiChen.tool.TransformMatrix;

class Scale implements ITransform {
    @Override
    public void transformMatrix(TransformMatrix transformMatrix, double[] params) {
        if (params.length == 1) {
            //x轴缩放
            transformMatrix.preScale(params[0], params[0]);
        } else {
            //x,y轴缩放
            transformMatrix.preScale(params[0], params[1]);
        }
    }
}
