package org.json.junit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Scanner;
import java.util.function.Function;

import org.json.JSONException;
import org.json.JSONPointer;
import org.json.JSONObject;
import org.json.XML;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class M2Test {
    @Test
    public void testSimpleUniquePath() {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<contact>\n" +
                "  <nick>Crista </nick>\n" +
                "  <name>Crista Lopes</name>\n" +
                "  <address>\n" +
                "    <street>Ave of Nowhere</street>\n" +
                "    <zipcode>92614</zipcode>\n" +
                "  </address>\n" +
                "</contact>";
        try {
            JSONObject jObj = XML.toJSONObject(new StringReader(xml.toString()), new JSONPointer("/contact/address/street/"));
            assertEquals("{\"contact\":{\"address\":{\"street\":\"Ave of Nowhere\"}}}", jObj.toString());
        } catch (JSONException e) {
            System.out.println(e);
        }
    }

    @Test
    public void testSimpleNonUniquePath() {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<contact>\n" +
                "  <nick>Crista </nick>\n" +
                "  <name>Crista Lopes</name>\n" +
                "  <address>\n" +
                "    <street>Ave of Nowhere</street>\n" +
                "    <zipcode>92614</zipcode>\n" +
                "  </address>\n" +
                "  <address>\n" +
                "    <street>Ave of Somewhere</street>\n" +
                "    <zipcode>92620</zipcode>\n" +
                "  </address>\n" +
                "</contact>";
        try {
            JSONObject jObj = XML.toJSONObject(new StringReader(xml.toString()), new JSONPointer("/contact/address/street/"));
            assertEquals("{\"contact\":{\"address\":[{\"street\":\"Ave of Nowhere\"},{\"street\":\"Ave of Somewhere\"}]}}", jObj.toString());
        } catch (JSONException e) {
            System.out.println(e);
        }
    }

    @Test
    public void testSimpleNonUniquePathFileImport() throws FileNotFoundException {
        //test 2
        File fileObject = new File("src/test/resources/XML/Sample-XML-With-Multiple-Records.xml");
        Scanner myReader = new Scanner(fileObject);
        StringBuilder xmlString2 = new StringBuilder();
        while (myReader.hasNextLine()) {
            xmlString2.append(myReader.nextLine());
        }
        myReader.close();
        try {
            JSONObject jObj = XML.toJSONObject(new StringReader(xmlString2.toString()), new JSONPointer("/CATALOG/PLANT/PRICE/"));
            assertEquals("{\"CATALOG\":{\"PLANT\":[{\"PRICE\":202},{\"PRICE\":301},{\"PRICE\":500},{\"PRICE\":205}]}}", jObj.toString());
        } catch (JSONException e) {
            System.out.println(e);
        }
    }

    @Test
    public void testSimpleReplacement() throws FileNotFoundException {

        String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<contact>\n" +
                "  <nick>Crista </nick>\n" +
                "  <name>Crista Lopes</name>\n" +
                "  <address>\n" +
                "    <street>Ave of Nowhere</street>\n" +
                "    <zipcode>92614</zipcode>\n" +
                "  </address>\n" +
                "</contact>";
        try {
            JSONObject replacement = XML.toJSONObject("<street>Ave of the Arts</street>\n");
            JSONObject jObj = XML.toJSONObject(new StringReader(xmlString), new JSONPointer("/contact/address/zipcode/"), replacement);
            assertEquals("{\"contact\":{\"nick\":\"Crista\",\"address\":{\"zipcode\":{\"street\":\"Ave of the Arts\"},\"street\":\"Ave of Nowhere\"},\"name\":\"Crista Lopes\"}}", jObj.toString());
        } catch (JSONException e) {
            System.out.println(e);
        }
    }

    @Test
    public void testReplacementWithChildren() throws FileNotFoundException {
        String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<contact>\n" +
                "  <nick>Crista </nick>\n" +
                "  <name>Crista Lopes</name>\n" +
                "  <address>\n" +
                "    <street>Ave of Nowhere</street>\n" +
                "    <zipcode>92614</zipcode>\n" +
                "  </address>\n" +
                "</contact>";
    // t2 test2
        try{
        JSONObject replacement = XML.toJSONObject("<street>Ave of the Arts</street>\n");
        JSONObject jObj = XML.toJSONObject(new StringReader(xmlString), new JSONPointer("/contact/address/"), replacement);
            assertEquals("{\"contact\":{\"nick\":\"Crista\",\"address\":{\"street\":\"Ave of the Arts\"},\"name\":\"Crista Lopes\"}}", jObj.toString());
        }
        catch(JSONException e){
            System.out.println(e);
        }
    }
    @Test
    public void testMultipleReplacementWithImport() throws FileNotFoundException {
         //test 3
         File fileObject = new File("src/test/resources/XML/small.xml");
                Scanner myReader = new Scanner(fileObject);
                StringBuilder xmlString3 = new StringBuilder();
                while (myReader.hasNextLine()) {
                    xmlString3.append(myReader.nextLine());
                }
                myReader.close();
        try {
            JSONObject replacement = XML.toJSONObject("<street>Ave of the Arts</street>\n");
            JSONObject jObj = XML.toJSONObject(new StringReader(xmlString3.toString()), new JSONPointer("/catalog/book/"), replacement);
            assertEquals("{\"catalog\":{\"book\":[{\"street\":\"Ave of the Arts\"},{\"street\":\"Ave of the Arts\"},{\"street\":\"Ave of the Arts\"},{\"street\":\"Ave of the Arts\"},{\"street\":\"Ave of the Arts\"},{\"street\":\"Ave of the Arts\"},{\"street\":\"Ave of the Arts\"},{\"street\":\"Ave of the Arts\"},{\"street\":\"Ave of the Arts\"},{\"street\":\"Ave of the Arts\"},{\"street\":\"Ave of the Arts\"},{\"street\":\"Ave of the Arts\"}]}}", jObj.toString());
        } catch (JSONException e) {
            System.out.println(e);
        }
    }
}
