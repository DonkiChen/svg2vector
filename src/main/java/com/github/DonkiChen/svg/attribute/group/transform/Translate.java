package com.github.DonkiChen.svg.attribute.group.transform;

import com.github.DonkiChen.tool.MatrixHelper;

public class Translate implements ITransform {
    @Override
    public void transformMatrix(MatrixHelper matrixHelper, double[] params) {
        if (params.length == 1) {
            matrixHelper.preTranslate(params[0], 0);
        } else if (params.length == 2) {
            matrixHelper.preTranslate(params[0], params[1]);
        }
    }
}
