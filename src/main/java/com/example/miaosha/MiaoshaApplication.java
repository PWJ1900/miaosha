package com.example.miaosha;

import com.example.miaosha.dao.UserDOMapper;
import com.example.miaosha.dataobject.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"com.example.miaosha"})//此处使用的是包向下扫描
@RestController
@MapperScan("com.example.miaosha.dao")
public class MiaoshaApplication {

  @Autowired
  public UserDOMapper userDOMapper;
    @RequestMapping("/")
    public String home(){
      UserDO userDO = userDOMapper.selectByPrimaryKey(1);
      if(userDO == null){
        return "用户不存在";
      }else
      {
        return userDO.getName();
      }
    }
  public static void main(String[] args) {
    SpringApplication.run(MiaoshaApplication.class, args);
  }

}
