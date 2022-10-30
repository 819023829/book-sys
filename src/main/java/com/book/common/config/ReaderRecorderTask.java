package com.book.common.config;

import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.book.mbp.entity.Reader;
import com.book.mbp.entity.Recorder;
import com.book.mbp.service.IRecorderService;
import org.springframework.stereotype.Component;

import java.util.TimerTask;

/**
 * @author zcz
 * @created 2022/9/24 10:24
 */
public class ReaderRecorderTask extends TimerTask {
    private final String recorderId;
    private final IRecorderService recorderService;

    public ReaderRecorderTask(String recorderId, IRecorderService recorderService) {
        this.recorderId = recorderId;
        this.recorderService = recorderService;
    }

    @Override
    public void run() {
        System.err.println("将"+recorderId+"重新设置状态");
        Recorder recorder=recorderService.getById(recorderId);
        if(recorder.getStatus()==0) {
            recorder.setStatus(3);
            recorderService.updateById(recorder);
        }
    }
}
