package com.spring.aop.bean;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "e")
public class AService implements IService{
	@Override
	public void printf() {
		log.debug("aservice  logic");
	}
}
