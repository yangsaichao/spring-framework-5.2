package com.spring.batis.util;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

//改变 添加过滤器支持@NX
public class CustomClassPathScan extends ClassPathBeanDefinitionScanner {

	public CustomClassPathScan(BeanDefinitionRegistry registry) {
		//不会调用 registerDefaultFilters
		super(registry);

	}


	@Override
	protected void registerDefaultFilters() {
		//没有添加父类的默认的过滤器
		addIncludeFilter(new AnnotationTypeFilter(NX.class));
	}
}
