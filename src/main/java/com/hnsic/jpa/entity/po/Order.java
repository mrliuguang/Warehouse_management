package com.hnsic.jpa.entity.po;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 订单表 标志一个订单,主要字段为：订单id,进货方,进货日期,订单的序列号(一个订单中的货物序列)
 * ClassName Order
 * Description too
 * Aouthor   Administrator
 * Date      2020/2/9 0009  14:25
 * Version   1.0
 **/
@Data
@Entity
@Table(name = "product_order")
public class Order implements Serializable {
    private static final long serialVersionUID = -8311686744924637687L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderid;
    //订单id
    @Column
    private String orderName;
    //订单名称
    @Column
    private String Source_name;
    //进货来源
    @Column
    private Date bille_date;
    //进货时间
    @Column
    private String serial_num;
     //订单的序列号
}
