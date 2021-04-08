package com.spring.extension.beanDefinitionRegistryPostProcessor;

import com.spring.beanDefinitionRegistryPostProcessor.*;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/4/621:39
 */
public class BeanDefinitionRegistryPostProcessorTest {

	@Test
	public void test() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext();
		context.register(com.spring.beanDefinitionRegistryPostProcessor.config.Config.class);
		//context.addBeanFactoryPostProcessor("父类");
		context.refresh();
	}
}
