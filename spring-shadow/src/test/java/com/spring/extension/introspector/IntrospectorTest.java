package com.spring.extension.introspector;

import com.spring.introspector.bean.A;
import com.spring.introspector.bean.UserInfo;
import com.spring.introspector.bean.Y;
import com.spring.introspector.bean.Z;
import com.spring.introspector.config.Config;
import lombok.SneakyThrows;
import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.CachedIntrospectionResults;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class IntrospectorTest {
	Map<String, PropertyDescriptor> propertyDescriptors = new HashMap<>();

	@SneakyThrows
	@Test
	public void test(){
		/**
		 * @Autowired
		 * Y y;
		 */
		Class clazz = A.class;

		Field y = clazz.getDeclaredField("y");
		y.setAccessible(true);
		//new() = getBean();
		y.set(new A(), new Y());


		/**
		 * @Autowired
		 * 	setZ(Z z)
		 *
		 * 	非常复杂
		 * 	当前bean是否是自动注入
		 * 	如果是自动注入则 和自动注入的流程一样的（在Autowired时候会跳过）
		 * 	如果不是自动注入
		 *
		 * 	错误：类似于上面的
		 */
		Method m = clazz.getDeclaredMethod("setZ", Z.class);
		m.setAccessible(true);
		m.invoke(new A(),new Z());


		/**
		 * 	自动注入--byType byname
		 *  setX(X x)
		 *  java 自省
		 */
		BeanInfo beanInfo = Introspector.getBeanInfo(A.class);

		PropertyDescriptor x = propertyDescriptors.get("x");
		Method writeMethod = x.getWriteMethod();
		writeMethod.invoke(null,null);

//		BeanWrapper bw = new BeanWrapperImpl(new UserInfo());
//		PropertyDescriptor age = bw.getPropertyDescriptor("age");

		AnnotationConfigApplicationContext
				context = new AnnotationConfigApplicationContext(Config.class);

		context.getBean(A.class).printf();

//		try {
//			BeanInfo beanInfo = Introspector.getBeanInfo(UserInfo.class);
//			for (PropertyDescriptor propertyDescriptor : beanInfo.getPropertyDescriptors()) {
//				propertyDescriptors.put(propertyDescriptor.getName(),propertyDescriptor);
//			}
//		} catch (IntrospectionException e) {
//			e.printStackTrace();
//		}
//
//		PropertyDescriptor age1 = propertyDescriptors.get("age");
		//age1.


	}


	@Test
	public void testIntrospector(){
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(UserInfo.class);


			PropertyDescriptor[] ps = beanInfo.getPropertyDescriptors();

			for (PropertyDescriptor propertyDescriptor : ps) {
				propertyDescriptors.put(propertyDescriptor.getName(),propertyDescriptor);
			}

			PropertyDescriptor abc = propertyDescriptors.get("abc");
			//System.out.println(abc.getName());
			Method readMethod = abc.getReadMethod();
			Method writeMethod = abc.getWriteMethod();

		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
	}




	@Test
	public void testSpringInject(){
		AnnotationConfigApplicationContext
				context = new AnnotationConfigApplicationContext(Config.class);
	}


	public void testIntrospectorPropertyDescription(){
		BeanWrapper bw = new BeanWrapperImpl(new UserInfo());
		PropertyDescriptor[] propertyDescriptors = bw.getPropertyDescriptors();
		PropertyDescriptor age = bw.getPropertyDescriptor("age");
	}
}
