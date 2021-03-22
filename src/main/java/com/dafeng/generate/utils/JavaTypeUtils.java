package com.dafeng.generate.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 数据库字段类型和java类型转换工具
 *
 * @author da.feng
 */
@Slf4j
public class JavaTypeUtils {

	private JavaTypeUtils(){}

	private static Properties config;

	static {
		InputStream in = JavaTypeUtils.class.getClassLoader()
				.getResourceAsStream("jdbcType_2_javaType.properties");
		config = new Properties();
		try {
			config.load(in);
			in.close();
		} catch (IOException e) {
			log.error("No AreaPhone.properties defined error");
		}
	}


	/**
	 * 根据key读取value
     */
	public static String readValue(String key) {
		if (StringUtils.isEmpty(key)) {
			return "";
		}
		try {
			String val = config.getProperty(key.toUpperCase());
			return StringUtils.isNotEmpty(val) ? val.trim() : "";
		} catch (Exception e) {
			log.error("ConfigInfoError ",e);
			return null;
		}
	}


}
