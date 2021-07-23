package com.nx.beanFactoryPostProcessor.scan;

import org.aspectj.weaver.patterns.AndAnnotationTypePattern;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;

public class NxClasspathBeanDefinitionScanner extends ClassPathBeanDefinitionScanner {

	public NxClasspathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
		super(registry);
	}

	@Override
	protected void registerDefaultFilters() {
		TypeFilter typeFilter = new AnnotationTypeFilter(Nx.class);
		addIncludeFilter(typeFilter);
	}

	@Override
	public void addIncludeFilter(TypeFilter includeFilter) {
		super.addIncludeFilter(includeFilter);
	}
}
