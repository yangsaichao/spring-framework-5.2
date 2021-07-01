package com.spring.batis.beanFactoryPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ConfigurationClassPostProcessor  最重要的类没有之一
 * BeanPostProcessor
 * bean的后置处理器 贯穿整个bean的生命周期
 *
 */

@Component
public class MyBeanPostProcessor implements BeanPostProcessor, PriorityOrdered,ApplicationContextAware {


	@Autowired
	ApplicationContext applicationContext;


	public MyBeanPostProcessor(){
		System.out.println("create MyBeanPostProcessor");
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@PostConstruct
	public void init(){
		System.out.println(applicationContext);
		System.out.println("init MyBeanPostProcessor");
	}

//	@Override
//	public int getOrder() {
//		return 0;
//	}


	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(applicationContext+"vvv");
		if(beanName.equals("l")){
			ClassLoader classLoader = MyBeanPostProcessor.class.getClassLoader();
			Class<?>[] interfaces = bean.getClass().getInterfaces();
			Object o = Proxy.newProxyInstance(classLoader, interfaces, new MyInvocationHandler(bean));
			return o;
		}
		return null;
	}


	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
		System.out.println("applicationContext[{}]"+applicationContext);
	}

	@Override
	public int getOrder() {
		return 0;
	}


	class MyInvocationHandler implements InvocationHandler{
		Object target;
		public MyInvocationHandler(Object target){
			this.target =target;
		}
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println("L n method before");

			Object result = method.invoke(target);

			System.out.println("L n method after");
			return result;
		}
	}
}
