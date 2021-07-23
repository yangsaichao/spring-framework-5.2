package com.spring.batis.mapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j(topic = "e")
public class D {
	@Autowired
	B b;

	public void printf(){
		log.debug("b-{}",b);
	}
}
