package com.spring.extension.batis;

import com.spring.batis.app.BatisConfig;


import com.spring.batis.mapper.D;
import com.spring.batis.util.NXNameGenerator;
import org.junit.Test;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TestBatis {

	@Test
	public void test(){

		AnnotationConfigApplicationContext
				context
				= new AnnotationConfigApplicationContext();
		context.register(BatisConfig.class);
		context.refresh();



//		String n = context.getBean(M.class).n();
//		System.out.println(n);

		//子路老师是一个很帅的人 颜值高 活好 身高155 爱国情怀 拒绝一切岛国文化 历史只是渊博  文学素养很高
		//仅仅是从容器当中获取一个bean
		//获取==map.get()
		//获取==map.get  and  create put map
	}


	@Test
	public void testScanDefault(){

		AnnotationConfigApplicationContext
				context
				= new AnnotationConfigApplicationContext();
		context.scan();
		context.setBeanNameGenerator(new  NXNameGenerator());
		context.register(BatisConfig.class);
		context.refresh();













//		context.scan("com.spring.batis.beans");
//

		//System.out.println(context.getBean(Y.class));

	}









	@Test
	public void testScan() throws ClassNotFoundException {
		Map<String,GenericBeanDefinition> genericBeanDefinitions= new HashMap<>();
		String property = System.getProperty("user.dir");
		System.out.println(property);
//		String path = TestBatis.class.getClass().getResource("/").getPath();
		String packageName = "com.spring.batis.beans";
		//把这个字符串变成一个目录
		File file  = new File("E:\\work\\code\\spring-framework\\spring-shadow\\out\\production\\classes\\com\\spring\\batis\\beans");
		File[] files = file.listFiles();//得到所有的文件
		for (File scanFile : files) {//遍历所有的文件
			String name = scanFile.getName();//得到文件名
			name = name.replaceAll(".class", "");//处理文件名


			//spring为什么用ASM去解析字节码，而不直接通过forName去加载一个类
			//的类的类对象，继而获取类的信息
			//并不是单纯秀技能
			//得到处理好的文件名之后spring并没有去加载类（没有通过文件名获取一个对象）？
			Class<?> aClass = Class.forName(packageName + "." + name);//根据处理好的文件名，把该文件对应的类load到JVM生成Class对象
			//因为我们需要类的信息----因为需要构建BeanDefinition
			if(aClass.isAnnotationPresent(Component.class)){
				GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
				genericBeanDefinition.setBeanClass(aClass);
				if(aClass.isAnnotationPresent(Scope.class)){
					Scope scope= aClass.getAnnotation(Scope.class);
					String valueScope = scope.value();
					if (StringUtils.isEmpty(valueScope)) {
						valueScope=AbstractBeanDefinition.SCOPE_SINGLETON;
					}
					genericBeanDefinition.setScope(valueScope);
				}else{
					genericBeanDefinition.setScope(AbstractBeanDefinition.SCOPE_SINGLETON);

				}

				Component component= aClass.getAnnotation(Component.class);
				String beanName = component.value();
				if(StringUtils.isEmpty(beanName)){
					beanName  = name;
				}

				genericBeanDefinitions.put(beanName,genericBeanDefinition);
			}



		}
		System.out.println(genericBeanDefinitions);

	}





	@Test
	public void testMybatisScan(){

		AnnotationConfigApplicationContext
				context
				= new AnnotationConfigApplicationContext(BatisConfig.class);


		context.getBean(D.class).printf();
	}
}
