package com.spring.AnnotatedBeanDefinitionReader.bean;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Lazy;

import org.springframework.stereotype.Component;

import javax.annotation.ManagedBean;
import javax.inject.Named;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/3/265:53
 */
@Named
public class A1  implements BeanNameAware {

	public A1(){
		System.out.println("a1 create");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("A1-name="+name);
	}
}
