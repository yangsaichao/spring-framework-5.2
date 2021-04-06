package com.spring.AnnotatedBeanDefinitionReader.util;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/3/2610:50
 */
public class ShadowClassPathBeanDefinitionScanner extends ClassPathBeanDefinitionScanner {


	public ShadowClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
		super(registry);
	}


	//我这个扫描器能只能扫描到ShadowAnno
	//如果不重写则过滤规则还是spring默认的
	@Override
	protected void registerDefaultFilters() {
		//super.registerDefaultFilters();
		//includeFilters 便利出来所有的TypeFilter
		addIncludeFilter(new AnnotationTypeFilter(ShadowAnno.class));
	}
}
