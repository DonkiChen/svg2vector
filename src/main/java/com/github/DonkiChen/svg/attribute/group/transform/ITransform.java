package com.github.DonkiChen.svg.attribute.group.transform;


import com.github.DonkiChen.tool.TransformMatrix;

interface ITransform {
    void transformMatrix(TransformMatrix transformMatrix, double[] params);
}
