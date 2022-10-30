package com.book.mbp.entity.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zcz
 * @created 2022/9/30 13:30
 */
@Data
public class ConfigurationUpdateDto implements Serializable {

    /**
     * 学号或者教师编号
     */
    @TableId("student_num")
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
