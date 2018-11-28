package com.github.DonkiChen.tool;

public class TextUtils {
    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static CharSequence concat(CharSequence... charSequences) {
        if (charSequences == null || charSequences.length == 0) {
            return "";
        }
        if (charSequences.length == 1) {
            return charSequences[0];
        }
        final StringBuilder sb = new StringBuilder();
        for (CharSequence piece : charSequences) {
            sb.append(piece);
        }
        return sb.toString();
    }
}
