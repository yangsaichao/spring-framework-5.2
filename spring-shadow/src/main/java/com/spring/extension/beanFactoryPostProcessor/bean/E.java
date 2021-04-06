package com.spring.extension.beanFactoryPostProcessor.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/3/2220:44
 */

@Component
public class E implements C {

	public E(){
		System.out.println("e被创建了");
	}

//	@Override
//	public void afterPropertiesSet() throws Exception {
//		System.out.println("e bean 以及被创建好了");
//	}
//
//	@Override
//	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//		System.out.println("Aware");
//	}
}
