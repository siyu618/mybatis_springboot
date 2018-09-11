package com.study.mybatis_springboot.controller;

import com.study.mybatis_springboot.model.User;
import com.study.mybatis_springboot.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class UserController {


    @Autowired
    private UserServiceI userService;

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public List<User> getUserInfo() {
        List<User> users = userService.getUserInfo();
        if (users != null) {

            for (User user : users) {
                System.out.println("user.getUsername():" + user.getUsername());
            }

        }
        return users;
    }

    @RequestMapping("/getUserInfo/{uid}")
    @ResponseBody
    public User getUserById(@PathVariable String uid) {
        System.out.println("getUserInfo" + uid);
        User user = userService.getUserById(Long.valueOf(uid));
        if (user != null) {
            System.out.println("user.getUsername():" + user.getUsername());
        }
        return user;
    }

    @RequestMapping(value="/incUserAge/{uid}", method=RequestMethod.GET)
    @ResponseBody
    public User update(@PathVariable String uid) {
        User user = userService.getUserById(Long.valueOf(uid));
        if (user != null) {
            user.setAge(user.getAge() + 1);
            userService.update(user);
            System.out.println("user.getUsername():" + user.getUsername());
        }
        return user;
    }

    @RequestMapping(value="/addUser/{name}", method=RequestMethod.GET)
    @ResponseBody
    public int insert(@PathVariable String name) {
        User user = new User();
        user.setAge(10);
        user.setUsername(name);
        return userService.insert(user);
    }

    @RequestMapping(value="/rmUser/{uid}", method=RequestMethod.GET)
    @ResponseBody
    public int rmUser(@PathVariable String uid) {
        User user = userService.getUserById(Long.valueOf(uid));
        if (null != user) {
            System.out.printf("remove user : " + uid);
        }
        return userService.delete(user);
    }




    @RequestMapping("/hi")
    @ResponseBody
    public String hi() {
        return "hi";
    }
}
