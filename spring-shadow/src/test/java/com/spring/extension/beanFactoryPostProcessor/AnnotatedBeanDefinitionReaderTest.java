package com.spring.extension.beanFactoryPostProcessor;

import com.shadow.asm.ClassParser;
import com.shadow.asm.ShadowMetaData;
import com.spring.AnnotatedBeanDefinitionReader.bean.A1;
import com.spring.AnnotatedBeanDefinitionReader.bean.B1;
import com.spring.AnnotatedBeanDefinitionReader.bean.C1;;
import com.spring.AnnotatedBeanDefinitionReader.bean.E1;
import com.spring.AnnotatedBeanDefinitionReader.config.Config;
import com.spring.AnnotatedBeanDefinitionReader.sub.D1;
import com.spring.AnnotatedBeanDefinitionReader.util.ShadowAnnotationConfigApplicationContext;
import com.spring.AnnotatedBeanDefinitionReader.util.ShadowBeanNameGenerator;
import com.spring.extension.beanFactoryPostProcessor.bean.A;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;
import org.springframework.asm.ClassReader;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/3/264:54
 */
public class AnnotatedBeanDefinitionReaderTest {

	@Test
	public void test(){

		//整个spring容器已经初始化完了
		/**
		 * 1、调用的是默认的构造方法
		 * 	1、1 实例化这个对象AnnotatedBeanDefinitionReader
		 */
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.setBeanNameGenerator(new ShadowBeanNameGenerator());
		context.register(A1.class);

		context.refresh();


	}


	@Test
	public void testBeanNameGenerator1(){

		//整个spring容器已经初始化完了
		/**
		 * 1、调用的是默认的构造方法
		 * 	1、1 实例化这个对象AnnotatedBeanDefinitionReader
		 */
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.customScannerAndReaderByBeanNameGenerator(null,new ShadowBeanNameGenerator());
		//调用reader渲染bd 然后调用spring默认的策略生产名字
		context.register(A1.class);

		context.scan("com.spring.AnnotatedBeanDefinitionReader.bean");
		context.refresh();

		System.out.println();
	}




	@Test
	public void testBeanNameGenerator2(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.setBeanNameGenerator(new ShadowBeanNameGenerator());
		//调用reader渲染bd 然后调用spring默认的策略生产名字
		//a1

		context.register(A1.class,Config.class);
		//scan  用的是扫描器1
		context.scan("com.spring.AnnotatedBeanDefinitionReader.bean");
		context.refresh();

	}



	@Test
	public void testScanFilter(){


		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		//扫描器1你无法获得  继承这个扫描器1
		context.scan("com.spring.AnnotatedBeanDefinitionReader.bean");



		//扫描器2---解析ComponentScan 完成扫描
		context.register(Config.class);


		System.out.println("--------------------------");
		for (String beanDefinitionName : context.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}
	}






	@Test
	public void testCustomScanFilter(){


		ShadowAnnotationConfigApplicationContext context
				= new ShadowAnnotationConfigApplicationContext();


		//完成扫描 只支持ShadowAnno
		context.scan("com.spring.AnnotatedBeanDefinitionReader.bean");
		//如果是同过一个扫描器 则 b1和C1 是扫描不到的
		//context.register(Config.class);


		context.refresh();

		System.out.println("--------------------------");
		for (String beanDefinitionName : context.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}



	}














	@Test
	public void testSuplier(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.refresh();
		System.out.println("context finish");
		System.out.println(context.getBean(A1.class));


	}
	private static final int PARSING_OPTIONS = ClassReader.SKIP_DEBUG
			| ClassReader.SKIP_CODE | ClassReader.SKIP_FRAMES;

	@Test
	public void testMetadata(){

		ClassParser classParser = new ClassParser(null);
		try {
			ClassReader cr= new ClassReader("com.shadow.service.IndexService");
			cr.accept(classParser,PARSING_OPTIONS);
			ShadowMetaData data = classParser.getData();
			System.out.println(data);
		} catch (IOException e) {
			e.printStackTrace();
		}

		SimpleMetadataReaderFactory simple = new SimpleMetadataReaderFactory();
		try {
			MetadataReader metadataReader = simple.getMetadataReader("com.spring.AnnotatedBeanDefinitionReader.bean.A1");
			for (MergedAnnotation<Annotation> annotation : metadataReader.getAnnotationMetadata().getAnnotations()) {

			}
			System.out.println(metadataReader);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
