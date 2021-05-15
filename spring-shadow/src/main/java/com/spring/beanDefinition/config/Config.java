package com.spring.beanDefinition.config;

import com.spring.beanDefinition.bean.X;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.annotation.PostConstruct;

/**
 *
 */
@Configuration("c")
@Slf4j(topic = "e")
public class Config  {

	@Bean(initMethod = "x_init")
	@Description("x-description")
	public X x(){
		return new X();
	}




//	@PostConstruct
//	public void c_init(){
//		log.debug("c_init");
//	}
}
