package com.book.controller;

import com.book.common.lang.AjaxResult;
import com.book.mbp.entity.Reader;
import com.book.mbp.service.IReaderService;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户控制器
 *
 * @author zcz
 * @created 2022/9/19 9:49
 * @date 2022/09/22
 */
@RestController
@RequestMapping("/reader")
@Validated
@Api(tags = "读者管理")
public class ReaderController {
    @Autowired
    private IReaderService readerService;

    /**
     * 借阅者列表
     *
     * @return {@link AjaxResult}
     */
    @GetMapping("/list")
    @ApiOperation("读者列表")
    public AjaxResult<List<Reader>> list() {
        List<Reader> readers = readerService.list();
        String message;
        message = readers.size() == 0 ? "没有记录" : "查询成功";
        return AjaxResult.success(message,readers);
    }

    /**
     * 删除读者
     *
     * @param id 读者id
     * @return {@link AjaxResult}
     */
    @DeleteMapping("/delReader")
    @ApiOperation("删除读者")
    public AjaxResult delReader(@NotBlank(message = "删除id不能为空") @RequestParam String id){
        boolean b= readerService.delReader(id);
        return AjaxResult.custom(b);
    }

    /**
     * 注册借阅卡
     *
     * @param reader 读者信息
     * @return {@link AjaxResult}
     */
    @PostMapping("/add")
    @ApiOperation("注册借阅卡")
    public AjaxResult add(Reader reader){
        boolean b = readerService.save(reader);
        return AjaxResult.custom(b);
    }

    /**
     * 根据学生或者教师编号，获取当前读者信息
     *
     * @param num id
     * @return {@link AjaxResult}
     */
    @GetMapping("/num/{id}")
    @ApiOperation("根据学号查找")
    public AjaxResult<Reader> getByNum(@NotEmpty(message = "编号不能为空") @PathVariable("id") String num){
        Reader reader= readerService.getReaderByStudentNum(num);
        if(reader!=null) return AjaxResult.success(reader);
        return AjaxResult.error("该读者编号不存在");
    }

    @PostMapping("/borrow")
    @ApiOperation("借阅接口")
    public AjaxResult borrow(String number,String isbn){
        boolean b=readerService.borrow(number,isbn);
        return AjaxResult.custom(b);
    }
}
