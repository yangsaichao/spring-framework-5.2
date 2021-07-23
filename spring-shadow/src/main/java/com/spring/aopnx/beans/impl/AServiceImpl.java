package com.spring.aopnx.beans.impl;

import com.spring.aopnx.beans.AService;
import com.spring.aopnx.util.NxClazz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j(topic = "e")
@Component("a")
@NxClazz
public class AServiceImpl implements AService {

	public AServiceImpl(){
		log.debug("aserviceImpl create -----");
	}

	@Override
	public void printf() {
		log.debug("logic----a");
	}

	@Override
	public void argsExample(Integer i) {
		log.debug("i-[{}]",i);
	}

	//$$Proxy@123 impl AService
	//AServiceImpl$$springByCglibefjksdk123  extends AServiceImpl
}
