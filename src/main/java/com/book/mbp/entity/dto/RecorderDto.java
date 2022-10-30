package com.book.mbp.entity.dto;

import com.book.mbp.entity.Recorder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zcz
 * @created 2022/9/23 14:19
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RecorderDto extends Recorder {
    private String bookName;

    private String name;
}
