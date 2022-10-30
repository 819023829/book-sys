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
public class Recorder extends EntityBase {

    public Recorder(){

    }

    public Recorder(String bookId, String bookNum, String studentNum, LocalDateTime giveBackDate) {
        this.bookId = bookId;
        this.bookNum = bookNum;
        this.studentNum = studentNum;
        this.giveBackDate = giveBackDate;
        this.outDate = LocalDateTime.now();
        this.setStatus(0);
    }

    private static final long serialVersionUID = 1L;

    /**
     * 借阅图书记录 id
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
     * 借阅时间
     */
    private LocalDateTime outDate;

    /**
     * 归还时间
     */
    private LocalDateTime giveBackDate;

    /**
     * 借阅状态（0：正在借阅，1：已归还，2：损坏）
     */
    private Integer status;


    /**
     * 删除书名字
     */
    private String delBookName;
}
