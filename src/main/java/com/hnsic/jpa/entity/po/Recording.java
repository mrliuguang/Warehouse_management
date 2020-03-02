package com.hnsic.jpa.entity.po;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 记录表 记录货物的进货主要字段为：记录id,货物名称,数量,价格,货物订单号,货物的备注
 * ClassName recoding
 * Description too
 * Aouthor   Administrator
 * Date      2020/2/18 0018  13:10
 * Version   1.0
 **/
@Data
@Entity
@Table(name = "product_recording")
public class Recording implements Serializable {
    private static final long serialVersionUID = -4596633662179028563L;
    //货物id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recordingid;
    @Column
    //货物名称
    private String product_name;
    //价格
    @Column
    private Integer number;
    //数量
    @Column
    private String price;
    //进货时的备注
    @Column
    private String note;
    //订单的id
    @Column
    private Integer orderid;
}
