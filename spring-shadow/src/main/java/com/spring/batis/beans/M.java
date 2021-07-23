package com.spring.batis.beans;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.BeanNameAware;

import javax.inject.Named;

@Slf4j(topic = "e")
@Named
public class M implements BeanNameAware {

	Y y;


	public void setY(Y y) {
		this.y = y;
	}

	@Override
	public void setBeanName(String name) {
		log.debug(name);

	}
}
