package com.spring.extension.beanFactoryPostProcessor;

import com.spring.extension.beanFactoryPostProcessor.bean.C;
import com.spring.extension.beanFactoryPostProcessor.bean.D;
import com.spring.extension.beanFactoryPostProcessor.bean.E;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/3/2221:50
 */
public class TestRegisterResolvableDependency implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		//表示只要遇到需要注入C类型的依赖，就new一个D给他
		beanFactory.registerResolvableDependency(C.class,new E());
	}
}
