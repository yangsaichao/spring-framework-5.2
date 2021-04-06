package com.spring.namesForType.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/3/3020:54
 */
public class Y implements FactoryBean {
	@Override
	public Object getObject() throws Exception {
		return new Z();
	}

	@Override
	public Class<?> getObjectType() {
		return Z.class;
	}
}
