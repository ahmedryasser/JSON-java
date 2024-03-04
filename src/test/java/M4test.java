import org.json.JSONNodeConverter;
import org.json.JSONObject;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class M4test {

    @Test
    public void testJSONObjectToStream() {
        String xml = "<Books><book><title>AAA</title><author>ASmith</author></book><book><title>BBB</title><author>BSmith</author></book></Books>";

        JSONObject obj = new JSONNodeConverter().toJSONObject(xml);

        // Perform transformation based on the path of the node
        obj.toStream().forEach(node -> {
            String key = node.getKey();
            if (key.contains("title")) {
                // Transformation based on title
                // doSomething(node.getValue());
            } else if (key.contains("author")) {
                // Transformation based on author
                // doSomethingElse(node.getValue());
            }
        });

        // Extract titles from JSON nodes
        List<String> titles = obj.toStream()
                .filter(node -> node.getKey().contains("title"))
                .map(JSONObject.JSONNode::getValue)
                .map(String::valueOf)
                .collect(Collectors.toList());

        // Perform transformation on nodes with certain properties
        obj.toStream().filter(node -> node.getKey().contains("author"))
                .forEach(node -> {
                    String author = (String) node.getValue();
                    if (author.equals("ASmith")) {
                        // Transformation for ASmith
                        // doSomethingSpecial(node.getValue());
                    } else if (author.equals("BSmith")) {
                        // Transformation for BSmith
                        // doSomethingDifferent(node.getValue());
                    }
                });
    }
}
