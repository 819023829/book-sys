package com.book.mbp.entity.model;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zcz
 * @created 2022/9/21 11:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class PageModel {
    /**
     * 当前页码
     */
    @ApiModelProperty(value = "当前页数")
    private Integer curr;
    /**
     * 返回的行数
     */
    @ApiModelProperty(value = "返回行数")
    private Integer size;

//    public Page<?> getPage(){
//        return new Page(curr,size);
//    }
}
