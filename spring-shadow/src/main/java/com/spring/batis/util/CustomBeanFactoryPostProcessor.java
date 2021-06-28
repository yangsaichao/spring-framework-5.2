package com.spring.batis.util;

import com.spring.batis.util.bean.X;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * 1、实现一个接口
 * 2、重写他的方法
 * 3、他本身得是一个bean
 * 4、他只能获取bd 修改bd 但是无法添加bd
 */
@Slf4j(topic = "e")
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		log.debug("CustomBeanFactoryPostProcessor callback");
		AbstractBeanDefinition yy = (AbstractBeanDefinition) beanFactory.getBeanDefinition("yy");
		yy.setBeanClass(X.class);

	}
}
