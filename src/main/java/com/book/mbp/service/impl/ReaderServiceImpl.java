package com.book.mbp.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.book.common.config.ReaderRecorderTask;
import com.book.common.lang.TaskManger;
import com.book.mbp.entity.BookInfo;
import com.book.mbp.entity.Reader;
import com.book.mbp.entity.Recorder;
import com.book.mbp.mapper.ReaderMapper;
import com.book.mbp.service.IBookInfoService;
import com.book.mbp.service.IReaderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.mbp.service.IRecorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Timer;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zcz
 * @since 2022-09-16
 */
@Service
public class ReaderServiceImpl extends ServiceImpl<ReaderMapper, Reader> implements IReaderService {

    @Autowired
    private IBookInfoService bookInfoService;
    @Autowired
    private IRecorderService recorderService;

    @Override
    public Reader getReaderByStudentNum(String num) {
        return baseMapper.selectOne(Wrappers.lambdaQuery(Reader.class).eq(Reader::getStudentNum,num));
    }

    @Override
    public boolean borrow(String number, String isbn) {
        Reader reader=this.getReaderByStudentNum(number);
        if(reader==null) throw new RuntimeException("编号不存在");
        BookInfo bookInfo=bookInfoService.getByISBN(isbn);
        if(bookInfo==null) throw new RuntimeException("该书不存在");
        Recorder recorder=new Recorder(bookInfo.getBookId(),bookInfo.getIsbn(),reader.getStudentNum(),LocalDateTime.now().plusDays(7));
        boolean res=recorderService.save(recorder);
        LocalDateTime backDate = recorder.getGiveBackDate();
        long delay=backDate.toInstant(ZoneOffset.of("+8")).toEpochMilli()-System.currentTimeMillis();;
        TaskManger.timer.schedule(new ReaderRecorderTask(recorder.getId(),recorderService),delay);
        return res;
    }

    @Override
    @Transactional
    public boolean delReader(String id) {
        Reader reader=this.getById(id);
        this.removeById(reader.getId());
        recorderService.remove(Wrappers.lambdaQuery(Recorder.class)
                .eq(Recorder::getStudentNum,reader.getStudentNum()));
        return true;
    }


}
