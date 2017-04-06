package com.runmvc.JsonApi;

public class JsonRelationDataDTO {
  JsonRelationDTO data;

  String getId() {
    return this.data.getId();
  }
}

class JsonRelationDTO {
  String type;
  String id;

  String getId() {
    return this.id;
  }
}
