package com.spring.AnnotatedBeanDefinitionReader.bean;


import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

import javax.annotation.ManagedBean;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/3/266:34
 */
@ManagedBean
public class C1 implements BeanNameAware {

	public static Object create(){
		return new B1();
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("c1-name="+name);
	}
}
