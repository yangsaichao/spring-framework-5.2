package com.spring.extension.beanFactoryPostProcessor.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/3/2220:44
 */
@Slf4j(topic = "e")
@Component("xxxx")
public class A {

	B b;

	public void setB(B b) {
		this.b = b;
	}

	public void printInfo(){
		log.debug("bean-b:{}",b);
	}



}
