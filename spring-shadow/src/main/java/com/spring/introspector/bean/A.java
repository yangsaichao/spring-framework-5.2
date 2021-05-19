package com.spring.introspector.bean;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class A {
	//半自动注入---手工注入
	//用的是java的反射 filed
	@Autowired
	Y y;






	@Autowired
	//表面上等同于y的注入
	public void setZ(Z z) {
		//内省机制所识别然后执行
		log.info("z-{}",z);
	}


	//自省机制---writeMethod
	public void setX(X x) {
		log.info("x-{}",x);
	}





	public void printf(){
		log.info("y-{}",y);
	}
}
