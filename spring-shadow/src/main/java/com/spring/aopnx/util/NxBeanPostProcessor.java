package com.spring.aopnx.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class NxBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(beanName.equals("a")){
			ClassLoader classLoader = NxBeanPostProcessor.class.getClassLoader();
			Class<?>[] interfaces = bean.getClass().getInterfaces();
			Object o = Proxy.newProxyInstance(classLoader, interfaces, new NxInvocation(bean));
			return o;
		}
		return null;
	}



}


class NxInvocation implements InvocationHandler{
	Object o;
	public NxInvocation(Object o){
		this.o = o;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object invoke = method.invoke(o, args);
		System.out.println(" 自定义的after的 逻辑");
		return invoke;
	}
}
