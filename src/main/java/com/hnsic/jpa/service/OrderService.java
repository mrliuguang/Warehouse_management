package com.hnsic.jpa.service;

import com.hnsic.jpa.entity.po.Order;
import com.hnsic.jpa.entity.vo.OrderVo;
import org.springframework.data.domain.Page;

public interface OrderService {
    public Order saveOrder(Order po);
    public Page<OrderVo> findall(Integer page);
    public int deleteRecording(Integer id);
}
