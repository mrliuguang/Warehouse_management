package com.hnsic.jpa.controller;

import com.hnsic.jpa.service.OrderService;
import com.hnsic.jpa.service.RecordingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * ClassName OrderController
 * Description too
 * Aouthor   Administrator
 * Date      2020/2/18 0018  15:00
 * Version   1.0
 **/
@Controller
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    RecordingService recordingService;
    @RequestMapping(value = "/Order",produces={"text/html;charset=UTF-8;","application/json"},method = RequestMethod.POST)//增加一个货物信息
    public String addProduct(@RequestBody String order) throws UnsupportedEncodingException {
        System.out.println("add");
        String decode = URLDecoder.decode(order, "utf-8");
        System.out.println(decode);
        return "redirect:/Products/1";
    }
}
