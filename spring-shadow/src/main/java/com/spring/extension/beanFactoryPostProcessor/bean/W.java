package com.spring.extension.beanFactoryPostProcessor.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/3/2220:44
 */
@Slf4j(topic = "e")
@Component
public class W implements X{

	Y y;

	/**
	 * 需要自动注入Y 而提供的方法
	 * 因为w实现了Y 而重写的方法
	 * @param y
	 */
	@Override
	public void setY(Y y) {
		this.y = y;
	}

	public void printInfo(){
		log.debug("bean y:{}",y);
	}

}
