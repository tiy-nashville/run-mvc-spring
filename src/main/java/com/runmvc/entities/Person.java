package com.runmvc.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue
    int id;

    @Column
    String first;

    @Column
    Integer last;

    @Transient
    String profileId;

    public Person(String first, Integer last, String profileId) {
        this.first = first;
        this.last = last;
        this.profileId = profileId;
    }

    public Person() {
    }

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