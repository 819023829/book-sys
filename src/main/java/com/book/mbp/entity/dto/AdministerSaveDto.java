package com.book.mbp.entity.dto;

import lombok.Data;

/**
 * @author zcz
 * @created 2022/9/20 13:32
 */
@Data
public class AdministerSaveDto {
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
     * 登录名（用户名）
     */
    private String loginName;

    /**
     * 密码
     */
    private String password;

    /**
     * 权限级别（0：系统管理员，1：图书管理员， 默认1）
     */
    private Integer permissions;

}