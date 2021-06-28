package com.spring.earlyBean.bean;

import com.spring.earlyBean.anno.Shadow;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j(topic = "e")
public class A implements I{

	public A(){
		log.debug("a create");
	}
	public void printf(){
		log.info("info");
	}
}
