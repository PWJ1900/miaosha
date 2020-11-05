package com.example.miaosha.controller.viewobject;

public class UserVO {
  private Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  private String name;
  private Integer age;

  public String getTelpone() {
    return telpone;
  }

  public void setTelpone(String telpone) {
    this.telpone = telpone;
  }

  private String telpone;

  public void setGender(Byte gender) {
    this.gender = gender;
  }

  private Byte gender;
}
