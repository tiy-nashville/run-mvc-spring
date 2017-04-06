package com.runmvc.entities;

import com.runmvc.serializers.HasId;

/**
 * Created by ryan on 4/3/17.
 */
public class Author implements HasId {
    Integer id;

    String firstName;

    String lastName;

    public Author(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getId() {
        return this.id.toString();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
