package com.spring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;

/**
 * @author 钢牌讲师-子路
 * @date 2021/3/162:20
 */
@Component("t")
@Slf4j(topic = "e")
public class TestService {

	//@Autowired
	MemberService memberService;

//	@Autowired
//	BeanFactory beanFactory;
//
//
//	@Autowired
//	ApplicationContext applicationContext;

	public TestService(){

		log.debug("default Constructor");
	}

//	public TestService(MemberService memberService){
//		log.debug("param memberService  Constructor");
//		this.memberService = memberService;
//	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public void logInfo(){
		log.debug("memberservice:{}",memberService);
	}
}
