package com.spring.batis.beanFactoryPostProcessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;

@Component
@Slf4j(topic = "e")
public class K implements ApplicationContextAware{
	public K(){
		log.debug("constructor from k");
	}

	/**
	 * 1、普通类这个set方法的执行时机----属于注入时候
	 *    因为这个set方法是在自动注入的时候被调用了，
	 *    所以他的执行时机应该和属性注入一样 populateBean
	 *
	 *
	 * 2、实现了aware类型的bean ApplicationContextAware
	 * 		重写 setApplicationContext
	 * 		但是K类又是被我们改成了自动注入所以这个	setApplicationContext
	 * 	     他就有两重意思 1、自动注入方法  2、普通方法
	 * 	     但是通过对spring源码的观察在spring容器刚刚启动的时候调用了
	 * 	     beanFactory.ignoreDependencyInterface(ApplicationContextAware.class);
	 * 	     表示spring会忽略第一重意思 不会去自动注入
	 *
	 * 	     这个方法什么时候调用呢？由于他是普通方法调用时机应该由开发这个接口人决定
	 * 	     spring自己决定
	 * @param applicationContext
	 * @throws BeansException
	 */
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		log.debug("applicationContext[{}]",applicationContext);
	}
}
