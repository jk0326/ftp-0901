package com.aaa.cjk.ftp.controller;

import com.aaa.cjk.ftp.model.User;
import com.aaa.cjk.ftp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author 陈佳康
 * @date 2019-09-02 19:12
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;


    @RequestMapping("/")
    public String turnIndex(){
        return "login";
    }


    /**
    * @author  陈佳康
    * @description 处理用户登陆
    */
    @RequestMapping("/userLogin")
    public String login(User user, HttpSession session){
        Map<String, Object> resultMap = loginService.login(user);
        int code = (Integer) resultMap.get("code");
        if (200 == code){
            //如果该用户已经注册，则将用户信息添加至session中，
            User u = (User) resultMap.get("result");
            u.setPassword("");
            session.setAttribute("user",u);
            return "upload";
        }
        return "404";
    }
}
