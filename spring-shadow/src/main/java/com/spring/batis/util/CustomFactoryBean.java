package com.spring.batis.util;

import com.spring.batis.dao.MDao;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * q1:如何吧一个对象注册个spring
 * 这个问题已经解决了FactoryBean这种方式比较完美
 * 在mybatis的特殊需求(批量注入dao)引发出来另外一个问题
 * 如何吧CustomFactoryBean交给spring容器
 *
 * Q2:如何把一个类交给spring管理 来完成特殊需求
 * 4、beanDefintion
 *
 *
 * 1、必须实现一个spring的接口 FactoryBean
 * 2、实现里面的两（3）个方法
 * 3、本身是一个bean
 * 4、他能够返回一个不同于本身的bean(程序员实例化的对象)
 *
 * 先不考虑多个对象的注入？
 * 单个dao的注入 CustomFactoryBean 配置方式无所谓
 * 如果我们需要批量注入dao
 * CustomFactoryBean他的配置方式（实例化方式）
 * 1、@BEAN方式不行
 * 2、XML 不行  都无法满足批量主任dao
 * 3、@Component 不行 连一个都无法动态
 * 4、beanDefintion
 * 是spring bean的建模工具（类）
 * 一个bean最终实例化出来和你提供的类关系不大 被这个类所关联的beanDefintion关联很大
 *
 */
public class CustomFactoryBean implements FactoryBean {
	Class mapperInterface;

	public CustomFactoryBean(){

	}

	public CustomFactoryBean(Class mapperInterface){

		this.mapperInterface = mapperInterface;
	}


	public void setMapperInterface(Class mapperInterface) {
		this.mapperInterface = mapperInterface;
	}

	@Override
	public Object getObject() throws Exception {

		Object dao = SqlSessionImpl.getMapper(mapperInterface);
		return dao;
	}

	@Override
	public Class<?> getObjectType() {
		return mapperInterface;
	}
}
