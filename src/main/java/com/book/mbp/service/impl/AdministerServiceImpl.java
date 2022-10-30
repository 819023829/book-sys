package com.book.mbp.service.impl;

import com.book.common.lang.UserTokenInfo;
import com.book.common.utils.StringUtils;
import com.book.mbp.entity.Administer;
import com.book.mbp.entity.dto.AdministerSaveDto;
import com.book.mbp.mapper.AdministerMapper;
import com.book.mbp.service.IAdministerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zcz
 * @since 2022-09-16
 */
@Service
public class AdministerServiceImpl extends ServiceImpl<AdministerMapper, Administer> implements IAdministerService {
    @Autowired
    AdministerMapper administerMapper;

    @Override
    public Administer selectByLoginName(String loginName) {
        return administerMapper.selectByLoginName(loginName);
    }

    @Override
    public Administer login(String username, String password) {
        Administer administer=administerMapper.selectByLoginName(username);
        if(administer==null){
            throw new RuntimeException("用户名不存在");
        }
        if(!administer.getPassword().equals(StringUtils.md5(password))){
            throw new RuntimeException("密码不正确");
        }
        return administer;
    }

    @Override
    public boolean save(AdministerSaveDto administerDto) {
        Administer administer=new Administer();
        BeanUtils.copyProperties(administerDto, administer);
        administer.setPassword(StringUtils.md5(administer.getPassword()));
        return this.save(administer);
    }

    @Override
    public String loginByToken(String username, String password) {
        Administer administer= this.login(username,password);
        //生成token
        String key= UUID.randomUUID().toString();
        UserTokenInfo.TokenPool.put(key,administer);
        return key;
    }


}
