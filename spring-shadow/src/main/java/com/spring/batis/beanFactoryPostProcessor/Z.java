package com.spring.batis.beanFactoryPostProcessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j(topic = "e")
public class Z {

	@PostConstruct
	public void init(){
		log.debug("-------");
	}
}
