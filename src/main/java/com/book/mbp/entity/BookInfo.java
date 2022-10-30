package com.book.mbp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.book.mbp.entity.EntityBase;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@TableName("book_info")
@ApiModel
public class BookInfo extends EntityBase {

    private static final long serialVersionUID = 1L;

    /**
     * 图书id
     */
    @TableId(value = "book_id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "图书id")
    private String bookId;

    /**
     * 图书名称
     */

    @ApiModelProperty(value = "图书名称")
    private String bookName;

    /**
     * 图书作者
     */
    @ApiModelProperty(value = "图书作者")
    private String bookAuthor;

    /**
     * 图书出版社
     */
    @ApiModelProperty(value = "图书出版社")
    private String publisher;

    /**
     * 图书价格
     */
    @ApiModelProperty(value = "图书价格")
    private BigDecimal bookPrice;

    /**
     * 图书摘要
     */
    @ApiModelProperty(value = "图书摘要")
    private String bookAbstarct;

    /**
     * 图书分类
     */
    @ApiModelProperty(value = "图书分类")
    private String bookType;

    /**
     * 图书入库时间
     */
    @ApiModelProperty(value = "图书入库时间")
    private LocalDateTime inputDate;

    /**
     * 图书总数量（借出的+现存的）
     */
    @ApiModelProperty(value = "图书总数量（借出的+现存的）")
    private Integer repertoryNum;

    /**
     * 现存量
     */
    @ApiModelProperty(value = "现存量")
    private Integer bookAmount;

    /**
     * 借出次数(默认为0)
     */
    @ApiModelProperty(value = "借出次数(默认为0)")
    private Integer lendNum;

    /**
     * 国际标准图书编号
     */
    @ApiModelProperty(value = "国际标准图书编号")
    private String isbn;
}
