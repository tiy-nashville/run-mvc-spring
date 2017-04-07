package com.runmvc.controllers;

import com.runmvc.PersonRepository;
import com.runmvc.entities.Author;
import com.runmvc.entities.Person;
import com.runmvc.jsonApi.JsonApiDTO;
import com.runmvc.serializers.AuthorSerializer;
import com.runmvc.serializers.HasId;
import com.runmvc.serializers.RootSerializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    PersonRepository persons;

    @RequestMapping(path = "/users", method = RequestMethod.POST)
    Person saveAuthor(@RequestBody JsonApiDTO<Person> body) {
        Person p = body.getData().getEntity();
        System.out.printf("Person = %s %d", p.getFirst(), p.getLast());
        persons.save(p);

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
