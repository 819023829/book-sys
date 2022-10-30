package com.book.mbp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.book.mbp.entity.Reserve;
import com.book.mbp.entity.dto.ReserveAddDto;
import com.book.mbp.entity.dto.ReserveListDto;
import com.book.mbp.mapper.ReserveMapper;
import com.book.mbp.service.IReserveService;
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
public class ReserveServiceImpl extends ServiceImpl<ReserveMapper, Reserve> implements IReserveService {

    @Autowired
    private ReserveMapper reserveMapper;


    @Override
    public boolean addReserve(ReserveAddDto dto) {
        Reserve reserve=new Reserve();
        BeanUtils.copyProperties(dto,reserve);
        reserveMapper.insert(reserve);
        return true;
    }

    @Override
    public List<ReserveListDto> listReserve(String stuNum) {
//        LambdaQueryWrapper<Reserve> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(Reserve::getStudentNum,stuNum);
        return reserveMapper.selectByStuNum(stuNum);

    }
}
