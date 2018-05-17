package com.ssm.demo.controller;

import com.ssm.demo.model.User;
import com.ssm.demo.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by renwujie on 2018/05/17 at 20:53
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private IUserService userService;

    @Resource
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/list", params = "json")
    @ResponseBody
    public List<User> list(Model model, String param) {
        List<User> users = userService.findUser();
        model.addAttribute("users", users);
        return users;
    }
}
