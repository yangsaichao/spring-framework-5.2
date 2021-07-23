package com.nx.beanFactoryPostProcessor.scan;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

public class X implements BeanNameAware {
	public X(){
		System.out.println("x");
	}

	@Override
	public void setBeanName(String name) {
		//System.out.println(name);
	}
}
