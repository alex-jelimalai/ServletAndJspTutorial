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

    public static String escapeCodeXml(final String str) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean escape = false;
        String xmlValue = toXML(str);
        String[] split = toXML(xmlValue).split("</{0,1}code>");
        if (split.length < 2) {
            return xmlValue;
        }
        for (String text : split) {
            if (escape) {
                stringBuilder.append("<code>").append(escapeXML(text)).append("</code>");
            } else {
                stringBuilder.append(text);
            }
            escape = !escape;
        }
        return stringBuilder.toString();
    }
}
