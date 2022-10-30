package com.book.mbp.service;

import com.book.mbp.entity.Recorder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.book.mbp.entity.dto.RecorderDto;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zcz
 * @since 2022-09-16
 */
public interface IRecorderService extends IService<Recorder> {

    List<RecorderDto> listFull();

    Integer renew(String bookId, String stuNum);

    String returnBook(String bookId, String stuNum);

}
