package com.spring.BeanPostPorcessor;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.ReactiveAdapterRegistry;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Log4j2
public class MyBeanPostPorcessor implements BeanPostProcessor,Ordered{



	@Autowired
	ApplicationContext applicationContext;
//
	@Autowired
	MyService myService;


	@PostConstruct
	public void init(){
		log.info("init");
	}
	public void printf(){
		//myService.xx();
		//applicationContext.getBean(MyService.class).xx();
		//log.info("app-{}",applicationContext);
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}



	@Override
	public int getOrder() {
		return Ordered.HIGHEST_PRECEDENCE;
	}

//	@Override
//	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//		this.applicationContext=applicationContext;
//	}
}
