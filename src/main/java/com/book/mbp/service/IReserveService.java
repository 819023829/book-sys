package com.book.mbp.service;

import com.book.mbp.entity.Reserve;
import com.baomidou.mybatisplus.extension.service.IService;
import com.book.mbp.entity.dto.ReserveAddDto;
import com.book.mbp.entity.dto.ReserveListDto;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zcz
 * @since 2022-09-16
 */
public interface IReserveService extends IService<Reserve> {

    boolean addReserve(ReserveAddDto dto);

    List<ReserveListDto> listReserve(String stuNum);
}
