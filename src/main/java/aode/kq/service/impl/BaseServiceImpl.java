package aode.kq.service.impl;

import aode.kq.service.BaseService;
import aode.kq.util.BaseMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 黄柏樟 on 2016/3/8.
 * @Explain: 通用接口实现
 */
@Transactional
public abstract class BaseServiceImpl<T> implements BaseService<T> {
    protected abstract BaseMapper<T> getBaseMapper();

    @Override
    public int delete(T t) {
        return getBaseMapper().delete(t) ;
    }

    @Override
    public int deleteByExample(Object o) {
        return getBaseMapper().deleteByExample(o) ;
    }

    @Override
    public int deleteByPrimaryKey(Object o) {
        return getBaseMapper().deleteByPrimaryKey(o) ;
    }

    @Override
    public int insert(T t) {
        return getBaseMapper().insert(t) ;
    }

    @Override
    public int insertList(List<T> list) {
        return getBaseMapper().insertList(list) ;
    }

    @Override
    public int insertSelective(T t) {
        return getBaseMapper().insertSelective(t) ;
    }

    @Override
    public int insertUseGeneratedKeys(T t) {
        return getBaseMapper().insertUseGeneratedKeys(t) ;
    }

    @Override
    public List<T> select(T t) {
        return getBaseMapper().select(t) ;
    }

    @Override
    public T selectOne(T t) {
        return getBaseMapper().selectOne(t) ;
    }

    @Override
    public List<T> selectAll() {
        return getBaseMapper().selectAll() ;
    }

    @Override
    public List<T> selectByExample(Object o) {
        return getBaseMapper().selectByExample(o) ;
    }

    @Override
    public List<T> selectByExampleAndRowBounds(Object o, RowBounds r) {
        return getBaseMapper().selectByExampleAndRowBounds(o , r) ;
    }

    @Override
    public T selectByPrimaryKey(Object o) {
        return getBaseMapper().selectByPrimaryKey(o) ;
    }

    @Override
    public List<T> selectByRowBounds(T t, RowBounds r) {
        return getBaseMapper().selectByRowBounds(t , r) ;
    }

    @Override
    public int selectCount(T t) {
        return getBaseMapper().selectCount(t) ;
    }

    @Override
    public int selectCountByExample(Object o) {
        return getBaseMapper().selectCountByExample(o) ;
    }

    @Override
    public int updateByExampleSelective(@Param("record") T t, @Param("example") Object o) {
        return getBaseMapper().updateByExampleSelective(t , o) ;
    }

    @Override
    public int updateByExample(@Param("record") T t, @Param("example") Object o) {
        return getBaseMapper().updateByExample(t , o) ;
    }

    @Override
    public int updateByPrimaryKey(T t) {
        return getBaseMapper().updateByPrimaryKey(t) ;
    }

    @Override
    public int updateByPrimaryKeySelective(T t) {
        return getBaseMapper().updateByPrimaryKeySelective(t) ;
    }

    @Override
    public List<T> pageList(Page<T> page){
        if (page.getPageNum() != 0 && page.getPageSize() != 0) {
            PageHelper.startPage(page.getPageNum(), page.getPageSize(), "id");
        }
        return getBaseMapper().selectAll() ;
    }
}
