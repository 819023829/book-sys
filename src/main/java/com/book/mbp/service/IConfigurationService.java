package com.book.mbp.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.mbp.entity.Configuration;
import com.baomidou.mybatisplus.extension.service.IService;
import com.book.mbp.entity.dto.ConfigurationListDto;
import com.book.mbp.entity.dto.ConfigurationSaveDto;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zcz
 * @since 2022-09-16
 */
public interface IConfigurationService extends IService<Configuration> {

    Integer saveDay(ConfigurationSaveDto dto);

    List<ConfigurationListDto> listDay(ConfigurationListDto dto);

    Page<ConfigurationListDto> selectByPage(ConfigurationListDto dto);

}
