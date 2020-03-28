package com.kang.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author klr
 * @create 2020-03-27-15:41
 */
@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/login")
//    @ResponseBody
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session){
        //判断用户参数
        if(!StringUtils.isEmpty(username)&&"123456".equals(password)){
            session.setAttribute("loginUser",username);
//          在中间加一道这个 kang > user/login  > main > dashboard          registry.addViewController("/main.html").setViewName("dashboard");
            return "redirect:/main.html";
        }
        else {
            model.addAttribute("msg","用户名或者密码错误！");
            return "index";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }
}
