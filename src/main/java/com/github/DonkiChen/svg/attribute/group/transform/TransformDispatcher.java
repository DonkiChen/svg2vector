package com.github.DonkiChen.svg.attribute.group.transform;

import com.github.DonkiChen.svg.constant.TransformType;
import com.github.DonkiChen.tool.MathHelper;
import com.github.DonkiChen.tool.TransformMatrix;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransformDispatcher {
    private static final Map<String, ITransform> TRANSFORM_MAP = new HashMap<>();
    private static final Pattern PATTERN =
            Pattern.compile("(translate|skewX|skewY|matrix|scale|rotate)\\s*\\(([-0-9.,\\s]+)\\)");

    static {
        TRANSFORM_MAP.put(TransformType.MATRIX, new MatrixTransform());
        TRANSFORM_MAP.put(TransformType.TRANSLATE, new Translate());
        TRANSFORM_MAP.put(TransformType.ROTATE, new Rotate());
        TRANSFORM_MAP.put(TransformType.SCALE, new Scale());
        //x倾斜
        TRANSFORM_MAP.put(TransformType.SKEWX, new SkewX());
        //y倾斜
        TRANSFORM_MAP.put(TransformType.SKEWY, new SkewY());
    }

    public static void dispatch(String data, TransformMatrix transformMatrix) {
        Matcher matcher = PATTERN.matcher(data);
        while (matcher.find()) {
            //转换方法名
            String transformMethod = matcher.group(1);
            ITransform iTransform = TRANSFORM_MAP.get(transformMethod.toLowerCase(Locale.CHINA));
            if (iTransform != null) {
                //转换参数
                String matchedGroup = matcher.group(2).trim();
                //参数
                String[] args = matchedGroup.split("[,\\s]+");
                if (args.length == 0) {
                    continue;
                }
                double[] params = new double[args.length];
                for (int i = 0; i < args.length; i++) {
                    if (args[i].contains("px")) {
                        args[i] = args[i].replace("px", "");
                    }
                    params[i] = MathHelper.parseDouble(args[i]);
                }
                iTransform.transformMatrix(transformMatrix, params);
            }
        }
    }
}
