package com.hnsic.jpa.entity.po;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * po对象主要分为
 * 货物表 记录所有系统中已有的货物,主要字段为：货物id,货物名称,数量,
 * 记录表 记录货物的进货主要字段为：记录id,货物名称,数量,订单,价格,货物订单号
 * 订单表 标志一个订单,主要字段为：订单id,进货方,进货日期
 *
 * Description too
 * Aouthor   Administrator
 * Date      2020/2/4 0004  16:55
 * Version   1.0
 **/
@Data
@Entity
@Table(name = "product")
public class  Product implements Serializable {
    public Product(){

    }
    private static final long serialVersionUID = 8336472923398052056L;
    //货物id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productid;
    @Column
    //货物名称
    private String product_name;
    //数量
    @Column
    private Integer number;

    public Product(String name, int num) {
        this.product_name=name;
        this.number=num;
    }
}
