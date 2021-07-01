package com.spring.batis.beanFactoryPostProcessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.stereotype.Component;

@Component("b1")
@Slf4j(topic = "e")
public class B implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		//beanFactory.ignoreDependencyType(Y.class);
		//忽略掉依赖的接口
		//spring当中既然我们已经可以忽略一个类型 其实已经没必要再去忽略一个接口
		//因为接口属于类型 类型已经可以表示接口了
		//beanFactory.ignoreDependencyInterface(Z.class);



		AbstractBeanDefinition beanDefinition = (AbstractBeanDefinition) beanFactory.getBeanDefinition("k");
//		log.debug("x before AutowireMode={}",x.getAutowireMode());;
		beanDefinition.setAutowireMode(2);
//		log.debug("x after AutowireMode={}",x.getAutowireMode());;
		//AbstractBeanDefinition.AUTOWIRE_NO=0 不子到注入 手动注入
		//AbstractBeanDefinition.AUTOWIRE_BY_TYPE=2  自动注入 通过类型
		//AbstractBeanDefinition.AUTOWIRE_BY_TYPE=1  自动注入 通过名字
	}
}
