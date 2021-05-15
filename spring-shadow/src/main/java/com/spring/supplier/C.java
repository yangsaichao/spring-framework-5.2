package com.spring.supplier;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Slf4j(topic = "e")
public class C {

	public C(){
		log.debug("defalut c");
	}

	public A create(){
		return new A(1);
	}
}
