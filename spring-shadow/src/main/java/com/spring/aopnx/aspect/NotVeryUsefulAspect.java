package com.spring.aopnx.aspect;

import com.spring.aopnx.beans.CService;
import com.spring.aopnx.beans.impl.C1ServiceImpl;
import com.spring.aopnx.beans.impl.CServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j(topic = "e")
public class NotVeryUsefulAspect {

	/**
	 * DServiceImpl 的功能不符合你的要求（没有达到某种要求）
	 * 正常情况下你需要修改DServiceImpl的源码 或者你去扩展
	 * spring aop  Introductions提供一种便捷的方式
	 * 这里的写法就是让 D 生成一个代理对象 实现 CService接口
	 * 让C1ServiceImpl（一定需要实现CService）里面实现了 CService接口的那些方法
	 * 的逻辑作为D生成的代理对象当中对于 CService的方法的实现
	 */
//	@DeclareParents(value="com.spring.aopnx.beans.impl.DServiceImpl", defaultImpl= CServiceImpl.class)
//	public static CService c;


	@Pointcut("execution(* com.spring.aopnx.beans..*.*(..))")
	private void executionPointCut() {
	}

	@Pointcut("within(com.spring.aopnx.beans.impl.AServiceImpl)")
	private void withinPointCut() {
	}

	//this=代理对象如果等于AServiceImpl类型 则拦截下面所有的方法
	@Pointcut("this(com.spring.aopnx.beans.impl.AServiceImpl)")
	private void thisPointCut() {
	}

	//target=目标对象如果等于AServiceImpl类型 则拦截下面所有的方法
	@Pointcut("target(com.spring.aopnx.beans.impl.BServiceImpl)")
	private void targetPointCut() {
	}


	@Pointcut("args(Integer)")
	private void argsPointCut() {
	}


	@Pointcut("@annotation(com.spring.aopnx.util.Nx)")
	private void annotationMthodPointCut() {
	}

	@Pointcut("@within(com.spring.aopnx.util.NxClazz)")
	private void annotationClassPointCut() {
	}


	@Pointcut("@within(com.spring.aopnx.util.NxClazz) && args(Integer)")
	private void annotationClassaAndArgsPointCut() {
	}





	@After("withinPointCut()")
	public void doAccessCheck() {
		log.debug("aop proxy");
	}








}
