package com.hnsic.jpa.service.impl;

import com.hnsic.jpa.entity.po.Product;
import com.hnsic.jpa.entity.po.Recording;
import com.hnsic.jpa.entity.vo.ProductVo;
import com.hnsic.jpa.respository.ProductRespository;
import com.hnsic.jpa.service.ProductService;
import com.hnsic.jpa.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * ClassName ProductServiceImpl
 * Description too
 * Aouthor   Administrator
 * Date      2020/2/10 0010  14:15
 * Version   1.0
 **/
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRespository productRespository;
    @Override
    public  Page<ProductVo> findall(Integer page) {
        Page<Product> productpage  = productRespository.findAll(PageRequest.of(page-1, 2));
        PageImpl<ProductVo> productVos = new PageImpl<>(toProductVos(productpage.getContent()), PageRequest.of(page - 1, 10), productpage.getTotalElements());
        return productVos;
    }
    @Override
    public int findByNameAdd(String name, Recording recording) {
        System.out.println("更改货物库存....");
        Product byName = productRespository.findByName(name);
        if(byName==null)
        {
            System.out.println("系统还没有货物"+name);
            productRespository.save(new Product(name,1));
        }
        else {
            System.out.println("货物"+name+"仓库数量为"+byName.getNumber());
            System.out.println("货物"+name+"数量增加"+recording.getNumber());
            byName.setNumber(byName.getNumber()+recording.getNumber());
            System.out.println("更改后，货物"+name+"仓库数量为"+byName.getNumber());
        }
        return 1;
    }

    @Override
    public void lessUp(Recording recording) {
        System.out.println("更改货物库存....");
        String product_name = recording.getProduct_name();
        Product byName = productRespository.findByName(product_name);
        System.out.println("货物"+byName+"仓库数量为"+byName.getNumber());
        System.out.println("货物"+byName+"数量减少"+recording.getNumber());
        byName.setNumber(byName.getNumber()-recording.getNumber());
        System.out.println("更改后，货物"+byName+"仓库数量为"+byName.getNumber());
    }

    private List<ProductVo> toProductVos(List<Product> pos) {
        List<ProductVo> vos = new ArrayList<>();
        HashSet<Integer> productids = new HashSet<>();
        HashSet<Integer> groupIds = new HashSet<>();
        pos.forEach(po -> {
            vos.add(BeanUtils.product_Po_to_Vo(po));
        });
        return vos;
    }

}
