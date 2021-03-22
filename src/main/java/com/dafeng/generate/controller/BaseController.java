package com.dafeng.generate.controller;


import com.dafeng.generate.bean.Page;
import com.dafeng.generate.utils.PageUtil;

import java.util.List;

/**
 * @author da.feng
 **/

public class BaseController {

    <T> Page<T> createPageInfo(List<T> list) {
        return new Page<>(list);
    }

    <T, V> Page<V> convertPageInfo(List<T> list, Class<V> clazz) {
        return copyPageList(list, clazz);
    }

    private <T, V> Page<V> copyPageList(List<T> list, Class<V> clazz) {
        if (list == null) {
            return null;
        } else {
            return PageUtil.getPageList(list, clazz);
        }
    }

}
