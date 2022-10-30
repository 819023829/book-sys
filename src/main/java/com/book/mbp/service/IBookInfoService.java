package com.book.mbp.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.mbp.entity.BookInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.book.mbp.entity.dto.BookInfoPageDto;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zcz
 * @since 2022-09-16
 */
public interface IBookInfoService extends IService<BookInfo> {


    Page<BookInfo> pageParams(BookInfoPageDto req);

    BookInfo getByISBN(String isbn);

    boolean delete(String id);

}
