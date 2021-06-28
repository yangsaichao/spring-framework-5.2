package com.spring.extension.earlyBean;

import com.spring.aop.bean.AService;
import com.spring.aop.bean.BeforeInterceptor;
import com.spring.aop.bean.IService;
import com.spring.earlyBean.bean.*;
import com.spring.earlyBean.config.Config;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Proxy;

public class TestAop {

	@Test
	public void test(){
		ProxyFactory pf = new ProxyFactory();
		pf.setInterfaces(new Class[]{IService.class});
		pf.addAdvice(new BeforeInterceptor());
		pf.setTarget(new AService());
		IService iService = (IService) pf.getProxy();
		iService.printf();

	}

	/**
	 * 1、代理对象的产生是什么时候（单例的情况下）
	 * 		1、spring容器初始化的时候
	 * 	    2、getBean的时候
	 * 	实在容器初始化的时候产生的代理对象
	 */

	@Test
	public void testAopAd(){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
		I i = (I) ac.getBean("a");
		i.printf();
	}
}
