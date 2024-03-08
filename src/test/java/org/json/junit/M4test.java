package org.json.junit;

import org.json.JSONException;
import org.json.JSONNodeConverter;
import org.json.JSONObject;
import org.json.XML;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class M4test{

    @Test
    public void testJSONObjectToStreamFilter() {
        String xml = "<Books><book><title>Harry potter</title><author>Rowling</author></book><book><title>win friends</title><author>dale</author></book></Books>";
        Reader reader = new StringReader(xml);
        JSONObject obj = XML.toJSONObject(reader, Function.identity());

        // Extract titles from JSON nodes
        List<String> titles = obj.toStream()
                .filter(node -> node.getKey().contains("title"))
                .map(JSONObject.JSONNode::getValue)
                .map(String::valueOf)
                .collect(Collectors.toList());
        assertEquals("[Harry potter, win friends]", titles.toString());
    }

    @Test
    public void testJSONObjectToStreamSorting() {
        String xml = "<Books><book><title>Zot</title><author>Carson</author></book><book><title>Styles</title><author>Ahmed</author></book><book><title>Data structures</title><author>Micheal</author></book></Books>";
        Reader reader = new StringReader(xml);
        JSONObject obj = XML.toJSONObject(reader, Function.identity());
//        String xml = "<Books><book><title>AAA</title><author>ASmith</author></book><book><title>BBB</title><author>BSmith</author></book></Books>";
//
        List<String> authors = obj.toStream()
                .filter(node -> node.getKey().contains("author"))
                .map(JSONObject.JSONNode::getValue)
                .map(String::valueOf).sorted()
                .collect(Collectors.toList());
        assertEquals("[Ahmed, Carson, Micheal]", authors.toString());
    }

    @Test
    public void testJSONObjectToStreamSortingFileImport() {
        File fileObject = new File("src/test/resources/XML/small.xml");
        Scanner myReader = null;
        try {
            myReader = new Scanner(fileObject);
            StringBuilder xml3 = new StringBuilder();
            while (myReader.hasNextLine()) {
                xml3.append(myReader.nextLine());
            }
            myReader.close();
            try {
                JSONObject obj = XML.toJSONObject(new StringReader(xml3.toString()), Function.identity());
                List<String> authors = obj.toStream()
                        .filter(node -> node.getKey().contains("author"))
                        .map(JSONObject.JSONNode::getValue)
                        .map(String::valueOf).sorted()
                        .collect(Collectors.toList());
                assertEquals("[Corets, Eva, Corets, Eva, Corets, Eva, Galos, Mike, Gambardella, Matthew, Knorr, Stefan, Kress, Peter, O'Brien, Tim, O'Brien, Tim, Ralls, Kim, Randall, Cynthia, Thurman, Paula]", authors.toString());
            } catch (JSONException e) {
                System.out.println(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}



//    @Test
//    public void testJSONObjectToStreamCount() {
//        String xml = "<Books><book><title>Zot</title><author>Carson</author></book><book><title>Styles</title><author>Ahmed</author></book><book><title>Data structures</title><author>Micheal</author></book></Books>";
//        Reader reader = new StringReader(xml);
//        JSONObject obj = XML.toJSONObject(reader, Function.identity());
////        String xml = "<Books><book><title>AAA</title><author>ASmith</author></book><book><title>BBB</title><author>BSmith</author></book></Books>";
////
//        Stream<JSONObject.JSONNode> stream = new JSONNodeConverter().toStream(obj);
//        long number = stream
//                .filter(node -> "book".equals(node.getKey()))
//                .count();
//        assertEquals(3L, number);
//    }
// Perform transformation based on the path of the node
//        obj.toStream().forEach(node -> {
//            String key = node.getKey();
//            if (key.contains("title")) {
//                // Transformation based on title
//                // doSomething(node.getValue());
//            } else if (key.contains("author")) {
//                // Transformation based on author
//                // doSomethingElse(node.getValue());
//            }
//        });

// Perform transformation on nodes with certain properties
//        obj.toStream().filter(node -> node.getKey().contains("author"))
//                .forEach(node -> {
//                    String author = (String) node.getValue();
//                    if (author.equals("ASmith")) {
//                        // Transformation for ASmith
//                        // doSomethingSpecial(node.getValue());
//                    } else if (author.equals("BSmith")) {
//                        // Transformation for BSmith
//                        // doSomethingDifferent(node.getValue());
//                    }});