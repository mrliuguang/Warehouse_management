//package com.hnsic.jpa.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.thymeleaf.util.StringUtils;
//
//import javax.servlet.http.HttpSession;
//import java.util.Map;
//
//@Controller
//public class LoginController {
//
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String login(@RequestParam String username, @RequestParam String password, Map<String, Object> map, HttpSession session) {
//        System.out.println(username + "" + password);
//        if (!StringUtils.isEmpty(username) && password.equals("123456")) {
//            session.setAttribute("loginUser", username);
//            System.out.println(2);
//            return "index";
//        } else {
//            map.put("msg", "用户名密码错误");
//            return "login";
//        }
//
//    }
//}
