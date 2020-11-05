package com.example.miaosha.service.impl;

import com.example.miaosha.dao.UserDOMapper;
import com.example.miaosha.dao.UserPasswordDOMapper;
import com.example.miaosha.dataobject.UserDO;
import com.example.miaosha.dataobject.UserPasswordDO;
import com.example.miaosha.service.UserService;
import com.example.miaosha.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserDOMapper userDOMapper;

  @Autowired
  private UserPasswordDOMapper userPasswordDOMapper;

  @Override
  public UserModel getUserById(Integer id) {//先设置完了
    //调用userdomapper获取到对应的用户的dataobject
    UserDO userDO = userDOMapper.selectByPrimaryKey(id);//在企业开发上，这个userdo是绝对不能传到前端的
    if(userDO == null){
      return null;
    }
    //通过用户的id（上个表）获取用户加密的密码信息
    UserPasswordDO userPasswordDO = userPasswordDOMapper.selectByUserId(userDO.getId());
    return convertFromDataObject(userDO,userPasswordDO);//这里是把其变为model返回控制层
  }
  private UserModel convertFromDataObject(UserDO userDO, UserPasswordDO userPasswordDO){
    if(userDO == null){
      return null;
    }
    UserModel userModel = new UserModel();
    BeanUtils.copyProperties(userDO,userModel);
    if(userPasswordDO!=null){
      userModel.setEncrptPassword(userPasswordDO.getEncrptPassword());//使usermodel从映射中获取数据


    }

    return userModel;
  }
}
