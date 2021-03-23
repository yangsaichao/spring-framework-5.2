package com.spring.extension.beanFactoryPostProcessor.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author 钢牌讲师-子路
 * @date 2021/3/2218:41
 */

@Component
public class E implements C, InitializingBean, ApplicationContextAware {

	public E(){
		System.out.println("e被创建了");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("e bean 以及被创建好了");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("Aware");
	}
}
