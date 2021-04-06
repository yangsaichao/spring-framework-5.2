package com.spring.extension.beanFactoryPostProcessor;

import com.spring.extension.beanFactoryPostProcessor.bean.B;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author 钢牌讲师-子路
 * @date 2021/3/2218:39
 * 主要来测试ignoreDependencyType 这个API
 */
@Slf4j(topic = "e")
public class TestIgnoreDependencyType implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		log.debug("TestIgnoreDependencyType--execute  测试这个方法是否被执行了");

		//获取A的BeanDefinition
		AnnotatedGenericBeanDefinition a =
				(AnnotatedGenericBeanDefinition) beanFactory.getBeanDefinition("a");

		//修改A这个bean的注入模型为自动注入bytype
		a.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);


		//设置所有自动注入的属性如果类型为B则忽略
		beanFactory.ignoreDependencyType(B.class);
	}
}
