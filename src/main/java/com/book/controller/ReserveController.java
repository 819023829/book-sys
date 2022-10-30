package com.book.controller;

import com.book.common.lang.AjaxResult;
import com.book.mbp.entity.BookInfo;
import com.book.mbp.entity.Reserve;
import com.book.mbp.entity.dto.ReserveAddDto;
import com.book.mbp.entity.dto.ReserveListDto;
import com.book.mbp.service.IBookInfoService;
import com.book.mbp.service.IReserveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zcz
 * @created 2022/9/28 9:40
 */
@RestController
@RequestMapping("/reserve")
@Api(tags = "预定图书管理")
public class ReserveController {

    @Autowired
    private IReserveService reserveService;

    @Autowired
    private IBookInfoService bookInfoService;
    @PostMapping("/add")
    @ApiOperation("预定图书")
    public AjaxResult addReserve(@RequestBody ReserveAddDto dto){
        BookInfo bookInfo=bookInfoService.getById(dto.getBookId());
        if(bookInfo.getBookAmount()>0){
            return AjaxResult.success("该图书有库存，无需预定");
        }
        boolean b= reserveService.addReserve(dto);
        if(b){
        return AjaxResult.success("预定成功",b);}
        else {
            return AjaxResult.error("预定失败");
        }
    }

    @GetMapping("/list")
    @ApiOperation("图书预定列表")
    public AjaxResult<List<Reserve>> listReserve(@RequestParam String stuNum){
        List<ReserveListDto> list= reserveService.listReserve(stuNum);
        return AjaxResult.success("请求成功",list);
    }

    @GetMapping("/delete")
    @ApiOperation("解除预定")
    public AjaxResult deleteReserve(@RequestParam String id){
        boolean b = reserveService.removeById(id);
        if(b){
            return AjaxResult.success("删除成功", true);
        }else {
            return AjaxResult.error("解除失败");
        }

    }
}
