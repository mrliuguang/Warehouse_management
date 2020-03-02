package com.hnsic.jpa.service;

import com.hnsic.jpa.entity.po.Order;
import com.hnsic.jpa.entity.vo.OrderVo;

public interface OrderService {
    public Order saveOrder(OrderVo vo);
}
