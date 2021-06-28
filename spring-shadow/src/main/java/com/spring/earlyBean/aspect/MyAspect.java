package com.spring.earlyBean.aspect;

import com.spring.earlyBean.anno.EnableAopAutoProxyCreator;
import com.spring.earlyBean.bean.A;
import com.spring.earlyBean.bean.I;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j(topic = "e")
@EnableAopAutoProxyCreator
public class MyAspect {

//	@DeclareParents(value="com.spring.earlyBean.bean.C", defaultImpl= A.class)
//	I i;

	/**
	 * 描述的连接点最小是到类
	 */
	@Pointcut("within(com.spring.earlyBean.bean.A)")
	public void pinotCutWithin(){

	}


	@Pointcut("this(com.spring.earlyBean.bean.A)")
	public void pinotCutThis(){

	}

	@Pointcut("target(com.spring.earlyBean.bean.A)")
	public void pinotCutTarget(){

	}

	@Pointcut("@within(com.spring.earlyBean.anno.Shadow)")
	public void pinotCutAnnoWithin(){

	}




	@After("pinotCutWithin()")
	public void ad(){
		log.info("aop proxy");
	}





}
