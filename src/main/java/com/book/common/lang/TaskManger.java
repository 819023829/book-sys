package com.book.common.lang;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.book.common.config.ReaderRecorderTask;
import com.book.mbp.entity.Recorder;
import com.book.mbp.service.IRecorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Timer;

/**
 * @author zcz
 * @created 2022/9/24 10:33
 */
@Component
public class TaskManger {
    public static Timer timer=new Timer();

    @Autowired
    private IRecorderService recorderService;

    @Bean
    public void RecorderTask(){
        // 获取状态为0的所有借阅记录
        List<Recorder> list = recorderService.list(
                Wrappers.lambdaQuery(Recorder.class).eq(Recorder::getStatus, 0)
        );
        list.forEach(i -> {
            LocalDateTime backDate = i.getGiveBackDate();
            // 获取归还时间 毫秒
            long delay = backDate.toInstant(ZoneOffset.of("+8")).toEpochMilli() - System.currentTimeMillis();
            if ( delay < 0){
                delay = 0;
            }
            // 存放到延时队列中执行
            TaskManger.timer.schedule(new ReaderRecorderTask(i.getId(), recorderService), delay);
        });
    }
}
