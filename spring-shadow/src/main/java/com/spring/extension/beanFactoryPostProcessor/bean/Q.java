package com.spring.extension.beanFactoryPostProcessor.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.ManagedBean;
import javax.inject.Named;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/3/2222:49
 */
@Slf4j(topic = "e")
public class Q {
	Y y;

	public void setY(Y y) {
		log.debug("y-{}",y);
		this.y = y;
	}

	public Q(){
		System.out.println("qq");
	}
}
