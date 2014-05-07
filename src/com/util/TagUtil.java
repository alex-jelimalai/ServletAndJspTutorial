package com.util;

/**
 * @author Alexandr Jelimalai
 */
public class TagUtil {

    public static final String CODE = "code";
    private static final String END = "end";


    public static String escapeXML(String str) {
        return str.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\"", "&quot;").replaceAll("'", "&apos;");
    }


    public static String toXML(String tag, String str) {
        return str.replaceAll("\\[" + tag + "\\]", "<" + tag + ">").replaceAll("\\[" + END + "\\]", "</" + tag + ">");
    }
}
