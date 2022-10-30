package com.book.mbp.mapper;

import com.book.mbp.entity.Administer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zcz
 * @since 2022-09-16
 */
@Mapper
public interface AdministerMapper extends BaseMapper<Administer> {

    @Select("select * FROM administer WHERE login_name = #{loginName} limit 1")
    Administer selectByLoginName(String loginName);

}
