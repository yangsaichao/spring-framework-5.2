package com.spring.earlyBean.bean;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
@Component
@Log4j2
public class Z implements I {


	@Override
	public void printf() {
		log.info("zzzz");
	}
}
