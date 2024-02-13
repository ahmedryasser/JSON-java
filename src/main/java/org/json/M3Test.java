package org.json;

import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.StringReader;
import java.util.function.Function;

public class M3Test {
    public static void main(String[] args) throws FileNotFoundException {

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
        System.out.println(result);


        String xml2 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
                "<contact>\n"+
                "  <nick>Crista </nick>\n"+
                "  <name>Crista Lopes</name>\n" +
                "  <address>\n" +
                "    <street>Ave of Nowhere</street>\n" +
                "    <zipcode>92614</zipcode>\n" +
                "  </address>\n" +
                "</contact>";
        Reader reader2 = new StringReader(xml2);
        JSONObject result2 = XML.toJSONObject(reader2, key -> "prefix_" + key);
        System.out.println(result2);

    }
}
