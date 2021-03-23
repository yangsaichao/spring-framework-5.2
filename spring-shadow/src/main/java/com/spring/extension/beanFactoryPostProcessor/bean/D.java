package com.spring.extension.beanFactoryPostProcessor.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 钢牌讲师-子路
 * @date 2021/3/2218:41
 */
@Component
public class D implements C{

	@Autowired
	B b;
}
