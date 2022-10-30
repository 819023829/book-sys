package com.book.mbp.entity.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author zcz
 * @created 2022/9/28 10:32
 */
@Data
@Api("返回预定图书列表")
public class ReserveListDto {
    @ApiModelProperty("预定图书记录 id")
    private String id;

    /**
     * 图书id
     */
    @ApiModelProperty("图书id")
    private String bookId;

    /**
     * 图书编号
     */
    @ApiModelProperty("图书编号")
    private String bookNum;

    /**
     * 学号或者教师编号
     */
    @ApiModelProperty("学号或者教师编号")
    private String studentNum;

    /**
     * 预定开始时间
     */
    @ApiModelProperty("预定开始时间")
    private LocalDateTime reserveDate;

    /**
     * 预定归还时间
     */
    @ApiModelProperty("预定归还时间")
    private LocalDateTime giveBackDate;

    /**
     * 书作者
     */
    @ApiModelProperty("图书作者")
    private String bookAuthor;

    /**
     * 书名称
     */
    @ApiModelProperty("图书名称")
    private String bookName;
}
