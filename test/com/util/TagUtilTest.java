package com.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: Alexandr
 * Date: 21.05.14
 * Time: 21:38
 */
public class TagUtilTest {

    @Test
    public void testSimpleHtml() {
        String xml = "<b>text</b>";
        Assert.assertEquals("Incorrect escape", xml, TagUtil.escapeCodeXml(xml));
    }

    @Test
    public void testCode() {
        String xml = "<code>text</code>";
        Assert.assertEquals("Incorrect escape", xml, TagUtil.escapeCodeXml(xml));
    }

    @Test
    public void htmlInCode() {
        String xml = "<code><b>text</b></code>";
        String expectedText = "<code>&lt;b&gt;text&lt;/b&gt;</code>";
        Assert.assertEquals("Incorrect escape", expectedText, TagUtil.escapeCodeXml(xml));
    }

    @Test
    public void htmlInCodeWithEnd() {
        String xml = "[code]<b>text</b>[end]";
        String expectedText = "<code>&lt;b&gt;text&lt;/b&gt;</code>";
        Assert.assertEquals("Incorrect escape", expectedText, TagUtil.escapeCodeXml(xml));
    }

    @Test
    public void newLine() {
        String xml = "[nl]";
        String expectedText = "<br/>";
        Assert.assertEquals("Incorrect escape", expectedText, TagUtil.escapeCodeXml(xml));
    }

}
