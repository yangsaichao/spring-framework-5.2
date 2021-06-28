package com.spring.earlyBean.beanPostProcessor;

import com.spring.earlyBean.bean.B;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

public class MyBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.equals("b")) {
			B b = (B) bean;
		}
		return bean;
	}
}


