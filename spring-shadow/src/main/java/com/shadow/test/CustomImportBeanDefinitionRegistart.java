package com.shadow.test;

import com.shadow.dao.IndexDao;
import com.shadow.dao.IndexDao1;
import com.shadow.dao.IndexDaon;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class CustomImportBeanDefinitionRegistart  implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		//customBeanFactory  -bd
		MergedAnnotations annotations = importingClassMetadata.getAnnotations();
		//spring scan
		List<Class> list = new ArrayList<>();
		list.add(IndexDao.class);
		list.add(IndexDao1.class);
		list.add(IndexDaon.class);

		for (Class aClass : list) {
			BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(CustomFactoryBean.class);
			AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
			beanDefinition.getPropertyValues().add("mapperInterface",aClass);

			String beanName=(aClass.getSimpleName().substring(0,1).toLowerCase())+aClass.getSimpleName().substring(1);
			registry.registerBeanDefinition(beanName,beanDefinition);
		}

	}
}
