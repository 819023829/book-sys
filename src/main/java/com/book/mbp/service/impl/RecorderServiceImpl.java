package com.book.mbp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.book.mbp.entity.Configuration;
import com.book.mbp.entity.Recorder;
import com.book.mbp.entity.dto.RecorderDto;
import com.book.mbp.mapper.ConfigurationMapper;
import com.book.mbp.mapper.RecorderMapper;
import com.book.mbp.service.IRecorderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zcz
 * @since 2022-09-16
 */
@Service
public class RecorderServiceImpl extends ServiceImpl<RecorderMapper, Recorder> implements IRecorderService {

    @Autowired
    private RecorderMapper recorderMapper;
    @Autowired
    private ConfigurationMapper configurationMapper;

    @Override
    public List<RecorderDto> listFull() {
        return recorderMapper.listFull();
    }

    @Override
    public Integer renew(String bookId, String stuNum) {
        LambdaQueryWrapper<Recorder> query = new LambdaQueryWrapper<>();
        query.eq(Recorder::getBookId,bookId);
        Recorder recorder = recorderMapper.selectOne(query);
        LocalDateTime giveBackDate = recorder.getGiveBackDate();//获取归还时间
        long l=giveBackDate.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        long l1=System.currentTimeMillis();
        if(l1>l){
            return 0;
        }
        Configuration configuration = configurationMapper.selectById(stuNum);
        Integer maxRenewalDays = configuration.getMaxRenewalDays();
        long l2= maxRenewalDays * 1000L * 60 * 60 * 24;//天数转化为毫秒数
//        Long l3= TimeUnit.MILLISECONDS.convert(maxRenewalDays,TimeUnit.DAYS);  //天数转化为毫秒数
        long l4=l2+l;//新的归还时间
        Recorder recorder1=new Recorder();
        recorder1.setId(recorder.getId());
        recorder1.setGiveBackDate(new Date(l4).toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime());//设置新的归还时间
        return recorderMapper.updateById(recorder1);
    }

    @Override
    public String returnBook(String bookId, String stuNum) {
        LambdaQueryWrapper<Recorder> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Recorder::getBookId,bookId);
        Recorder recorder = recorderMapper.selectOne(queryWrapper);
        if(recorder==null){
            return "该书不属于图书馆";
        }
        LocalDateTime giveBackTime=recorder.getGiveBackDate();
        long l1 = giveBackTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        long l= System.currentTimeMillis();
        if(l>l1){
            long l2 = TimeUnit.MILLISECONDS.toDays(l - l1); //超出天数
            return "已延期"+l2+"天";
        }
        Recorder recorder1 = new Recorder();
        recorder1.setId(recorder.getId());
        recorder1.setStatus(1);
        recorderMapper.updateById(recorder1);
        return "还书成功";
    }
}
