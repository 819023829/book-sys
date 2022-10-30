package com.book.controller;

import com.book.common.lang.AjaxResult;
import com.book.mbp.entity.dto.RecorderDto;
import com.book.mbp.service.IRecorderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zcz
 * @created 2022/9/23 14:12
 */
@RestController
@RequestMapping("/recorder")
@Api(tags = "借阅图书管理")
public class RecorderController {
    @Autowired
    private IRecorderService recorderService;

    @GetMapping("/list")
    @ApiOperation("借阅图书列表")
    public AjaxResult<List<RecorderDto>> list(){
        List<RecorderDto> list= recorderService.listFull();
        return AjaxResult.success(list);
    }

@GetMapping("/renew")
    @ApiOperation("续借")
    public AjaxResult renew(@RequestParam String bookId ,@RequestParam String stuNum){
    Integer res = recorderService.renew(bookId, stuNum);
    if(res==0){
        return AjaxResult.error("续借失败，已延期");
    }
    return AjaxResult.success("续借成功");

}

@GetMapping("/return/book")
    @ApiOperation("还书")
    public AjaxResult returnBook(@RequestParam String bookId,@RequestParam String stuNum){
        String s=recorderService.returnBook(bookId,stuNum);
        return AjaxResult.success(s);
}
}
