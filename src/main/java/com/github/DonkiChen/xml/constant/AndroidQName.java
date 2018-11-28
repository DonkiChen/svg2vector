package com.github.DonkiChen.xml.constant;

import org.dom4j.Namespace;
import org.dom4j.QName;

public class AndroidQName {
    public static final Namespace ANDROID_NAMESPACE = new Namespace("android", "http://schemas.android.com/apk/res/android");

    public static final QName WIDTH = newAndroidQName("width");
    public static final QName HEIGHT = newAndroidQName("height");
    public static final QName VIEWPORT_WIDTH = newAndroidQName("viewportWidth");
    public static final QName VIEWPORT_HEIGHT = newAndroidQName("viewportHeight");
    public static final QName FILL_ALPHA = newAndroidQName("fillAlpha");
    public static final QName FILL_COLOR = newAndroidQName("fillColor");
    public static final QName FILL_TYPE = newAndroidQName("fillType");
    public static final QName PATH_DATA = newAndroidQName("pathData");
    public static final QName STROKE_WIDTH = newAndroidQName("strokeWidth");
    public static final QName STROKE_COLOR = newAndroidQName("strokeColor");

    private static QName newAndroidQName(String name) {
        return new QName(name, ANDROID_NAMESPACE);
    }
}
