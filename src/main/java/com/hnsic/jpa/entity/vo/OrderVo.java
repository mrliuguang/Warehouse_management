package com.hnsic.jpa.entity.vo;

import com.hnsic.jpa.entity.po.Order;
import com.hnsic.jpa.entity.po.Recording;
import lombok.Data;

import java.util.List;

/**
 * (OrderVo)系统中记录的一个订单的展示：订单的id,一个订单的名称,订单的日期,订单的进货方,同一个订单里的进货记录（此对象为recording）集合
 * ClassName OrderVo
 * Description too
 * Aouthor   Administrator
 * Date      2020/2/18 0018  13:42
 * Version   1.0
 **/
@Data
public class OrderVo extends Order {
    //所有同名货物的记录
    private List<Recording> recordingList;
}
