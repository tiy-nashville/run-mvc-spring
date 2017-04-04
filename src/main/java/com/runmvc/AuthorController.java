package com.runmvc;

import com.runmvc.Serializers.AuthorSerializer;
import com.runmvc.Serializers.HasId;
import com.runmvc.Serializers.RootSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class AuthorController {
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
