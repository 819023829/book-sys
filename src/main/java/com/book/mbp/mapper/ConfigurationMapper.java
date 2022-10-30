package com.book.mbp.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.mbp.entity.Configuration;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.book.mbp.entity.dto.ConfigurationListDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
public interface ConfigurationMapper extends BaseMapper<Configuration> {

    List<ConfigurationListDto> selectByStuNum(ConfigurationListDto dto);

    Page<ConfigurationListDto> selectByPage(Page<Object> page,@Param(Constants.WRAPPER)QueryWrapper<ConfigurationListDto> wrapper);

}
