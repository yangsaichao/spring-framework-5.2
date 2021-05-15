package com.spring.beanDefinition.bean;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "e")
public class C {

	A a;


	public void setA(A a) {
		this.a = a;
	}

	public A getA() {
		log.debug("a-{}",a);
		return a;
	}

	public void init_c(){
		log.debug("init ---c");
	}
}
