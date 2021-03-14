package com.shadow.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class CustomSqlSession {

	/**
	 * 符合需求的对象
	 * 1、代理
	 * 2、功能 查询数据库 --执行对应sql
	 * @param clazz
	 * @return
	 */
	public static Object  getMapper(Class clazz){

		Object proxy = Proxy.newProxyInstance(CustomSqlSession.class.getClassLoader(), new Class[]{clazz}, new CustomInvocationHandler());
		return  proxy;
	}



	//读取sql  执行sql
	static class CustomInvocationHandler implements InvocationHandler {
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

			if (method.isAnnotationPresent(Select.class)) {
				Select select = method.getAnnotation(Select.class);
				String sql = select.value()[0];
				System.out.println(sql);

				System.out.println("jdbc connect  ---exe ");
			}

			return null;
		}
	}
}
