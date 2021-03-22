package com.dafeng.generate.utils;


import com.dafeng.generate.bean.Page;

import java.util.List;

/**
 * 分页工具类
 *
 * @author da.feng
 * @date 2018/6/25 14:16
 **/
public class PageUtil {

    private PageUtil() {

    }

    public static <T, V> Page<V> getPageList(List<T> list, Class<V> clazz) {
        if (list == null) {
            return null;
        } else {
            if (list instanceof com.github.pagehelper.Page) {
                com.github.pagehelper.Page page = (com.github.pagehelper.Page) list;
                Page<V> result = new Page<>();
                result.setData(CopyDataUtil.copyList(list, clazz));
                result.setPageNum(page.getPageNum());
                result.setPageSize(page.getPageSize());
                result.setTotal(page.getTotal());
                return result;
            }
            return null;
        }
    }

}
