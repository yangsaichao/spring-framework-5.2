package com.spring.aopnx.beans.impl;

import com.spring.aopnx.beans.BService;
import com.spring.aopnx.util.Nx;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j(topic = "e")
@Component
public class BServiceImpl implements BService {

	@Nx
	@Override
	public void printf() {
		log.debug("logic----b");
	}
}
