package org.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Scanner;
import java.util.function.Function;

public class M3Test {
    public static void main(String[] args) throws FileNotFoundException {

//        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
//                "<contact>\n"+
//                "  <nick>Crista </nick>\n"+
//                "  <name>Crista Lopes</name>\n" +
//                "  <address>\n" +
//                "    <street>Ave of Nowhere</street>\n" +
//                "    <zipcode>92614</zipcode>\n" +
//                "  </address>\n" +
//                "</contact>";
//        Reader reader = new StringReader(xml);
//        JSONObject result = XML.toJSONObject(reader, Function.identity());
//        System.out.println(result);


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

                 //test 3
         File fileObject = new File("src/test/resources/XML/small.xml");
                Scanner myReader = new Scanner(fileObject);
                StringBuilder xml3 = new StringBuilder();
                while (myReader.hasNextLine()) {
                    xml3.append(myReader.nextLine());
                }
                myReader.close();
        try {
            JSONObject jobj =  XML.toJSONObject(new StringReader(xml3.toString()), key -> "SWE_" + key);
            System.out.println(jobj);
        } catch (JSONException e) {
            System.out.println(e);
        }
    }
}
