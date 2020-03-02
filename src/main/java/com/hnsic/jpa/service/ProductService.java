package com.hnsic.jpa.service;

import com.hnsic.jpa.entity.po.Recording;
import com.hnsic.jpa.entity.vo.ProductVo;
import org.springframework.data.domain.Page;

/**
 * ClassName ProductService
 * Description too
 * Aouthor   Administrator
 * Date      2020/2/10 0010  14:14
 * Version   1.0
 **/
public interface ProductService {
    public Page<ProductVo> findall(Integer page);
    int findByNameAdd(String name, Recording recording);

    void lessUp(Recording recording);
}
