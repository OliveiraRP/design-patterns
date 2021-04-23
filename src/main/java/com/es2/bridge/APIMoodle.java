package com.es2.bridge;

import java.util.LinkedHashMap;
import java.util.UUID;

public class APIMoodle implements APIServiceInterface {

    protected LinkedHashMap<String, String> content = new LinkedHashMap<>();

    public APIMoodle() {}

    public String getContent(String contentId) {
        if(contentId.compareTo("0") == 0) {
            String connect = "";
            for(String s : content.keySet()) {
                connect += content.get(s);
            }
            return connect;
        } else if(content.containsKey(contentId)) {
            return content.get(contentId);
        }
        else
            return null;
    }

    public String setContent(String content) {
        String id = UUID.randomUUID().toString();
        this.content.put(id, content);
        return id;
    }
}
