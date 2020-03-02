package com.hnsic.jpa.service.impl;

import com.hnsic.jpa.entity.po.Recording;
import com.hnsic.jpa.respository.RecordingRespository;
import com.hnsic.jpa.service.ProductService;
import com.hnsic.jpa.service.RecordingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * ClassName RecordingServiceImpl
 * Description too
 * Aouthor   Administrator
 * Date      2020/2/18 0018  14:51
 * Version   1.0
 **/
@Service
public class RecordingServiceImpl implements RecordingService {
    @Autowired
    RecordingRespository recordingRespository;
    @Autowired
    ProductService productService;
    @Override
    public List<Recording> saveRecordings(List<Recording> vos) {
        Iterable<Recording> recordingIterable= (Iterable<Recording>) vos.iterator();
        List<Recording> recordings = recordingRespository.saveAll(recordingIterable);
        return recordings;
    }

    @Override
    public Recording saveRecording(Recording vo) {
        System.out.println("存储货物记录....");
        productService.findByNameAdd(vo.getProduct_name(),vo);
        return recordingRespository.save(vo);
    }

    @Override
    public Page<Recording> findall(Integer page) {
        Page<Recording> Recordingpage  = recordingRespository.findAll(PageRequest.of(page-1, 100));
        return Recordingpage;
    }

    @Override
    public int deleteRecording(Integer id) {
        Optional<Recording> byId = recordingRespository.findById(id);
        System.out.println("根据货物记录id为"+ byId.get().getRecordingid()+"删除货物记录"+byId.get().getProduct_name());
        recordingRespository.deleteById(id);
        System.out.println("修改货物库存");
        productService.lessUp(byId.get());
        return 1;
    }
}
