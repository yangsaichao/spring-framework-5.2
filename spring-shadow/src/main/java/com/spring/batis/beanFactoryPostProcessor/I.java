package com.spring.batis.beanFactoryPostProcessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j(topic = "e")
public class I implements Z{
	@Override
	public void print() {
		log.debug("i  print method---");
	}

	/**
	 *
	 * 属于自动Y的方法
	 * spring会自动调用这个setY方法 然后把Y 注入进入
	 *
	 * 和spring无关 属于重新了Z接口的普通方法 不会被spring调用
	 *
	 * @param y
	 */
	@Override
	public void setY(Y y) {
		log.debug("y method executed");
		log.debug("y-[{}]",y);
	}
}
