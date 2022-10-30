package com.book.mbp.service;

import com.book.mbp.entity.Reader;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zcz
 * @since 2022-09-16
 */

public interface IReaderService extends IService<Reader> {


    Reader getReaderByStudentNum(String num);

    boolean borrow(String number, String isbn);

    boolean delReader(String id);

}
