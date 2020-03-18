package com.hnsic.jpa.utils;

import com.hnsic.jpa.entity.po.Order;
import com.hnsic.jpa.entity.po.Product;
import com.hnsic.jpa.entity.po.Recording;
import com.hnsic.jpa.entity.vo.OrderVo;
import com.hnsic.jpa.entity.vo.ProductVo;

import java.util.List;

/**
 * 将product和productvo互换、order和ordervo互换
 * 但不包括po对象转换成vo对象时记录表字段的赋值
 * ClassName BeanUtils
 * Description too
 * Aouthor   Administrator
 * Date      2020/2/18 0018  13:54
 * Version   1.0
 **/
public class BeanUtils {

    public static Product product_Vo_to_Po(ProductVo vo){
        Product po=new Product();
        if(vo.getProductid()!=null)
            po.setProductid(vo.getProductid());
        else
            po.setProductid(null);
        po.setProduct_name(vo.getProduct_name());
        po.setNumber(vo.getNumber());
        po.setAmount(vo.getAmount());
        po.setNote(vo.getNote());
        po.setPrice(vo.getPrice());
        po.setUnit(vo.getUnit());
        po.setSerial_number(vo.getSerial_number());
        return po;
    }
    public static ProductVo product_Po_to_Vo(Product po){
        ProductVo vo=new ProductVo();
        vo.setProductid(po.getProductid());
        vo.setProduct_name(po.getProduct_name());
        vo.setNumber(po.getNumber());
        vo.setSerial_number(po.getSerial_number());
        vo.setAmount(po.getAmount());
        vo.setNote(po.getNote());
        vo.setPrice(po.getPrice());
        vo.setUnit(po.getUnit());
        return vo;
    }
    public static Order Order_Vo_to_Po(OrderVo vo){
        Order po=new Order();
        if(vo.getOrderid()!=null)
            po.setOrderid(vo.getOrderid());
        else
            po.setOrderid(null);
        po.setOrderName(vo.getOrderName());
        po.setBiller(vo.getBiller());
        po.setDate(vo.getDate());
        po.setTel(vo.getTel());
        return po;
    }
    public static OrderVo Order_Po_to_Vo(Order po, List<Recording> recordings){
        OrderVo vo=new OrderVo();
        vo.setOrderid(po.getOrderid());
        vo.setOrderName(po.getOrderName());
        vo.setDate(po.getDate());
        vo.setBiller(po.getBiller());
        vo.setTel(po.getTel());
        vo.setRecordingList(recordings);
        return vo;
    }

}
