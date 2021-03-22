package com.dafeng.generate.service;

import com.dafeng.generate.bean.ColumnBean;
import com.dafeng.generate.bean.GenQueryBean;
import com.dafeng.generate.bean.TableBean;

import java.util.List;

/**
 * @author da.feng
 */
public interface ColumnService {


	/**
     * 获取表的所有字段
	 *
	 * @param tableNames 表名
	 * @return List
	 */
	List<ColumnBean> getTableAllColumns(List<String> tableNames);

	/**
     * 获取表的主键
	 *
	 * @param tableNames 表名
	 * @return List
	 */
	List<ColumnBean> getTablePkColumns(List<String> tableNames);

	/**
     * 获取数据库中的表的信息
	 *
	 * @param bean 表名
	 * @return List
	 */
	List<TableBean> getList(GenQueryBean bean);


	/**
	 * 获取数据库中的表的备注
	 *
	 * @param tableNames 表名
	 * @return List
	 */
	List<TableBean> getTableInfoByTableName(List<String> tableNames);


}