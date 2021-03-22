package com.dafeng.generate.service.impl;


import com.github.pagehelper.PageHelper;
import com.dafeng.generate.bean.ParamsBean;
import com.dafeng.generate.bean.ParamsQueryBean;
import com.dafeng.generate.mapper.ParamsMapper;
import com.dafeng.generate.model.ParamsModel;
import com.dafeng.generate.service.ParamsService;
import com.dafeng.generate.utils.CopyDataUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * ParamsServiceImpl
 *
 * @author da.feng
 */
@Service
public class ParamsServiceImpl implements ParamsService {


    @Autowired
    private ParamsMapper paramsMapper;


    @Override
    public List<ParamsModel> getList(ParamsQueryBean bean) {
        PageHelper.startPage(bean.getPageNum(), bean.getPageSize());
        Example example = new Example(ParamsModel.class);
        Example.Criteria createCriteria = example.createCriteria();
        if (StringUtils.isNotEmpty(bean.getName())) {
            createCriteria.andLike("name", "%" + bean.getName().trim() + "%");
        }

        return paramsMapper.selectByExample(example);
    }

    @Override
    public List<ParamsBean> getList() {
        return CopyDataUtil.copyList(paramsMapper.selectAll(), ParamsBean.class);
    }


    @Override
    public ParamsModel getById(Long id) {
        return paramsMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,
            rollbackFor = {RuntimeException.class, Exception.class})
    public boolean insert(ParamsBean bean) {
        ParamsModel model = CopyDataUtil.copyObject(bean, ParamsModel.class);
        model.setId(null);
        return paramsMapper.insertSelective(model) > 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,
            rollbackFor = {RuntimeException.class, Exception.class})
    public boolean update(ParamsBean bean) {
        ParamsModel model = CopyDataUtil.copyObject(bean, ParamsModel.class);
        return paramsMapper.updateByPrimaryKeySelective(model) > 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,
            rollbackFor = {RuntimeException.class, Exception.class})
    public boolean delete(Long id) {
        return paramsMapper.deleteByPrimaryKey(id) > 0;
    }

}