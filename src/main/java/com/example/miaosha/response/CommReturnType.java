package com.example.miaosha.response;

public class CommReturnType {
  private String status;
  private Object data;
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  //表明对应的返回处理结果“success”或“fail”
  //若status=success，则data内返回前端需要的json
  //若status=fail，则data内使用通用的错误码格式
  //定义一个通用的创建方法
  public static CommReturnType create(Object result){
    return CommReturnType.create(result,"success");
  }
  public static CommReturnType create(Object result,String status){
    CommReturnType type = new CommReturnType();
    type.setStatus(status);
    type.setData(result);
    return type;
  }

}
