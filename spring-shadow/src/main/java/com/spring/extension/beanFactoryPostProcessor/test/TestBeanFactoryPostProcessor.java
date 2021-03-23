package com.spring.extension.beanFactoryPostProcessor.test;

import com.spring.extension.beanFactoryPostProcessor.TestFrozen;
import com.spring.extension.beanFactoryPostProcessor.bean.*;
import com.spring.extension.beanFactoryPostProcessor.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author 钢牌讲师-子路
 * @date 2021/3/2218:44
 */
@Slf4j(topic = "e")
public class TestBeanFactoryPostProcessor {

	public static void main(String[] args) {
		//spring容器默认情况下允许替换bd---通过名字
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext();
		Class[] clazz = new Class[]{E.class, TestFrozen.class};
		applicationContext.register(clazz);

		applicationContext.refresh();
		System.out.println(applicationContext.getBean(E.class));


	}
}
