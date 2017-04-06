package com.runmvc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.runmvc.JsonApi.JsonApiDTO;
import com.runmvc.JsonApi.JsonApiDataDTO;
import com.runmvc.Serializers.AuthorSerializer;
import com.runmvc.Serializers.HasId;
import com.runmvc.Serializers.RootSerializer;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


class Person {
    String first;
    Integer last;
    String profileId;

    public String getFirst() {
        return this.first;
    }
    public Integer getLast() {
        return this.last;
    }

    public String getProfileId() {
        return this.profileId;
    }

    @JsonProperty("first-name")
    public void setFirst(String val) {
        this.first = val;
    }

    public void setProfileId(String val) {
        this.profileId = val;
    }
    public void setLast(Integer val) {
        this.last = val;
    }
    
}

@RestController
public class AuthorController {

    @RequestMapping(path = "/users", method = RequestMethod.POST)
    public Person saveAuthor(@RequestBody JsonApiDTO<Person> body) {
        Person p = body.getData().getEntity();

        System.out.println(body.getData().getRelationId("profile"));

        p.setProfileId(body.getData().getRelationId("profile"));


        return p;
    }


    @RequestMapping(path = "/users")
    public HashMap<String, Object> findAuthor() {
        RootSerializer s = new RootSerializer();
        AuthorSerializer authorSerializer = new AuthorSerializer();

        Author author = new Author(2000, "John", "Jastrow");
        Author author2 = new Author(2, "Ryan", "Tablada");
        List<HasId> authors = new ArrayList<>();

        authors.add(author);
        authors.add(author2);

        return s.serializeMany("/users", authors, authorSerializer);
    }
}
