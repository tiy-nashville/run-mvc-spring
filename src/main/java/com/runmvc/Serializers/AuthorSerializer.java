package com.runmvc.Serializers;

import com.runmvc.Author;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by ryan on 4/3/17.
 */
public class AuthorSerializer extends JsonDataSerializer {

    String getType() {
        return "author";
    }

    Map<String, String> getRelationshipUrls() {
        return new HashMap<String, String>() {{
            put("posts", "/author/:id/posts");
        }};
    }


    Map<String, Object> getAttributes(HasId data) {
        Author author = (Author) data;

        return new HashMap<String, Object>() {{
            put("first-name", author.getFirstName());
            put("last-name", author.getLastName());
        }};
    }
}
