package com.hnsic.jpa.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hnsic.jpa.entity.po.Order;
import com.hnsic.jpa.entity.po.Recording;
import com.hnsic.jpa.entity.vo.OrderVo;
import com.hnsic.jpa.respository.OrderRespository;
import com.hnsic.jpa.respository.RecordingRespository;
import com.hnsic.jpa.service.OrderService;
import com.hnsic.jpa.service.RecordingService;
import com.hnsic.jpa.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
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
    @Autowired
    RecordingRespository recordingRespository;
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
    @GetMapping("/Orders")//获得所有订单信息
    public String showAllOrders( Model model){
//        Page<OrderVo> orderVos = orderService.findall(page);
//        model.addAttribute("orders",orderVos.getContent());
        model.addAttribute("page", 1);
        return "showOrder";
    }
    @ResponseBody
    @RequestMapping(value = "/Orders/{page}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getAllOrders( @PathVariable Integer page){
        Page<OrderVo> orderVos = orderService.findall(page);
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("data", orderVos.getContent());
        String jsonString = JSONObject.toJSONString(stringObjectHashMap);
        System.out.println("json"+jsonString);
        return jsonString;
    }
    @ResponseBody
    @RequestMapping(value = "/getOrder/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String findOrderById( @PathVariable Integer id){
        List<Recording> allByOrderId = recordingRespository.findAllByOrderId(id);
        String jsonString = JSONObject.toJSONString(allByOrderId);
        System.out.println("recordingList"+jsonString);
        return jsonString;
    }
    @GetMapping("/Order/{id}")//获得指定编号的货物信息
    public String findOrderById(@PathVariable Integer id,Model model){
        System.out.println("edit: "+id);
        Optional<Order> byId = orderRespository.findById(id);
        OrderVo orderVo = BeanUtils.Order_Po_to_Vo(byId.get(), recordingRespository.findAllByOrderId(id));
        model.addAttribute("order",orderVo);
        return "add_edit/order";
    }

    @PutMapping(value = "/Order",produces={"application/json;charset=UTF-8;"})//修改货物信息
    public String editOrderById(@RequestBody String orderJSON)throws UnsupportedEncodingException{
        System.out.println("edit");
        String decode = URLDecoder.decode(orderJSON, "utf-8");
        JSONObject jsonObject = JSON.parseObject(decode);
        JSONObject orderJSONObject = (JSONObject) jsonObject.get("order");
        JSONArray products = (JSONArray) jsonObject.get("products");
        Order order = JSON.parseObject(orderJSONObject.toString(), Order.class);
        orderRespository.saveAndFlush(order);
        List<Recording> recordings=new LinkedList<>();
        for(int i=0;i<products.size();i++)
        {
            Recording recording = JSON.parseObject(products.getString(i), Recording.class);
            recording.setOrderid(order.getOrderid());
            recordingRespository.saveAndFlush(recording);
        }
        return "redirect:/Orders/1";
    }
    @DeleteMapping(value = "/Order/{id}")
    public String deleteOrder(@PathVariable int id){
        orderService.deleteRecording(id);
        return "redirect:/Orders";
    }
}
