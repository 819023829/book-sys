package com.book.mbp.entity.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zcz
 * @created 2022/9/30 11:53
 */
@Data
@ApiModel
public class ConfigurationListDto {
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

    /**
     * 姓名
     */

    private String name;

    /**
     * 学院
     */

    private String college;


    /**
     * 电话
     */
    private Integer phone;

    /**
     * 起始页
     */
    @ApiModelProperty("起始页")
    private Integer pageNum;

    @ApiModelProperty("每页大小")
    private Integer pageSize;
}
