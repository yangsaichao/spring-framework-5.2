package com.spring.BeanPostPorcessor.aspect;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Log4j2
public class MyAspect {

	@Pointcut("within(com.spring.BeanPostPorcessor.MyService)")
	public void pinotCut(){

	}

	@After("pinotCut()")
	public void ad(){
		log.info("aop proxy");
	}
}
