package com.book.mbp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.common.utils.StringUtils;
import com.book.mbp.entity.BookInfo;
import com.book.mbp.entity.Recorder;
import com.book.mbp.entity.dto.BookInfoPageDto;
import com.book.mbp.mapper.BookInfoMapper;
import com.book.mbp.service.IBookInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.mbp.service.IRecorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zcz
 * @since 2022-09-16
 */
@Service
public class BookInfoServiceImpl extends ServiceImpl<BookInfoMapper, BookInfo> implements IBookInfoService {

    @Autowired
    private IRecorderService recorderService;

    /**
     * 分页查找
     *
     * @param req BookInfoPageDto
     * @return {@link Page}<{@link BookInfo}>
     */
    @Override
    public Page<BookInfo> pageParams(BookInfoPageDto req) {
        QueryWrapper<BookInfo> wrapper= getWrappers(req);

        return this.page(new Page<>(req.getCurr(), req.getSize()),wrapper);
    }

    @Override
    public BookInfo getByISBN(String isbn) {
        return baseMapper.selectOne(Wrappers.lambdaQuery(BookInfo.class).eq(BookInfo::getIsbn,isbn));
    }

    @Override
    @Transactional //执行出现错误事务回滚
    public boolean delete(String id) {
        BookInfo bookInfo=this.getById(id);
        this.removeById(bookInfo.getBookId());
        recorderService.update(
                Wrappers.lambdaUpdate(Recorder.class)
                        .set(Recorder::getDelBookName,bookInfo.getBookName())
                        .eq(Recorder::getBookId,bookInfo.getBookId())
        );
        return true;
    }

    /**
     * 模糊查找条件
     *
     * @param req BookInfoPageDto
     * @return {@link QueryWrapper}<{@link BookInfo}>
     */

    public QueryWrapper<BookInfo> getWrappers(BookInfoPageDto req){
        QueryWrapper<BookInfo> wrapper = Wrappers.query();
        wrapper.lambda()
                .eq(!StringUtils.isBlank(req.getBookId()), BookInfo::getBookId, req.getBookId())
                // 根据图书名称、图书作者、图书出版社、图书类别 查询
                .like(!StringUtils.isBlank(req.getBookName()), BookInfo::getBookName, req.getBookName())
                .like(!StringUtils.isBlank(req.getBookAuthor()), BookInfo::getBookAuthor, req.getBookAuthor())
                .like(!StringUtils.isBlank(req.getPublisher()), BookInfo::getPublisher, req.getPublisher())
                .eq(!StringUtils.isBlank(req.getBootType()), BookInfo::getPublisher, req.getPublisher())
                // 通过入库时间查询
                .ge(!Objects.isNull(req.getInputDateStart()), BookInfo::getInputDate, req.getInputDateStart())
                .le(!Objects.isNull(req.getInputDateEnd()), BookInfo::getInputDate, req.getInputDateEnd())
                // 通过价格区间查询
                .ge(!Objects.isNull(req.getBookPriceStart()), BookInfo::getBookPrice, req.getBookPriceStart())
                .le(!Objects.isNull(req.getBookPriceEnd()), BookInfo::getBookPrice, req.getBookPriceEnd())
        ;

        return wrapper;
    }
}
