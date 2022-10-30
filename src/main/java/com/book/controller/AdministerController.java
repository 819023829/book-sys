package com.book.controller;

import com.book.common.lang.AjaxResult;
import com.book.common.lang.UserTokenInfo;
import com.book.mbp.entity.Administer;

import com.book.mbp.entity.dto.AdministerSaveDto;
import com.book.mbp.service.IAdministerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


/**
 * 管理控制器
 *
 * @author zcz
 * @created 2022/9/19 9:49
 * @date 2022/09/22
 */
@RestController
@RequestMapping("/administer")
@Api(tags = "用户管理")
public class AdministerController {
    @Autowired
    private IAdministerService administerService;

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return {@link AjaxResult}
     */
    @GetMapping("/login")
    public AjaxResult login(@RequestParam(value = "user") String username,@RequestParam("pass") String password){
        Administer administer =administerService.login(username,password);
        return AjaxResult.success(administer);
    }

    @GetMapping("/loginToken")
    @ApiOperation(value = "用户登录")
    @ApiImplicitParams({@ApiImplicitParam(name = "user",value = "姓名",required = true),
            @ApiImplicitParam(name = "pass",value = "密码",required = true)})
    public AjaxResult loginToken(@RequestParam(value = "user") String username,@RequestParam("pass") String password){
        String token =administerService.loginByToken(username,password);
        return AjaxResult.success(token);
    }

    @PostMapping("/save")
    public AjaxResult save(@RequestBody AdministerSaveDto administer) {
        boolean save = administerService.save(administer);
        return save ? AjaxResult.success() : AjaxResult.error();
    }

    @GetMapping("/info")
    public AjaxResult userInfo(String token){
        Administer administer = UserTokenInfo.TokenPool.get(token);
        if (administer == null){
            return AjaxResult.error("Token不存在");
        }
        return AjaxResult.success(administer);
    }

    @GetMapping("auth")
    //需要登录才可以访问的接口，在这个接口中获取当前登录信息
    public AjaxResult auth(HttpServletRequest request){
        String token=request.getHeader("token");
        Administer administer= UserTokenInfo.TokenPool.get(token);
        System.err.println("当前登录"+administer.getLoginName());
        return AjaxResult.success(administer);
    }

    @GetMapping("noAuth")
    public AjaxResult noAuth(){
        return AjaxResult.success("不需要token的接口");
    }
}
