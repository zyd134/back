package com.zhang.controller;

import com.zhang.pojo.Result;
import com.zhang.pojo.User;
import com.zhang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/loginController")
public class LoginController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @RequestMapping("/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        String password = requestUser.getPassword();
        password = HtmlUtils.htmlEscape(password);
        Map<String,Object> map = new HashMap<String,Object>();
        //key是字段名，value是字段值
        map.put("username", username);
        map.put("password", password);
        Collection<User> userLists = userService.listByMap(map);
        if (userLists.isEmpty() || userLists.size() == 0) {

            return new Result(400);
        } else {
            return new Result(200);
        }
    }
}
