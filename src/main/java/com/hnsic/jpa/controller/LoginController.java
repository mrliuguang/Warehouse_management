package com.hnsic.jpa.controller;

import com.hnsic.jpa.entity.po.Admin;
import com.hnsic.jpa.respository.AdminRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Optional;

@Controller
public class LoginController {
    @Autowired
    AdminRespository adminRespository;
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String username, @RequestParam String password, Map<String, Object> map, HttpServletRequest request) {
        Admin admin=new Admin();
        admin.setAdminName(username);
        ExampleMatcher matcher=ExampleMatcher.matching().withMatcher("adminName", ExampleMatcher.GenericPropertyMatchers.contains());
        Example<Admin> of = Example.of(admin, matcher);
        Optional<Admin> one = adminRespository.findOne(of);
        if(one==null)
        {
            map.put("msg", "用户名错误");
            return "login";
        }
        String adminPwd = one.get().getAdminPwd();
        if (password.equals(adminPwd)) {
            request.setAttribute("loginUser", username);
            return "index";
        } else {
            map.put("msg", "密码错误");
            return "login";
        }

    }
}
