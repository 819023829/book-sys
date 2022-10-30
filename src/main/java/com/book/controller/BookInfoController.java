package com.book.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.common.lang.AjaxResult;
import com.book.mbp.entity.BookInfo;
import com.book.mbp.entity.dto.BookInfoPageDto;
import com.book.mbp.service.IBookInfoService;
import com.book.mbp.service.IRecorderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 书信息控制器
 *
 * @author zcz
 * @created 2022/9/20 11:00
 */
@RestController
@RequestMapping("/book-info")
@Api(tags = "图书管理")
public class BookInfoController {

    @Autowired
    IBookInfoService bookInfoService;

    @Autowired
    IRecorderService recorderService;

    /**
     * 分页查询加模糊查找
     *
     * @param req 分页及模糊查找字段
     */
    @PostMapping("/page")
    @ApiOperation("分页模糊查找")
    public AjaxResult page(@RequestBody BookInfoPageDto req) {
        // mybatis-plus写法，mybatis需要自己写sql使用 limit子句
        Page<BookInfo> res = bookInfoService.pageParams(req);
        return AjaxResult.success(res);
    }

    //获取图书列表（不分页）
    @GetMapping("/list")
    @ApiOperation("图书列表")

    public AjaxResult list() {
        List<BookInfo> res=bookInfoService.list();
        return AjaxResult.success(res);
    }

    /**
     * 根据图书id查询图书
     *
     * @param id 图书id
     */
    @GetMapping("/info/{id}")
    // /book-info/info/123333
    public AjaxResult infoById(@PathVariable("id") String id) {
        return AjaxResult.success(bookInfoService.getById(id));
    }

    @GetMapping("/info")
    // /book-info/info?id=123333
    public AjaxResult infoByIdParams(@RequestParam("id") String id) {

        return AjaxResult.success(bookInfoService.getById(id));
    }

    @PostMapping("/update")
    public AjaxResult update(@RequestBody BookInfo bookInfo) {

        boolean b = bookInfoService.updateById(bookInfo);
        return AjaxResult.custom(b);
    }

    /**
     * @param id 图书id
     */
    @ApiOperation(value = "根据id删除图书")
    @PostMapping("/delete/{id}")
    public AjaxResult<String> delete(@PathVariable("id") String id) {
        boolean b=bookInfoService.delete(id);
        return AjaxResult.custom(b);

    }

    /**
     * @param bookInfo 图书信息
     */
    @PostMapping("/add")
    @ApiOperation("添加图书")
    public AjaxResult<String> add(@RequestBody BookInfo bookInfo) {
        bookInfoService.save(bookInfo);
        return AjaxResult.success("添加成功");
    }
}
