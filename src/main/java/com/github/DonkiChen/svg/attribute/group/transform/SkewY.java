package com.github.DonkiChen.svg.attribute.group.transform;

import com.github.DonkiChen.tool.TransformMatrix;

class SkewY implements ITransform{
    @Override
    public void transformMatrix(TransformMatrix transformMatrix, double[] params) {
        if (params.length == 1) {
            transformMatrix.preSkew(0, params[0]);
        }
    }
}
