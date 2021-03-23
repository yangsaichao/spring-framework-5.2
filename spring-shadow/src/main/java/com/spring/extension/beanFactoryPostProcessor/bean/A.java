package com.spring.extension.beanFactoryPostProcessor.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 钢牌讲师-子路
 * @date 2021/3/2218:41
 */
@Slf4j(topic = "e")
@Component
public class A {

	@Autowired
	B b;

	public void printInfo(){

	}
}
