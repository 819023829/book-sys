package com.book.mbp.entity;

import com.book.mbp.entity.EntityBase;
import java.io.Serializable;
import java.math.BigDecimal;
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
public class Fine extends EntityBase {

    private static final long serialVersionUID = 1L;

    /**
     * 罚款交费单 id
     */
    private String id;

    /**
     * 报损单编 id（外键）
     */
    private String damagedId;

    /**
     * 学号或者教师编号（罚款的人）
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
     * 金额
     */
    private BigDecimal money;

    /**
     * 交费时间
     */
    private LocalDateTime createDate;
}
