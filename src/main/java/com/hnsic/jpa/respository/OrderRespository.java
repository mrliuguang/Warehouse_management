package com.hnsic.jpa.respository;

import com.hnsic.jpa.entity.po.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRespository extends JpaRepository<Order, Integer> {
}
