package com.github.DonkiChen;

import com.github.DonkiChen.svg.SvgParser;

import java.io.File;

public class App {
    public static void main(String[] args) {
        for (String path : args) {
            SvgParser.searchAllFiles(new File(path));
        }
    }
}
