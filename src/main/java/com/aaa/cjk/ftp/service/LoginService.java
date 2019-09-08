package com.aaa.cjk.ftp.service;

import com.aaa.cjk.ftp.mapper.UserMapper;
import com.aaa.cjk.ftp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈佳康
 * @date 2019-09-02 19:01
 */
@Service
public class LoginService {

    @Autowired
    private UserMapper userMapper;

    /**
    * @author  陈佳康
    * @description 用户登陆，通过用户名和密码去数据库查询是否存在该用户
    */
    public Map<String,Object> login(User u){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        User user = userMapper.getUserByUsernameAndPassword(u);
        if (null != user && !"".equals(user.getUsername())){
            //说明查到了数据

            resultMap.put("code",200);
            resultMap.put("result",user);
        }else {
            resultMap.put("code",404);
        }
        return resultMap;
    }

}
