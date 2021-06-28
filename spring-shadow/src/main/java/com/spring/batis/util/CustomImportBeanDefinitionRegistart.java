package com.spring.batis.util;

import com.spring.batis.dao.MDao;
import com.spring.batis.dao.XDao;
import com.spring.batis.util.bean.X;
import com.spring.batis.util.bean.Y;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 1、实现某个接口
 * 2、这个对象不是一个bean
 * 3、他需要import
 */
public class CustomImportBeanDefinitionRegistart implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		//所有扫描出来的  dao
		List<Class> list =new ArrayList<>();
		list.add(MDao.class);
		list.add(XDao.class);
		//scan
		for (Class aClass : list) {
			BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(CustomFactoryBean.class);
			AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

			beanDefinition.getPropertyValues().add("mapperInterface",aClass.getName());
			registry.registerBeanDefinition(aClass.getSimpleName(),beanDefinition);
		}

	}
}
