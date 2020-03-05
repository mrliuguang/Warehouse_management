package com.hnsic.jpa.service.impl;

import com.hnsic.jpa.entity.po.Order;
import com.hnsic.jpa.respository.OrderRespository;
import com.hnsic.jpa.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName OrderServiceImpl
 * Description too
 * Aouthor   Administrator
 * Date      2020/2/10 0010  14:16
 * Version   1.0
 **/
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRespository orderRespository;
    @Override
    public Order saveOrder(Order po) {
        return  orderRespository.save(po);
    }
}
