package com.hnsic.jpa.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hnsic.jpa.entity.po.Order;
import com.hnsic.jpa.entity.po.Recording;
import com.hnsic.jpa.entity.vo.OrderVo;
import com.hnsic.jpa.respository.OrderRespository;
import com.hnsic.jpa.service.OrderService;
import com.hnsic.jpa.service.RecordingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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
    @Autowired
    OrderRespository orderRespository;
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
    @GetMapping(value = "/toOrderAdd")
    public String toAdd(){
        System.out.println("toOrderadd");
        return "add_edit/order";
    }
    @GetMapping("/Orders/{page}")//获得所有订单信息
    public String showAllProduct(@PathVariable Integer page, Model model){
        Page<OrderVo> orderVos = orderService.findall(page);
        model.addAttribute("orders",orderVos.getContent());
        model.addAttribute("page", page);
        return "showOrder";
    }
    @GetMapping("/Order/{id}")//获得指定学号的货物信息
    public String findOrderById(@PathVariable Integer id,Model model){
        System.out.println("edit: "+id);
        Optional<Order> byId = orderRespository.findById(id);
        model.addAttribute("order", byId.get());
        return "add_edit/order";
    }
    @PutMapping(value = "/Order")//修改货物信息
    public String editOrderById(OrderVo orderVo, Model model){
        orderRespository.saveAndFlush(orderVo);
        return "redirect:/Orders/1";
    }
    @DeleteMapping(value = "/Order/{id}")
    public String deleteOrder(@PathVariable int id){
        orderService.deleteRecording(id);
        return "redirect:/Orders/1";
    }
}
