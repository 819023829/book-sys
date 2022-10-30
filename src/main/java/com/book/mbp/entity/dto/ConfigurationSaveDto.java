package com.book.mbp.entity.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author zcz
 * @created 2022/9/29 10:33
 */
@Data
public class ConfigurationSaveDto {
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
