package com.spring.batis.beanFactoryPostProcessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j(topic = "e")
public class H {
	Z z;

	public void setI(Z z) {
		this.z = z;
		log.debug("z--[{}]",z);
	}
}
