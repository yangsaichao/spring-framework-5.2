package com.spring.introspector.bean;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class Z {

	public Z(){
		log.info("create z");
	}
}
