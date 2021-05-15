package com.spring.extension.beanPostProcessor;

import com.spring.BeanPostPorcessor.MyBeanPostPorcessor;
import com.spring.BeanPostPorcessor.MyInstantiationAwareBeanPostProcessor;
import com.spring.BeanPostPorcessor.MyService;
import com.spring.BeanPostPorcessor.bean.X;
import com.spring.BeanPostPorcessor.bean.Y;
import com.spring.BeanPostPorcessor.config.Config;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestBeanPostProcessor {

	@Test
	public void test(){
		AnnotationConfigApplicationContext
				context
				= new AnnotationConfigApplicationContext(Config.class);

		//context.getBean(MyService.class).xx();
		context.getBean(MyBeanPostPorcessor.class).printf();

	}


	@Test
	public void testInstantiationAwareBeanPostProcessor(){
		AnnotationConfigApplicationContext
				context
				= new AnnotationConfigApplicationContext();




		context.register(X.class, Y.class, MyInstantiationAwareBeanPostProcessor.class);
		context.refresh();

		context.getBean(Y.class).printf();

	}
}
