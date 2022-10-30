package com.book.mbp.mapper;

import com.book.mbp.entity.Recorder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.book.mbp.entity.dto.RecorderDto;
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
public interface RecorderMapper extends BaseMapper<Recorder> {

//    @Select("select recorder.*,book_info.book_name,reader.name from recorder left join book_info on recorder.book_id=book_info.book_id left join reader on recorder.student_num=reader.student_num")
    List<RecorderDto> listFull();
}
