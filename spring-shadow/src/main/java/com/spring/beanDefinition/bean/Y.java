package com.spring.beanDefinition.bean;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
@Component
@Slf4j(topic = "e")
public class Y implements InitializingBean {




	X x;

	Date date;

	String msg;

	public void setDate(Date date) {
		log.debug("date");
		this.date = date;
	}



	public void setMsg(String msg) {
		log.debug("msg");
		this.msg = msg;
	}


	public void setX(X x) {
		log.debug("x");
		this.x = x;
	}


	public X getX() {
		log.debug("msg-{}",msg);
		log.debug("date-{}",date);
		log.debug("x-{}",x);
		return x;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		log.debug("y-init afterPropertiesSet");
	}

	public void y_init(){
		log.debug("y-init y_init");
	}

	@PostConstruct
	public void y_anno_init(){
		log.debug("y-anno-init y_anno_init");
	}
}
