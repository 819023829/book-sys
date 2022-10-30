package com.book.mbp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class Reader extends EntityBase {

    private static final long serialVersionUID = 1L;

    /**
     * 读者id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 学号或教师编号
     */
    private String studentNum;

    /**
     * 姓名
     */
    private String name;

    /**
     * 专业
     */
    private String professional;

    /**
     * 学院
     */
    private String college;

    /**
     * 联系电话
     */
    private Integer phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 权限级别（3：读者，默认为3）
     */
    private Integer permission;
}
