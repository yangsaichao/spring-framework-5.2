package com.spring.extension;

import com.spring.service.MemberService;
import com.spring.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * @author 钢牌讲师-子路
 * @date 2021/3/162:28
 */
@Component
@Slf4j(topic = "e")
public class ExBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		AbstractBeanDefinition t = (AbstractBeanDefinition) beanFactory.getBeanDefinition("t");

//		t.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
//		t.setAutowireCandidate(false);
//		beanFactory.getMergedBeanDefinition("t").setAutowireCandidate(false);
//		try {
//			Field field =  TestService.class.getField("memberService");
//			DependencyDescriptor dependencyDescriptor = new DependencyDescriptor(field,true);
//			log.debug("AutowireCandidate:{}",beanFactory.isAutowireCandidate("t",dependencyDescriptor));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		beanFactory.freezeConfiguration();
		t.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);

		//t.setBeanClass(MemberService.class);


		//beanFactory.ignoreDependencyType(MemberService.class);


		log.debug("mode-{}",t.getAutowireMode());
	}
}
