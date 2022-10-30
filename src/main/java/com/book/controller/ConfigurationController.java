package com.book.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.common.lang.AjaxResult;
import com.book.mbp.entity.Configuration;
import com.book.mbp.entity.dto.ConfigurationListDto;
import com.book.mbp.entity.dto.ConfigurationSaveDto;
import com.book.mbp.entity.dto.ConfigurationUpdateDto;
import com.book.mbp.service.IConfigurationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zcz
 * @created 2022/9/29 10:29
 */
@RestController
@RequestMapping("/configuration")
@Api(tags = "系统管理")
public class ConfigurationController {
    @Autowired
    private IConfigurationService configurationService;

    @PostMapping("/save")
    @ApiOperation("添加用户借阅天数设置")
    public AjaxResult save(@RequestBody ConfigurationSaveDto dto) {
        Integer res = configurationService.saveDay(dto);
        if (res > 0) {
            return AjaxResult.success("添加成功", res);
        } else {
            return AjaxResult.error("操作失败");
        }
    }

    @GetMapping("/list")
    @ApiOperation("用户可借阅天数列表")
    public AjaxResult list(ConfigurationListDto dto){
        List<ConfigurationListDto> list=configurationService.listDay(dto);
        if(list.size()>0){
        return AjaxResult.success(list);}
        else {
            return AjaxResult.error("不存在该用户");
        }
    }

    @PostMapping("/update")
    @ApiOperation("更新用户借阅天数")
    public AjaxResult update(ConfigurationUpdateDto dto){
        Configuration configuration=new Configuration();
        BeanUtils.copyProperties(dto,configuration);
        boolean b = configurationService.updateById(configuration);
        return AjaxResult.custom(b);
    }

    @GetMapping("/delete")
    @ApiOperation("删除用户借阅天数")
    public AjaxResult delete(@RequestParam String stuNum){
        return AjaxResult.custom(configurationService.removeById(stuNum));
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页查询借阅天数列表")
    public AjaxResult page(ConfigurationListDto dto){
        return  AjaxResult.success(configurationService.selectByPage(dto));
    }
}
