package com.hnsic.jpa.respository;

import com.hnsic.jpa.entity.po.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * ClassName ProductRespository
 * Description too
 * Aouthor   Administrator
 * Date      2020/2/7 0007  11:00
 * Version   1.0
 **/
public interface ProductRespository extends JpaRepository<Product, Integer> {
    @Query(value = "select * from product where product_name =?1",nativeQuery = true)
    Product findByName(String name);
    @Query(value = "select * from product where productid =:id",nativeQuery = true)
    Product findByStudentId(@Param(value = "id") Integer id);
    @Query(value = "delete from product where productid = :id ",nativeQuery = true)
    void deleteByStudentId(@Param(value = "id") long id);
    @Query(value = "select * from product where product_name like :name",nativeQuery = true)
    List<Product> findLikeName(@Param(value = "name") String name);
}
