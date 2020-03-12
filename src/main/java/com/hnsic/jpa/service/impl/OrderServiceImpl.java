package com.hnsic.jpa.service.impl;

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
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    @Autowired
    RecordingRespository recordingRespository;
    @Autowired
    RecordingService recordingService;
    @Override
    public Order saveOrder(Order po) {
        return  orderRespository.save(po);
    }

    @Override
    public Page<OrderVo> findall(Integer page) {
        Page<Order> productpage  = orderRespository.findAll(PageRequest.of(page-1, 2));
        PageImpl<OrderVo> OrderVos = new PageImpl<>(toOrderVos(productpage.getContent()), PageRequest.of(page - 1, 10), productpage.getTotalElements());
        return OrderVos;
    }
    private List<OrderVo> toOrderVos(List<Order> orders) {
        List<OrderVo> vos = new ArrayList<>();
        orders.forEach(po -> {
            vos.add(BeanUtils.Order_Po_to_Vo(po,recordingRespository.findAllByOrderId(po.getOrderid())));
        });

        return vos;
    }
    public int deleteRecording(Integer id){
        Optional<Order> byId = orderRespository.findById(id);
        List<Recording> allByOrderId = recordingRespository.findAllByOrderId(id);
        allByOrderId.forEach(recording->{recordingService.deleteRecording(recording.getRecordingid());});
        orderRespository.deleteById(id);
        return 1;
    }
}
