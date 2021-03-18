package com.shadow.test;

import com.shadow.bd.X;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * 当spring执行到这里的时候在添加bd已经来不及了
 */

public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		GenericBeanDefinition y = (GenericBeanDefinition) beanFactory.getBeanDefinition("y");
		y.setBeanClass(X.class);
	}
}
