package com.spring.batis.util;

import java.lang.reflect.Proxy;

public class SqlSessionImpl {

	/**
	 * 1、返回一个对象
	 * 2、必须实现了clazz接口类型的对象
	 * @param clazz
	 * @return
	 *
	 * 通过jdk动态代理来返回一个符合要求的对象
	 */
	public static  Object getMapper(Class clazz){
		/**
		 * 通过一个接口返回一个对象
		 * jdk 动态
		 */

		/**
		 * ClassLoader loader  类加载器 负责load动态生成出来的代理类二进制文件
		 * Class<?>[] interfaces 接口数组
		 * InvocationHandler h 需要传一个对象必须实现了InvocationHandler接口
		 */
		ClassLoader loader = SqlSessionImpl.class.getClassLoader();
		Class[] classes = new Class[]{clazz};
		//动态的生成一个对象
		//1、产生了一个类
		//2、根据这个类 产生一个对象然后返回
		Object o = Proxy.newProxyInstance(loader,classes,new InvocationHandlerBatis());
		return o;
	}
}
