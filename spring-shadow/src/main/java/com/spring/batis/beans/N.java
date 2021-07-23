package com.spring.batis.beans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Slf4j(topic = "e")
@Component
public class N implements BeanNameAware {
	@Override
	public void setBeanName(String name) {
		log.debug(name);
	}
}
