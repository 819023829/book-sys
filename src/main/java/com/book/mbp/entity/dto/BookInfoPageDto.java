package com.book.mbp.entity.dto;

import com.book.mbp.entity.model.PageModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author zcz
 * @created 2022/9/21 10:58
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel()
public class BookInfoPageDto extends PageModel {
    /**
     * 图书的主键
     */
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
    private Float bookPriceStart;
    @ApiModelProperty(value = "图书价格")
    private Float bookPriceEnd;


    /**
     * 图书摘要
     */
    @ApiModelProperty(value = "图书摘要")
    private String bookDigest;

    /**
     * 图书分类
     */
    @ApiModelProperty(value = "图书分类")
    private String bootType;

    /**
     * 图书入库时间
     */
    @ApiModelProperty(value = "图书入库时间")
    private LocalDateTime inputDateStart;
    @ApiModelProperty(value = "图书入库时间")
    private LocalDateTime inputDateEnd;


    /**
     * 图书总数量（借出的+现存的）
     */
    @ApiModelProperty(value = "图书总数量")
    private Integer repertoryNum;

    /**
     * 现存量（图书馆剩余数量= 图书总数量-借出的）
     */
    @ApiModelProperty(value = "现存量")
    private Integer bookNum;

    /**
     * 借出次数（默认为0）
     */
    @ApiModelProperty(value = "借出次数")
    private Integer lendNum;

}