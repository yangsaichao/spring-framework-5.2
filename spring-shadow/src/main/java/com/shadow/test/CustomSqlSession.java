package com.shadow.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


@Slf4j(topic = "e")
public class CustomSqlSession {

	/**
	 * 模拟mybatis产生代理对象
	 * 符合需求的对象
	 * 1、代理
	 * 2、这个对象能够具备的功能 查询数据库 --执行对应sql
	 * @param clazz
	 * @return
	 */
	public  Object  getMapper(Class clazz){

		//他的底层源码会去重写toString 没有实现
		Object proxy = Proxy.newProxyInstance(CustomSqlSession.class.getClassLoader(), new Class[]{clazz}, new CustomInvocationHandler());
		return  proxy;
	}








	class CustomInvocationHandler implements InvocationHandler {
		//所有代理对象的功能  查询数据 执行对应方法的sql语句
		//1、得到sql语句
		//2、conn ---执行sql语句
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			//判断有没有加这个注解
			if (method.isAnnotationPresent(Select.class)) {
				//得到这个注解对象
				Select select = method.getAnnotation(Select.class);
				//调用value方法得到注解里面的value的值--sql
				String sql = select.value()[0];
				log.error("sql:{}",sql);
//				log.debug("jdbc conn ");
//				log.debug("execute query");
			}

			if (method.getName().equals("toString")){
				return  proxy.getClass().getName();
			}


			return null;
		}
	}
}
