package com.github.DonkiChen.svg.attribute.group.transform;


import com.github.DonkiChen.tool.MatrixHelper;

interface ITransform {
    void transformMatrix(MatrixHelper matrixHelper, double[] params);
}
