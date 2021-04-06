package com.spring.extension.beanFactoryPostProcessor;

import com.live.bean.Z3;
import com.live.config.LiveAppconfig;
import com.live.util.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.asm.ClassReader;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/3/2720:05
 */

@Slf4j(topic = "e")
public class LiveTest {

	/**
	 * 这里之所以能够被扫描出来
	 * 扫描器2 ComponentScanAnnotationParser#parse
	 * ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner
	 *
	 * spring容器在初始化的 过程当中
	 * 会去解析配置类然后实例化一个扫描器去完成的扫描
	 *
	 * 实例化
	 *
	 * 初始化
	 */
	@Test
	public void testScan(){
		//初始化完了
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(LiveAppconfig.class);

		context.getBeanFactory().registerSingleton("xx",null);

		//BeanDefinitionRegistryPostProcessor bean = context.getBean(BeanDefinitionRegistryPostProcessor.class);/

//		context.register();
//
//
//		context.refresh();

		for (String beanDefinitionName : context.getBeanDefinitionNames()) {
				log.debug("bdName:{}",beanDefinitionName);
		}

	}


	/**
	 * context.scan 和解析配置文件不是同一个扫描器
	 * 扫描器1AnnotationConfigApplicationContext#AnnotationConfigApplicationContext()
	 * ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner
	 *
	 *
	 */
	@Test
	public void testScan1(){
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext();

		//程序员手动调用
		context.scan("com.live");
		context.refresh();

		for (String beanDefinitionName : context.getBeanDefinitionNames()) {
			log.debug("bdName:{}",beanDefinitionName);
		}

	}


	/**
	 * 扫描器0
	 */
	@Test
	public void testScan3(){
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext();

		//class--bd---put bdmap
		context.register(Z3.class);
		context.scan();
		context.refresh();

		for (String beanDefinitionName : context.getBeanDefinitionNames()) {
			log.debug("bdName:{}",beanDefinitionName);
		}

	}

	private static final int PARSING_OPTIONS = ClassReader.SKIP_DEBUG
			| ClassReader.SKIP_CODE | ClassReader.SKIP_FRAMES;

	@Test
	public void testAsm(){
		ClassParse4Asm parser = new ClassParse4Asm();
		ClassReader classReader = null;
		try {
			classReader = new ClassReader("com.live.bean.X1");
		} catch (IOException e) {
			e.printStackTrace();
		}
		classReader.accept(parser,PARSING_OPTIONS);

		MetadataShadow metadataShadow = parser.getMetadataShadow();
		System.out.println(metadataShadow);

	}


}
