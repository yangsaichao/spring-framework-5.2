package com.spring.extension.beanFactoryPostProcessor.test;

import com.spring.extension.beanFactoryPostProcessor.TestFrozen;
import com.spring.extension.beanFactoryPostProcessor.TestIgnoreDependencyInterface;
import com.spring.extension.beanFactoryPostProcessor.TestIgnoreDependencyType;
import com.spring.extension.beanFactoryPostProcessor.bean.*;
import com.spring.extension.beanFactoryPostProcessor.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 钢牌讲师-子路
 * @date 2021/3/2218:44
 */
@Slf4j(topic = "e")
public class TestBeanFactoryPostProcessor {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext();
		//
		Class[] clazz = new Class[]{A.class,B.class,TestIgnoreDependencyType.class};
		applicationContext.register(clazz);
		applicationContext.refresh();
		applicationContext.getBean(A.class).printInfo();


	}

}
