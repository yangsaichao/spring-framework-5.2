package com.spring.earlyBean.beanPostProcessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Slf4j(topic = "e")
public class AopBeanPostProcessor implements BeanPostProcessor {
	//代理
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		//根据切面当中提供的切点来判断
		if(beanName.equals("a")){
			ClassLoader classLoader = AopBeanPostProcessor.class.getClassLoader();
			Object proxy = Proxy.newProxyInstance(classLoader, bean.getClass().getInterfaces(), new AopInvocationHandler(bean));
			return proxy;
		}
		return bean;
	}

	class AopInvocationHandler implements InvocationHandler{
		Object target;
		public AopInvocationHandler(Object target){
			this.target=target;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			//根据通知的类型判断 before  after
			log.debug("aop  before");
			Object invoke = method.invoke(target, args);
			log.debug("aop  afterr");
			return invoke;
		}
	}
}
