package com.book.mbp.service;

import com.book.mbp.entity.Administer;
import com.baomidou.mybatisplus.extension.service.IService;
import com.book.mbp.entity.dto.AdministerSaveDto;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zcz
 * @since 2022-09-16
 */
public interface IAdministerService extends IService<Administer> {
    Administer selectByLoginName(String loginName);
    Administer login(String username, String password);
    boolean save(AdministerSaveDto administerDto);

    String loginByToken(String username, String password);

}
