package com.book.mbp.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.book.mbp.entity.EntityBase;
import java.io.Serializable;
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
public class Configuration extends EntityBase {

    private static final long serialVersionUID = 1L;

    /**
     * 学号或者教师编号
     */
    @TableId(value = "student_num")
    private String studentNum;

    /**
     * 最多可借天数
     */
    private Integer maxNum;

    /**
     * 最多可续借天数
     */
    private Integer maxRenewalDays;
}
