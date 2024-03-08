package org.json.junit;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Scanner;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

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
            System.out.println(result.toString());
            assertEquals("{\"contact\":{\"nick\":\"Crista\",\"address\":{\"zipcode\":92614,\"street\":\"Ave of Nowhere\"},\"name\":\"Crista Lopes\"}}", result.toString());
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
            assertEquals("{\"prefix_contact\":{\"prefix_name\":\"Crista Lopes\",\"prefix_address\":{\"prefix_zipcode\":92614,\"prefix_street\":\"Ave of Nowhere\"},\"prefix_nick\":\"Crista\"}}", result.toString());
        }

    @Test
    public void testSimplePrefixTransformationFileImport() {
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
                JSONObject jobj =  XML.toJSONObject(new StringReader(xml3.toString()), key -> "SWE_" + key);
                assertEquals("{\"SWE_catalog\":{\"SWE_book\":[{\"SWE_author\":\"Gambardella, Matthew\",\"SWE_publish_date\":\"2000-10-01\",\"id\":\"bk101\",\"SWE_price\":44.95,\"SWE_description\":\"An in-depth look at creating applications            with XML.\",\"SWE_title\":\"XML Developer's Guide\",\"SWE_genre\":\"Computer\"},{\"SWE_author\":\"Ralls, Kim\",\"SWE_publish_date\":\"2000-12-16\",\"id\":\"bk102\",\"SWE_price\":5.95,\"SWE_description\":\"A former architect battles corporate zombies,            an evil sorceress, and her own childhood to become queen            of the world.\",\"SWE_title\":\"Midnight Rain\",\"SWE_genre\":\"Fantasy\"},{\"SWE_author\":\"Corets, Eva\",\"SWE_publish_date\":\"2000-11-17\",\"id\":\"bk103\",\"SWE_price\":5.95,\"SWE_description\":\"After the collapse of a nanotechnology            society in England, the young survivors lay the            foundation for a new society.\",\"SWE_title\":\"Maeve Ascendant\",\"SWE_genre\":\"Fantasy\"},{\"SWE_author\":\"Corets, Eva\",\"SWE_publish_date\":\"2001-03-10\",\"id\":\"bk104\",\"SWE_price\":5.95,\"SWE_description\":\"In post-apocalypse England, the mysterious            agent known only as Oberon helps to create a new life            for the inhabitants of London. Sequel to Maeve            Ascendant.\",\"SWE_title\":\"Oberon's Legacy\",\"SWE_genre\":\"Fantasy\"},{\"SWE_author\":\"Corets, Eva\",\"SWE_publish_date\":\"2001-09-10\",\"id\":\"bk105\",\"SWE_price\":5.95,\"SWE_description\":\"The two daughters of Maeve, half-sisters,            battle one another for control of England. Sequel to            Oberon's Legacy.\",\"SWE_title\":\"The Sundered Grail\",\"SWE_genre\":\"Fantasy\"},{\"SWE_author\":\"Randall, Cynthia\",\"SWE_publish_date\":\"2000-09-02\",\"id\":\"bk106\",\"SWE_price\":4.95,\"SWE_description\":\"When Carla meets Paul at an ornithology            conference, tempers fly as feathers get ruffled.\",\"SWE_title\":\"Lover Birds\",\"SWE_genre\":\"Romance\"},{\"SWE_author\":\"Thurman, Paula\",\"SWE_publish_date\":\"2000-11-02\",\"id\":\"bk107\",\"SWE_price\":4.95,\"SWE_description\":\"A deep sea diver finds true love twenty            thousand leagues beneath the sea.\",\"SWE_title\":\"Splish Splash\",\"SWE_genre\":\"Romance\"},{\"SWE_author\":\"Knorr, Stefan\",\"SWE_publish_date\":\"2000-12-06\",\"id\":\"bk108\",\"SWE_price\":4.95,\"SWE_description\":\"An anthology of horror stories about roaches,            centipedes, scorpions  and other insects.\",\"SWE_title\":\"Creepy Crawlies\",\"SWE_genre\":\"Horror\"},{\"SWE_author\":\"Kress, Peter\",\"SWE_publish_date\":\"2000-11-02\",\"id\":\"bk109\",\"SWE_price\":6.95,\"SWE_description\":\"After an inadvertant trip through a Heisenberg            Uncertainty Device, James Salway discovers the problems            of being quantum.\",\"SWE_title\":\"Paradox Lost\",\"SWE_genre\":\"Science Fiction\"},{\"SWE_author\":\"O'Brien, Tim\",\"SWE_publish_date\":\"2000-12-09\",\"id\":\"bk110\",\"SWE_price\":36.95,\"SWE_description\":\"Microsoft's .NET initiative is explored in            detail in this deep programmer's reference.\",\"SWE_title\":\"Microsoft .NET: The Programming Bible\",\"SWE_genre\":\"Computer\"},{\"SWE_author\":\"O'Brien, Tim\",\"SWE_publish_date\":\"2000-12-01\",\"id\":\"bk111\",\"SWE_price\":36.95,\"SWE_description\":\"The Microsoft MSXML3 parser is covered in            detail, with attention to XML DOM interfaces, XSLT processing,            SAX and more.\",\"SWE_title\":\"MSXML3: A Comprehensive Guide\",\"SWE_genre\":\"Computer\"},{\"SWE_author\":\"Galos, Mike\",\"SWE_publish_date\":\"2001-04-16\",\"id\":\"bk112\",\"SWE_price\":49.95,\"SWE_description\":\"Microsoft Visual Studio 7 is explored in depth,            looking at how Visual Basic, Visual C++, C#, and ASP+ are            integrated into a comprehensive development            environment.\",\"SWE_title\":\"Visual Studio 7: A Comprehensive Guide\",\"SWE_genre\":\"Computer\"}]}}", jobj.toString());

            } catch (JSONException e) {
                System.out.println(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
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
            assertEquals("{\"tcatnoc\":{\"eman\":\"Crista Lopes\",\"sserdda\":{\"edocpiz\":92614,\"teerts\":\"Ave of Nowhere\"},\"kcin\":\"Crista\"}}", result.toString());
        }
    }
//    }
//}
