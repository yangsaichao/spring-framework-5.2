package com.spring.extension.aop;

import com.spring.aopnx.beans.AService;
import com.spring.aopnx.beans.BService;
import com.spring.aopnx.beans.CService;
import com.spring.aopnx.beans.impl.DServiceImpl;
import com.spring.aopnx.config.AopConfig;
import com.spring.aopnx.listener.SpringListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	@org.junit.Test
	public void test(){

		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AopConfig.class);;

	}
}
