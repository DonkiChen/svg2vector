package com.github.DonkiChen.svg.attribute.group.transform;

import com.github.DonkiChen.tool.TransformMatrix;

public class Translate implements ITransform {
    @Override
    public void transformMatrix(TransformMatrix transformMatrix, double[] params) {
        if (params.length == 1) {
            transformMatrix.preTranslate(params[0], 0);
        } else if (params.length == 2) {
            transformMatrix.preTranslate(params[0], params[1]);
        }
    }
}
