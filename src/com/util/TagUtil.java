package com.util;

/**
 * @author Alexandr Jelimalai
 */
public class TagUtil {

    public static final String CODE = "code";
    private static final String END = "end";
    private static final String NEW_LINE = "nl";


    public static String escapeXML(String str) {
        return str.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\"", "&quot;").replaceAll("'", "&apos;");
    }


    public static String toXML(String str) {
        return str.replaceAll("\\[" + NEW_LINE + "\\]", "<br/>").replaceAll("\\[" + CODE + "\\]", "<" + CODE + ">").replaceAll("\\[" + END + "\\]", "</" + CODE + ">");
    }

    public static String escapeCodeXml(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean escape = false;
        for (String text : toXML(str).split("</{0,1}code>")) {
            if (escape) {
                stringBuilder.append("<code>").append(escapeXML(text));
            } else {
                stringBuilder.append(text).append("</code>");
            }
            escape = !escape;
        }
        return stringBuilder.toString();
    }
}
