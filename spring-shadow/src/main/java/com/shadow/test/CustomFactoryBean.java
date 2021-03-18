package com.shadow.test;

import com.shadow.dao.IndexDao;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;


/**
 * 1、本身是一个bean
 * 2、他会返回一个bean
 *
 * spring bean不是单纯的对象  存在spring容器当中的对象
 *
 *
 *
 * 想生成代理对象必须让这个CustomFactoryBean bean生效
 * 1、xml配置  无法解决注入多个接口  如果想要完成扫描（多个代理对象的生成，不能在xml当中配置这个bean）
 * 2、注解  也不行  连一个都无法动态生成
 * 3、beanDefinition
 *
 *
 */


public class CustomFactoryBean  implements FactoryBean{



	Class mapperInterface;

	public CustomFactoryBean(){
		System.out.println("xxxx");
	}


	public CustomFactoryBean(Class mapperInterface){
		this.mapperInterface=mapperInterface;
	}

	@Override
	public Object getObject() throws Exception {

		CustomSqlSession  customSqlSession = new CustomSqlSession();
		//mybatis返回出来的代理对象
		Object mapper = customSqlSession.getMapper(mapperInterface);
		//FactoryBean  return mapper对象会存到spring容器当中
		return mapper;
	}

	@Override
	public Class<?> getObjectType() {
		return mapperInterface;
	}


	public void setMapperInterface(Class mapperInterface) {
		this.mapperInterface = mapperInterface;
	}
}
