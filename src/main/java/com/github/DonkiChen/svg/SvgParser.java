package com.github.DonkiChen.svg;

import com.github.DonkiChen.svg.attribute.AttributeDispatcher;
import com.github.DonkiChen.svg.attribute.style.Attributes;
import com.github.DonkiChen.svg.shape.ShapeDispatcher;
import com.github.DonkiChen.xml.XmlHelper;
import com.github.DonkiChen.xml.XmlPathNode;
import com.github.DonkiChen.xml.constant.AndroidQName;
import com.sun.istack.internal.Nullable;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Iterator;

public class SvgParser {

    private static final String SVG_ATTRIBUTE_WIDTH = "width";
    private static final String SVG_ATTRIBUTE_HEIGHT = "height";
    private static final String SVG_ATTRIBUTE_VIEW_BOX = "viewBox";
    private static final String PATH_ATTRIBUTE_D = "d";

    private XmlHelper mXmlHelper = new XmlHelper();
    private Element mRootElement;

    public SvgParser() {

    }

    public void searchAllFiles(File dir) {
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return !file.isHidden() && (file.isDirectory() || file.getName().endsWith(".svg"));
            }
        });
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    searchAllFiles(file);
                } else if (file.getName().endsWith(".svg")) {
                    parseSvg(file);
                }
            }
        }
    }

    private void parseSvg(File file) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(file);
            mRootElement = document.getRootElement();
/*
            String width = SvgHelper.getAttributeText(root, SVG_ATTRIBUTE_WIDTH, "24dp");
            width = width.replace("px", "dp");
            if (!width.endsWith("dp")) {
                width = width.concat("dp");
            }
           */
            mXmlHelper.addRootAttribute(AndroidQName.WIDTH, "24dp");
/*
            String height = SvgHelper.getAttributeText(root, SVG_ATTRIBUTE_HEIGHT, "24dp");
            height = height.replace("px", "dp");
            if (!height.endsWith("dp")) {
                height = height.concat("dp");
            }
            */
            mXmlHelper.addRootAttribute(AndroidQName.HEIGHT, "24dp");
            String viewBox = SvgHelper.getAttributeText(mRootElement, SVG_ATTRIBUTE_VIEW_BOX, "");
            if (!viewBox.isEmpty()) {
                String[] box = viewBox.split("\\s+");
                if (box.length == 4) {
                    mXmlHelper.addRootAttribute(AndroidQName.VIEWPORT_WIDTH, box[2]);
                    mXmlHelper.addRootAttribute(AndroidQName.VIEWPORT_HEIGHT, box[3]);
                }
            }
            searchShapeNode(mRootElement, null);
            System.out.println(mXmlHelper.getDocumentString());
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * 递归搜索支持的图形节点
     */
    private void searchShapeNode(Element parent, @Nullable PathNodeSearchState state) {
        for (Iterator<Element> iterator = parent.elementIterator(); iterator.hasNext(); ) {
            Element element = iterator.next();
            if (parent == mRootElement) {
                //独立节点重置state
                state = null;
            }
            if (element.getName().equalsIgnoreCase("g") && element.hasMixedContent()) {
                //如果g里面有子节点
                state = inheritGroupStyle(element, state);
                searchShapeNode(element, state);
            } else if (ShapeDispatcher.isShapeSupported(element.getName())) {
                //图形节点
                if (state == null) {
                    state = new PathNodeSearchState();
                }
                XmlPathNode node = ShapeDispatcher.dispatch(element, state.attributes);
                if (node != null) {
                    for (double[] doubles : state.attributes.matrixHelper.getMatrix().getArray()) {
                        System.out.println(Arrays.toString(doubles));
                    }
                    System.out.println();
                    mXmlHelper.addPath(node);
                }
            }
        }
    }

    /**
     * 继承group 样式
     */
    private PathNodeSearchState inheritGroupStyle(Element groupElement, PathNodeSearchState state) {
        if (state == null) {
            state = new PathNodeSearchState();
        }
        for (Attribute attribute : groupElement.attributes()) {
            AttributeDispatcher.dispatch(attribute.getName(), attribute.getValue(), state.attributes);
        }
        return state;
    }

    private static class PathNodeSearchState {
        Attributes attributes = new Attributes();
    }

}
