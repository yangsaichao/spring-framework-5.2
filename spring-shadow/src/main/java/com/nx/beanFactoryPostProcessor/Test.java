package com.nx.beanFactoryPostProcessor;

import com.nx.beanFactoryPostProcessor.scan.NameCreator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext
				context
				= new AnnotationConfigApplicationContext();
		context.register(App.class);
		context.refresh();



//		ClassPathBeanDefinitionScanner scanner
//				= new ClassPathBeanDefinitionScanner(context);
//
//		int scan = scanner.scan("com.nx.beanFactoryPostProcessor.scan");
//		System.out.println(scan);
	}
}
