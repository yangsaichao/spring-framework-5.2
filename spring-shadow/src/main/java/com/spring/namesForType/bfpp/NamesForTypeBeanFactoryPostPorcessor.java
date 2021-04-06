package com.spring.namesForType.bfpp;

import com.spring.namesForType.bean.X;
import com.spring.namesForType.bean.Y;
import com.spring.namesForType.bean.Z;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/3/3021:00
 */
@Slf4j(topic = "e")
public class NamesForTypeBeanFactoryPostPorcessor implements BeanDefinitionRegistryPostProcessor {
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		DefaultListableBeanFactory factory  = (DefaultListableBeanFactory) registry;
		//得到你那个构造方法带参数的类的 beanDefinition
		//AnnotatedBeanDefinition x = (AnnotatedBeanDefinition) registry.getBeanDefinition("x");

		String[] beanNamesForType = factory.getBeanNamesForType(X.class);
		for (String s : beanNamesForType) {
			log.debug("name:{}",s);
		}
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		//得到你那个构造方法带参数的类的 beanDefinition
		AnnotatedBeanDefinition x = (AnnotatedBeanDefinition) beanFactory.getBeanDefinition("x");
		x.getConstructorArgumentValues().addGenericArgumentValue("参数的类型 带包名");
	}
}
