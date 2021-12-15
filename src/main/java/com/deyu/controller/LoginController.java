package com.deyu.controller;

import com.alibaba.fastjson.JSON;
import com.deyu.pojo.User;
import com.deyu.service.UserServiceImpl;
import com.deyu.util.UtilTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@CrossOrigin
@RequestMapping("/Login")
public class LoginController {
    @Autowired
    private UserServiceImpl userService;

    /**
     * 登录+
//     * @param user
     * @param session
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    @CrossOrigin
    public JSON login(String username, String password, HttpSession session){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return userService.login(user,session);
    }

    /**
     * 从session中获取登录状态
     * @param session
     * @param key
     * @return
     */
    @PostMapping("/session")
    @ResponseBody
    @CrossOrigin
    public Object session(HttpSession session,String key){
        return session.getAttribute(key);
    }
}
