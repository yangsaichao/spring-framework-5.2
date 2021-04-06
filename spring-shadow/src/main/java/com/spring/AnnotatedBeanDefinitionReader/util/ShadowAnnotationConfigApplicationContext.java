package com.spring.AnnotatedBeanDefinitionReader.util;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/3/2610:48
 */
public class ShadowAnnotationConfigApplicationContext  extends AnnotationConfigApplicationContext {

	private ShadowClassPathBeanDefinitionScanner scanner = new ShadowClassPathBeanDefinitionScanner(this);

	@Override
	public void scan(String... basePackages) {
		scanner.scan(basePackages);
	}
}
