package com.book.mbp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.book.mbp.entity.EntityBase;
import java.io.Serializable;
import java.time.LocalDateTime;
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
public class Reserve extends EntityBase {

    private static final long serialVersionUID = 1L;

    /**
     * 预定图书记录 id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 图书id
     */
    private String bookId;

    /**
     * 图书编号
     */
    private String bookNum;

    /**
     * 学号或者教师编号
     */
    private String studentNum;

    /**
     * 预定开始时间
     */
    private LocalDateTime reserveDate;

    /**
     * 预定归还时间
     */
    private LocalDateTime giveBackDate;
}
