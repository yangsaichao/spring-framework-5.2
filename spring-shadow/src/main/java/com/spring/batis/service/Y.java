package com.spring.batis.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j(topic = "e")
public class Y implements ApplicationContextAware, BeanNameAware, InitializingBean {

	ApplicationContext context;

	@Autowired
	X x;


	public void aopMethod(){
		log.debug("y logic");
	}

	@PostConstruct
	public void initAnno(){
		log.debug("y init method PostConstruct");
	}

	public Y(Z z){
		log.debug("y create from z");
	}

	public Y(Z z,U u){
		log.debug("y create from z u");
	}


	public Y(){
		log.debug("y create");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		log.debug("setApplicationContext ---callback [ApplicationContextAware]");
		this.context=applicationContext;
	}

	@Override
	public void setBeanName(String name) {
		log.debug("setBeanName---callback [BeanNameAware]");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		log.debug("afterPropertiesSet-----spring init method [InitializingBean]");
	}
}
