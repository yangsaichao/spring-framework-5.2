package com.spring.extension.configurationClassPostProcessor;

import com.spring.AnnotatedBeanDefinitionReader.util.ShadowBeanNameGenerator;
import com.spring.beanDefinitionRegistryPostProcessor.D;
import com.spring.beanDefinitionRegistryPostProcessor.I;
import com.spring.beanDefinitionRegistryPostProcessor.X;
import com.spring.beanDefinitionRegistryPostProcessor.config.Config;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/4/1919:47
 */
public class ConfigurationClassPostProcessorTest {

	@Test
	public void test(){
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext();
		//context.setBeanNameGenerator(new ShadowBeanNameGenerator());
		context.register(Config.class);

		context.refresh();
		D bean = context.getBean(D.class);
		//context.getBean(X.class);


		//context.registerBeanDefinition();
		//context.getBeanFactory().registerSingleton();
		//context.getBean(I.class).aa();
	}
}
