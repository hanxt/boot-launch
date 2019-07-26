package com.zimug.bootlaunch.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


import java.io.Serializable;

@Data
@RedisHash("people")
public class Person implements Serializable {

  private static final long serialVersionUID = -8985545025228238754L;

  @Id
  String id;
  String firstname;
  String lastname;
  Address address;

  public Person(String firstname, String lastname) {
    this.firstname = firstname;
    this.lastname = lastname;
  }
}