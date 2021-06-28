package com.spring.batis.aspect;

import com.spring.earlyBean.anno.EnableAopAutoProxyCreator;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j(topic = "e")
public class MyAspect {

//	@DeclareParents(value="com.spring.earlyBean.bean.C", defaultImpl= A.class)
//	I i;

	/**
	 * 描述的连接点最小是到类
	 */
	@Pointcut("within(com.spring.batis.service.Y)")
	public void pinotCutWithin(){

	}





	@After("pinotCutWithin()")
	public void ad(){
		log.debug("aop proxy [after]");
	}





}
