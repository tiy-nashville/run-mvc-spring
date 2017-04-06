package com.runmvc.JsonApi;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonApiDataDTO<T> {
  public String type;

  public String id;

  T attributes;
  Map<String, JsonRelationDTO> relationships;

  public JsonApiDataDTO(
    @JsonProperty("type") String type,
    @JsonProperty("id") String id,
    @JsonProperty("attributes") T attributes
    ) {
    this.type = type;
    this.id = id;
    this.attributes = attributes;
  }


  public String getType() {
    return this.type;
  }

  public String getId() {
    return this.id;
  }

  public T getEntity() {
    return this.attributes;
  }

  public Object getRelation(String key) {
    return this.relationships.get(key).getId();
  }
}
