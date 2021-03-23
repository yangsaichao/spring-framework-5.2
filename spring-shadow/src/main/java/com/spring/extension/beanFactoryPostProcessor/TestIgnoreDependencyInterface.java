package com.spring.extension.beanFactoryPostProcessor;

import com.spring.extension.beanFactoryPostProcessor.bean.C;
import com.spring.extension.beanFactoryPostProcessor.bean.X;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author 钢牌讲师-子路
 * @date 2021/3/2220:00
 */

public class TestIgnoreDependencyInterface implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		//获取A的BeanDefinition
		ScannedGenericBeanDefinition a =
				(ScannedGenericBeanDefinition) beanFactory.getBeanDefinition("w");
		//设置A的注入模型为AUTOWIRE_BY_NAME
		a.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);

		//设置忽略X接口--什么意思呢？
		beanFactory.ignoreDependencyInterface(X.class);
	}
}
