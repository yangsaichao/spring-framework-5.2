package com.spring.AnnotatedBeanDefinitionReader.util;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/3/269:26
 */
public class ShadowBeanNameGenerator implements BeanNameGenerator {
	@Override
	public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {

		String s=new Random().nextInt(20)+ "bn";

		return s;
	}
}
