package com.book.mbp.mapper;

import com.book.mbp.entity.BookInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zcz
 * @since 2022-09-16
 */
@Mapper
public interface BookInfoMapper extends BaseMapper<BookInfo> {

}
