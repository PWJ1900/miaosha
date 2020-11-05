package com.example.miaosha.controller;


import com.example.miaosha.controller.viewobject.UserVO;
import com.example.miaosha.response.CommReturnType;
import com.example.miaosha.service.UserService;
import com.example.miaosha.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("user")
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;
  @RequestMapping("/get")
  @ResponseBody
//  public UserModel getUser(@RequestParam(name = "id") Integer id){
//    //调用service服务获取对应id的用户对象并返回给前端
//    UserModel userModel = userService.getUserById(id);
//    return userModel;
//  }


//
  public CommReturnType getUser(@RequestParam(name = "id") Integer id){
    //调用service服务获取对应id的用户对象并返回给前端
    UserModel userModel = userService.getUserById(id);
    UserVO userVO = convertFromUserModel(userModel);
    return CommReturnType.create(userVO);
  }

  private UserVO convertFromUserModel(UserModel userModel){
    if(userModel == null){
      return null;
    }
    UserVO userVO = new UserVO();
    BeanUtils.copyProperties(userModel, userVO);
    return userVO;
  }



}



