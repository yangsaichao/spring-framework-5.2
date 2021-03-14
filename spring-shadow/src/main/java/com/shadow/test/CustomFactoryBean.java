package com.shadow.test;

import com.shadow.dao.IndexDao;
import org.springframework.beans.factory.FactoryBean;


public class CustomFactoryBean implements FactoryBean {

	Class mapperInterface;
	@Override
	public Object getObject() throws Exception {

		Object mapper = CustomSqlSession.getMapper(mapperInterface);
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
