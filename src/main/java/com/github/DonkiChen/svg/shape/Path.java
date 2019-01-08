package com.github.DonkiChen.svg.shape;

import com.github.DonkiChen.svg.SvgHelper;
import com.github.DonkiChen.svg.attribute.style.Attributes;
import com.github.DonkiChen.svg.constant.ShapeAttribute;
import com.github.DonkiChen.svg.shape.path.BasePath;
import com.github.DonkiChen.svg.shape.path.PathDispatcher;
import com.github.DonkiChen.tool.TextUtils;

import org.dom4j.Element;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Path extends BaseShape {
    private static final Pattern PATTERN = Pattern.compile("(([a-zA-Z])([-0-9.,\\s]+)|Z)");

    @Override
    public String resolvePath(Element shape, Attributes attributes) {
        Matcher matcher = PATTERN.matcher(SvgHelper.getAttributeText(shape, ShapeAttribute.D));
        StringBuilder path = new StringBuilder();
        BasePath.PathState pathState = new BasePath.PathState();
        while (matcher.find()) {
            String fullCommand = matcher.group(1);
            String command = matcher.group(2);
            String value = matcher.group(3);
            if (TextUtils.isEmpty(command) || TextUtils.isEmpty(value)) {
                //Z
                if ("z".equalsIgnoreCase(fullCommand.trim())) {
                    path.append("Z");
                }
            } else {
                //非Z
                pathState = PathDispatcher.dispatch(pathState, command, value.trim(), attributes.mTransformMatrix);
                path.append(pathState.transformedPath);
            }
        }
        return path.toString();
    }
}
