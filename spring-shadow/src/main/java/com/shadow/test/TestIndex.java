package com.shadow.test;

import com.shadow.dao.IndexDao;
import com.shadow.info.UserInfo;
import com.shadow.util.BeanInfoUtil;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;
import xx.B;
import com.shadow.app.Appconfig;
import com.shadow.service.IndexService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.activation.DataSource;
import java.lang.reflect.Proxy;
import java.sql.Driver;

@Slf4j(topic = "e")
public class TestIndex {
	public static void main(String[] args) {



		AnnotationConfigApplicationContext ac
				= new AnnotationConfigApplicationContext();


		ac.register(Appconfig.class);
		ac.refresh();

		IndexService bean = ac.getBean(IndexService.class);
		bean.list();































////
//		GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
//		genericBeanDefinition.setBeanClass(B.class);
//
//
//		AnnotatedGenericBeanDefinition ag= new AnnotatedGenericBeanDefinition(B.class);
//		AnnotationMetadata metadata = ag.getMetadata();
//		log.debug(Component.class.getSimpleName()+"");
//		System.out.println(metadata.hasAnnotation("org.springframework.stereotype.Component"));
//		log.debug("serviceName-{}");
	}
}
