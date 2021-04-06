package com.spring.extension.beanFactoryPostProcessor;

import com.spring.extension.beanFactoryPostProcessor.bean.C;
import com.spring.extension.beanFactoryPostProcessor.bean.X;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author 钢牌讲师-子路
 * @date 2021/3/2220:00
 */
@Slf4j(topic = "e")
public class TestIgnoreDependencyInterface implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		log.debug("TestIgnoreDependencyInterface--execute");
		//获取A的BeanDefinition
		AnnotatedGenericBeanDefinition w =
				(AnnotatedGenericBeanDefinition) beanFactory.getBeanDefinition("w");

		AnnotatedGenericBeanDefinition q =
				(AnnotatedGenericBeanDefinition) beanFactory.getBeanDefinition("q");
		//设置A的注入模型为AUTOWIRE_BY_NAME
		w.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);

		//设置忽略X接口--什么意思呢？
		beanFactory.ignoreDependencyInterface(X.class);
	}
}
