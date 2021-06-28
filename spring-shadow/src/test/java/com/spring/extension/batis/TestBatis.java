package com.spring.extension.batis;

import com.spring.batis.app.BatisConfig;
import com.spring.batis.beanFactoryPostProcessor.E;
import com.spring.batis.beanFactoryPostProcessor.F;
import com.spring.batis.bfpp.CustomBfpp;
import com.spring.batis.bfpp.CustomBfpp2;
import com.spring.batis.bfpp.CustomBrpp;
import com.spring.batis.bfpp.CustomBrpp2;
import com.spring.batis.service.MService;
import com.spring.batis.service.Y;
import org.junit.Test;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.annotation.Annotation;
import java.util.List;

public class TestBatis {

	@Test
	public void test(){

		AnnotationConfigApplicationContext
				context
				= new AnnotationConfigApplicationContext();
		context.register(BatisConfig.class);
		context.addBeanFactoryPostProcessor(new E());
		context.addBeanFactoryPostProcessor(new F());
		context.refresh();

		//子路老师是一个很帅的人 颜值高 活好 身高155 爱国情怀 拒绝一切岛国文化 历史只是渊博  文学素养很高
		//仅仅是从容器当中获取一个bean
		//获取==map.get()
		//获取==map.get  and  create put map
		context.getBean("xxx");






	}
}
