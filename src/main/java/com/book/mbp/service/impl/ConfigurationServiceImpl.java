package com.book.mbp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.common.utils.StringUtils;
import com.book.mbp.entity.Configuration;
import com.book.mbp.entity.dto.ConfigurationListDto;
import com.book.mbp.entity.dto.ConfigurationSaveDto;
import com.book.mbp.mapper.ConfigurationMapper;
import com.book.mbp.service.IConfigurationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zcz
 * @since 2022-09-16
 */
@Service
public class ConfigurationServiceImpl extends ServiceImpl<ConfigurationMapper, Configuration> implements IConfigurationService {

    @Autowired
    private ConfigurationMapper configurationMapper;

    @Override
    public Integer saveDay(ConfigurationSaveDto dto) {
        Configuration configuration=new Configuration();
        BeanUtils.copyProperties(dto,configuration);//拷贝数据
        return configurationMapper.insert(configuration);
    }

    @Override
    public List<ConfigurationListDto> listDay(ConfigurationListDto dto) {
        dto.setPageNum((dto.getPageNum()-1)*dto.getPageSize());
        return configurationMapper.selectByStuNum(dto);
    }


        @Override
        public Page<ConfigurationListDto> selectByPage(ConfigurationListDto dto) {
            QueryWrapper<ConfigurationListDto> queryWrapper = new QueryWrapper<>();
            queryWrapper.like(StringUtils.isNotEmpty(dto.getName()),"b.name",dto.getName())
                    .like(StringUtils.isNotEmpty(dto.getCollege()),"b.college",dto.getCollege())
                    .like(dto.getPhone() != null,"b.phone",dto.getPhone())
                    .eq(StringUtils.isNotEmpty(dto.getStudentNum()),"a.student_ num",dto.getStudentNum())
            ;


            return configurationMapper.selectByPage(new Page<>(dto.getPageNum(),dto.getPageSize()),queryWrapper);
        }

}
