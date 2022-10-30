package com.book.mbp.mapper;

import com.book.mbp.entity.Reserve;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.book.mbp.entity.dto.ReserveListDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
public interface ReserveMapper extends BaseMapper<Reserve> {

//    @Select("SELECT a.*,b.book_author,b.book_name FROM reserve a LEFT JOIN book_info b on a.book_id=b.book_id and a.student_num=#{stuNum}")
    List<ReserveListDto> selectByStuNum(String stuNum);

}
