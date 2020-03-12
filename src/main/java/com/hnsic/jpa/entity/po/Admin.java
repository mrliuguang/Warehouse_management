package com.hnsic.jpa.entity.po;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * ClassName admin
 * Description too
 * Aouthor   Administrator
 * Date      2020/3/9 0009  20:41
 * Version   1.0
 **/
@Data
@Entity
@Table(name = "product_admin")
public class Admin implements Serializable {
    private static final long serialVersionUID = -8311686744924637687L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;
    @Column
    private String adminName;
    @Column
    private String adminPwd;
}
