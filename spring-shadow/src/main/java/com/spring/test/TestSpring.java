package com.spring.test;


import com.spring.service.TestService;
import lombok.extern.slf4j.Slf4j;
import com.spring.config.Config;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 钢牌讲师-子路
 * @date 2021/3/162:22
 */
@Slf4j(topic = "e")
public class TestSpring {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
		applicationContext.getBean(TestService.class).logInfo();
		applicationContext.getBeanDefinitionNames()
//		AbstractBeanDefinition t = (AbstractBeanDefinition) applicationContext.getBeanDefinition("t");
//		applicationContext.registerBeanDefinition("t",t);
		//System.out.println(t.isAutowireCandidate());
	}
}
