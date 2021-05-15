package com.spring.extension.beanDefinition;

import com.spring.beanDefinition.bean.*;
import com.spring.beanDefinition.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.ChildBeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Description;

import java.util.Date;

@Slf4j(topic = "e")
@Description("fdsfsdfsdf")
public class BeanDefinitionTest {



	@Test
	public void test(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();




		context.register(Config.class);




//		GenericBeanDefinition y = new GenericBeanDefinition();
//		y.setBeanClass(Y.class);
//		y.setInitMethodName("y_init");
//		y.setEnforceInitMethod(true);


//		y.getPropertyValues().add("date",new Date());
//		y.getPropertyValues().add("msg","pretty pretty zl");
//
//
//		//y.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
//		y.setDependencyCheck(AbstractBeanDefinition.DEPENDENCY_CHECK_SIMPLE);


		// y.setInitMethodName("init_c");


//		y.getPropertyValues().add("msg","aaaa");
//		y.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_NAME);
//		y.setDependencyCheck(AbstractBeanDefinition.DEPENDENCY_CHECK_OBJECTS);
//		GenericBeanDefinition z = new GenericBeanDefinition();
//		z.setBeanClass(Z.class);



//		context.registerBeanDefinition("y",y);
//		context.registerBeanDefinition("z",z);
		context.refresh();
//		context.getBean(Y.class).getX();
//		log.debug("check-{}",y.getDependencyCheck());
//		log.debug("mode-{}",y.getAutowireMode());

		//context.getBean("xxx");
	}
}
