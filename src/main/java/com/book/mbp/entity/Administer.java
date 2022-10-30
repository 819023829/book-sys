package com.book.mbp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author zcz
 * @since 2022-09-16
 */
@Getter
@Setter
public class Administer extends EntityBase {

    private static final long serialVersionUID = 1L;

    /**
     * 管理员id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 联系电话
     */
    private Integer phone;

    /**
     * 地址
     */
    private String address;

    /**
     * 登录账号
     */
    private String loginName;

    /**
     * 密码
     */
    @JsonIgnore
    private String password;

    /**
     * 权限级别（0：系统管理员，1：图书管理员）
     */
    private Integer permissions;
}
