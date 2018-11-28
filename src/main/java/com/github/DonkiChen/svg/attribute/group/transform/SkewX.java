package com.github.DonkiChen.svg.attribute.group.transform;

import com.github.DonkiChen.tool.MatrixHelper;

class SkewX implements ITransform {
    @Override
    public void transformMatrix(MatrixHelper matrixHelper, double[] params) {
        if (params.length == 1) {
            matrixHelper.preSkew(params[0], 0);
        }
    }
}
