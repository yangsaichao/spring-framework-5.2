package com.spring.batis.beans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanNameAware;
@Slf4j(topic = "e")

public class Y implements BeanNameAware {
	@Override
	public void setBeanName(String name) {
		log.debug(name);
	}
}
