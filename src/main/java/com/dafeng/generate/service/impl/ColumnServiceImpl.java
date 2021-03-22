package com.dafeng.generate.service.impl;

import com.github.pagehelper.PageHelper;
import com.dafeng.generate.bean.ColumnBean;
import com.dafeng.generate.bean.GenQueryBean;
import com.dafeng.generate.bean.TableBean;
import com.dafeng.generate.mapper.ColumnMapper;
import com.dafeng.generate.service.ColumnService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述
 *
 * @author da.feng
 * @date 2018/8/6 20:29
 **/
@Slf4j
@Service
public class ColumnServiceImpl implements ColumnService {

    @Autowired
    private ColumnMapper columnMapper;

    @Override
    public List<ColumnBean> getTableAllColumns(List<String> tableNames) {
        return columnMapper.getTableAllColumns(tableNames);
    }

    @Override
    public List<ColumnBean> getTablePkColumns(List<String> tableNames) {
        return columnMapper.getTablePkColumns(tableNames);
    }

    @Override
    public List<TableBean> getList(GenQueryBean bean) {
        PageHelper.startPage(bean.getPageNum(), bean.getPageSize());
        return columnMapper.getList(bean.getTableName());
    }

    @Override
    public List<TableBean> getTableInfoByTableName(List<String> tableNames) {
        return columnMapper.getTableInfoByTableName(tableNames);
    }


}
