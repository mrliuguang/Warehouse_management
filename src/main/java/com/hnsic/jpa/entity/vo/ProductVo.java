package com.hnsic.jpa.entity.vo;

import com.hnsic.jpa.entity.po.Product;
import com.hnsic.jpa.entity.po.Recording;
import lombok.Data;

import java.util.List;

/**vo 主要分页面展示
 *    （productVo）系统中记录的所有货物直接展示：货物的id,货物的名称,货物的数量,货物的所有进货方,货物的不同进货方的价格*
 *    (OrderVo)系统中记录的一个订单的展示：订单的id,一个订单的名称,订单的进货方,同一个订单里的进货记录（此对象为recording）集合
 * ClassName productVo
 *
 * Aouthor   Administrator
 * Date      2020/2/18 0018  13:17
 * Version   1.0
 **/
@Data
public class ProductVo extends Product {

    private List<Recording> recordingList;
}
