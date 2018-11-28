package com.github.DonkiChen.svg.attribute.group.transform;

import com.github.DonkiChen.tool.MatrixHelper;

class Scale implements ITransform {
    @Override
    public void transformMatrix(MatrixHelper matrixHelper, double[] params) {
        if (params.length == 1) {
            //x轴缩放
            matrixHelper.preScale(params[0], params[0]);
        } else {
            //x,y轴缩放
            matrixHelper.preScale(params[0], params[1]);
        }
    }
}
