package com.spring.batis.util;

import com.spring.batis.dao.MDao;
import com.spring.batis.dao.XDao;
import com.spring.batis.util.bean.X;
import com.spring.batis.util.bean.Y;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.core.annotation.AnnotationAttributes;
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
		AnnotationAttributes mapperScanAttrs = AnnotationAttributes
				.fromMap(importingClassMetadata.getAnnotationAttributes(NXScan.class.getName()));

		String packageName = mapperScanAttrs.getString("value");

		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(ScanBeanDefinitionRegistyPostProcessor.class);
		AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
		beanDefinition.getPropertyValues().add("packageName",packageName);

		registry.registerBeanDefinition("xxx",beanDefinition);
	}
}
