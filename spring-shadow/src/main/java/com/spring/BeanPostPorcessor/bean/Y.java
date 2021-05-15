package com.spring.BeanPostPorcessor.bean;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

@Log4j2
public class Y {
	@Autowired
	X x;

	public void printf(){
		log.info("{}",x);
	}
}
