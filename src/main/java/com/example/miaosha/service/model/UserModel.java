package com.example.miaosha.service.model;

public class UserModel {//这是真正意义上处理业务逻辑的一个核心的模型
  private Integer id;


  public void setGender(Byte gender) {
    this.gender = gender;
  }

  private Byte gender;

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


  public String getRegisterMode() {
    return registerMode;
  }

  public void setRegisterMode(String registerMode) {
    this.registerMode = registerMode;
  }

  public String getThirdPartyId() {
    return thirdPartyId;
  }

  public void setThirdPartyId(String thirdPartyId) {
    this.thirdPartyId = thirdPartyId;
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
  private String registerMode;
  private String thirdPartyId;

  public String getEncrptPassword() {
    return encrptPassword;
  }

  public void setEncrptPassword(String encrptPassword) {
    this.encrptPassword = encrptPassword;
  }

  private String encrptPassword;

}
