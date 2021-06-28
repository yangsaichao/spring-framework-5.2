package com.spring.batis.util;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;

@Slf4j(topic = "e")
public class InvocationHandlerBatis implements InvocationHandler {
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		log.info("假装连接了数据库");
		log.info("获取sql");
		if(method.isAnnotationPresent(Select.class)){

			Select select = method.getAnnotation(Select.class);
			String sql = select.value()[0];
			log.info("exe 假装执行了sql---"+sql);
		}

		log.debug("返回list");
		return null;
	}
}
