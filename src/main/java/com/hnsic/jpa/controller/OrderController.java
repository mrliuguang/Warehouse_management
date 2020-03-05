package com.hnsic.jpa.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hnsic.jpa.entity.po.Order;
import com.hnsic.jpa.entity.po.Recording;
import com.hnsic.jpa.service.OrderService;
import com.hnsic.jpa.service.RecordingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.LinkedList;
import java.util.List;

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
    @PostMapping(value = "/Order",produces={"application/json;charset=UTF-8;"})//增加一个货物信息
    public String addProduct(@RequestBody String orderJSON) throws UnsupportedEncodingException {
        System.out.println("add");
       String decode = URLDecoder.decode(orderJSON, "utf-8");
        JSONObject jsonObject = JSON.parseObject(decode);
        JSONObject orderJSONObject = (JSONObject) jsonObject.get("order");
        JSONArray products = (JSONArray) jsonObject.get("products");
        Order order = JSON.parseObject(orderJSONObject.toString(), Order.class);
        Integer orderid = (orderService.saveOrder(order)).getOrderid();
        List<Recording> recordings=new LinkedList<>();
        for(int i=0;i<products.size();i++)
        {
            Recording recording = JSON.parseObject(products.getString(i), Recording.class);
            recording.setOrderid(orderid);
            recordingService.saveRecording(recording);
           recordings.add(recording);
        }

        return "index";
    }

    @Test
    void contextLoads() {
        String s="{\"s\":\"s\"}";
        Object parse = JSON.parse(s);
        System.out.println(parse);
    }
}
