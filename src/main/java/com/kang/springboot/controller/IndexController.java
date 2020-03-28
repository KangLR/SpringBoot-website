package com.kang.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author klr
 * @create 2020-03-27-11:58
 */
@Controller
public class IndexController {

    //在config中配置了，就不用在这配了
//    @RequestMapping({"/","/index.html"})
//    public String index(){
//        return "index";
//    }
}
