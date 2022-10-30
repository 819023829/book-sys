package com.book.mbp.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("book_putaway")
public class BookPutaway extends EntityBase {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private String id;

    /**
     * 图书编号 = 图书馆号+楼层+书架号+排号+格号+序号
     */
    private String bookNum;

    /**
     * 图书主键
     */
    private String bookId;

    /**
     * 图书馆号
     */
    private Integer libraryNum;

    /**
     * 楼层
     */
    private Integer floorNum;

    /**
     * 书架号
     */
    private Integer bookrackNum;

    /**
     * 排号
     */
    private Integer rowNum;

    /**
     * 格号
     */
    private Integer gridNum;

    /**
     * 序号
     */
    private Integer orderNum;
}
