package com.spring.extension.supplier;

import com.spring.supplier.A;
import com.spring.supplier.B;
import com.spring.supplier.C;
import org.junit.Test;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

/**
 * 1、事实  spring源码底层优先判断supplier是否存在  如果存在则执行get方法返回bean 继而return end
 * 2、why supplier的效率高于 工厂方法
 * 不管是工厂方法还是静态工厂方法，底层都是通过反射实现的
 *
 */
public class SupplierTest {

	@Test
	public void test(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(C.class);

		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClass(A.class);


		B b = new B();
		beanDefinition.setFactoryBeanName("c");
		beanDefinition.setFactoryMethodName("create");

		beanDefinition.setInstanceSupplier(b::create);

		context.registerBeanDefinition("a",beanDefinition);



		context.refresh();
	}
}
