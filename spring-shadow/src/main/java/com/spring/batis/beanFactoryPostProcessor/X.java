package com.spring.batis.beanFactoryPostProcessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
@Slf4j(topic = "e")
public class X {




	//如果你提供Y 不提供setter方法那么是无法注入的
	//因为spring的注入(自动注入)他有很多方式 byname bytype java自省机制
//	@Autowired
//	Y y;

	public void setY(Y y) {
		log.debug("set ---y：【{}】",y);
		//this.y = y;
	}

	//life init callback
	@PostConstruct
	public void init(){
		//log.debug("x create  y-[{}]",y);
	}
}
