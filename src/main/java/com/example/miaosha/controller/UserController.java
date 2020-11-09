package com.example.miaosha.controller;


import com.example.miaosha.controller.viewobject.UserVO;
import com.example.miaosha.error.BusinessException;
import com.example.miaosha.error.EmBusinessError;
import com.example.miaosha.response.CommReturnType;
import com.example.miaosha.service.UserService;
import com.example.miaosha.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller("user")
@RequestMapping("/user")
public class UserController extends BaseController{

  @Autowired
  private UserService userService;

  @Autowired
  private HttpServletRequest httpServletRequest;//解决了异步问题，请放心使用

  //用户获取otp短信接口
  @RequestMapping("/getotp")
  @ResponseBody
  public CommReturnType getOtp(@RequestParam(name = "telphone")String telphone){
    //需要按照一定的规则生成otp验证码
    Random random = new Random();
    int randomint = random.nextInt(99999);
    randomint +=1000;
    String otpCode = String.valueOf(randomint);

    //将otp验证码同对应用户的手机号关联,使用httpsession的方式绑定他的手机号与OTPCODE
    httpServletRequest.getSession().setAttribute(telphone,otpCode);

    //将otp验证码通过短信通道发给用户，省略
    System.out.println("telphone=" +telphone + "&otpCode=" + otpCode);
    return CommReturnType.create(null);

  }



  @RequestMapping("/get")
  @ResponseBody
//  public UserModel getUser(@RequestParam(name = "id") Integer id){
//    //调用service服务获取对应id的用户对象并返回给前端
//    UserModel userModel = userService.getUserById(id);
//    return userModel;
//  }


//
  public CommReturnType getUser(@RequestParam(name = "id") Integer id) throws BusinessException {
    //调用service服务获取对应id的用户对象并返回给前端
//    UserModel userModel = userService.getUserById(id);
//    UserVO userVO = convertFromUserModel(userModel);
//    return CommReturnType.create(userVO);
    //若获取用户的对应信息不存在
    UserModel userModel = userService.getUserById(id);
    if (userModel == null){
     throw new BusinessException(EmBusinessError.USER_NOT_EXSIT);
//      userModel.setEncrptPassword("123");//如果是这语句则是一个未知错误
    }
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



