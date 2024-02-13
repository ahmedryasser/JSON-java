package org.json;
import org.json.JSONObject;
import org.json.XML;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

import java.io.Reader;
import java.io.StringReader;
import java.util.function.Function;

public class M3Test {
    @Test
    public void testNoTransformation() {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
                            "<contact>\n"+
                            "  <nick>Crista </nick>\n"+
                            "  <name>Crista Lopes</name>\n" +
                            "  <address>\n" +
                            "    <street>Ave of Nowhere</street>\n" +
                            "    <zipcode>92614</zipcode>\n" +
                            "  </address>\n" +
                            "</contact>";
        Reader reader = new StringReader(xml);
        JSONObject result = XML.toJSONObject(reader, Function.identity());
        assertEquals("{\"foo\":\"bar\"}", result.toString());
    }

    @Test
    public void testSimplePrefixTransformation() {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
                "<contact>\n"+
                "  <nick>Crista </nick>\n"+
                "  <name>Crista Lopes</name>\n" +
                "  <address>\n" +
                "    <street>Ave of Nowhere</street>\n" +
                "    <zipcode>92614</zipcode>\n" +
                "  </address>\n" +
                "</contact>";
        Reader reader = new StringReader(xml);
        JSONObject result = XML.toJSONObject(reader, key -> "prefix_" + key);
        assertEquals("{\"prefix_foo\":\"bar\"}", result.toString());
    }

    @Test
    public void testComplexTransformation() {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
                "<contact>\n"+
                "  <nick>Crista </nick>\n"+
                "  <name>Crista Lopes</name>\n" +
                "  <address>\n" +
                "    <street>Ave of Nowhere</street>\n" +
                "    <zipcode>92614</zipcode>\n" +
                "  </address>\n" +
                "</contact>";
        Reader reader = new StringReader(xml);
        JSONObject result = XML.toJSONObject(reader, key -> new StringBuilder(key).reverse().toString());
        assertEquals("{\"oof\":\"bar\"}", result.toString());
    }
}

