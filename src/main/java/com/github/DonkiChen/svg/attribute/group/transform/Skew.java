package com.github.DonkiChen.svg.attribute.group.transform;

import com.github.DonkiChen.tool.MatrixHelper;

class Skew implements ITransform {
    @Override
    public void transformMatrix(MatrixHelper matrixHelper, double[] params) {
        if (params.length == 2) {
            matrixHelper.preSkew(params[0], params[1]);
        }
    }
}
