package com.spring.aopnx.beans.impl;

import com.spring.aopnx.beans.CService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j(topic = "e")
public class CServiceImpl implements CService {
	@Override
	public void defaultMethod() {
		log.debug("CServiceImpl的具体逻辑");
	}
}
