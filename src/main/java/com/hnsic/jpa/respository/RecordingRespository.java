package com.hnsic.jpa.respository;

import com.hnsic.jpa.entity.po.Recording;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecordingRespository extends JpaRepository<Recording,Integer> {
    @Query(value = "select * from product_recording where orderid =?1",nativeQuery = true)
    List<Recording> findAllByOrderId(Integer orderId);
}
