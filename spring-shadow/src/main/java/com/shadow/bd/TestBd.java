package com.shadow.bd;

import com.shadow.app.Appconfig;
import com.shadow.service.IndexService;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestBd {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext
				= new AnnotationConfigApplicationContext(Appconfig.class);


		applicationContext.getBean(Y.class);

	}
}
