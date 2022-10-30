package com.book.mbp.entity;

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
public class Damaged extends EntityBase {

    private static final long serialVersionUID = 1L;

    /**
     * 报损单编 id
     */
    private String id;

    /**
     * 学号或者教师编号（损坏的人）
     */
    private String studentNum;

    /**
     * 损坏的图书id
     */
    private String bookId;

    /**
     * 图书的编号
     */
    private String bookNum;

    /**
     * 损坏描述
     */
    private String describe;

    /**
     * 损坏时间
     */
    private LocalDateTime damagedDate;

    /**
     * 经手人
     */
    private String createBy;
}
