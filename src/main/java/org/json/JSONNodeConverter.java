package org.json;

import java.util.stream.Stream;

public class JSONNodeConverter {

    public Stream<JSONObject.JSONNode> toStream(JSONObject jsonObject) {
        return toStream(jsonObject, "");
    }

    private Stream<JSONObject.JSONNode> toStream(Object json, String keyPrefix) {
        if (json instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) json;
            Stream<JSONObject.JSONNode> objectStream = Stream.of(new JSONObject.JSONNode(jsonObject, keyPrefix)); // Include prefix for object node
            Stream<JSONObject.JSONNode> nestedStream = jsonObject.keySet()
                    .stream()
                    .flatMap(key -> toStream(jsonObject.get(key), keyPrefix + key + "/")); // Append key to prefix for nested nodes
            return Stream.concat(objectStream, nestedStream);
        } else if (json instanceof JSONArray) {
            JSONArray jsonArray = (JSONArray) json;
            return jsonArray.toList().stream()
                    .flatMap(element -> toStream(element, keyPrefix)); // Recursively flatten nested arrays
        } else {
            return Stream.of(new JSONObject.JSONNode(json, keyPrefix)); // Include prefix for leaf nodes
        }
    }
}
