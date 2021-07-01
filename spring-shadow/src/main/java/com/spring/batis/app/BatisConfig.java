package com.spring.batis.app;

import com.spring.batis.dao.MDao;
import com.spring.batis.dao.XDao;
import com.spring.batis.util.CustomFactoryBean;
import com.spring.batis.util.CustomImportBeanDefinitionRegistart;
import com.spring.batis.util.CustomScan;
import com.spring.batis.util.SqlSessionImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


@Configuration
@ComponentScan("com.spring.batis.beanFactoryPostProcessor")
//批量注入dao --原理--批量往spring容器里面添加对象
//@CustomScan
//@Import(CustomImportBeanDefinitionRegistart.class)
public class BatisConfig {


//	@Bean
//	public CustomFactoryBean mdao() throws Exception {
//		CustomFactoryBean factoryBean = new CustomFactoryBean(MDao.class);
//		return factoryBean;
//	}

//	@Bean
//	public MDao dao(){
//		MDao dao = (MDao) SqlSessionImpl.getMapper(MDao.class);
//		return dao;
//	}

//	@Bean
//	public DataSource dataSource(){
//		DriverManagerDataSource driverManagerDataSource
//				= new DriverManagerDataSource();
//		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		driverManagerDataSource.setPassword("123456");
//		driverManagerDataSource.setUsername("root");
//		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/shadow?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC");
//		return driverManagerDataSource;
//	}
//
//	@Bean
//	@Autowired
//	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//		factoryBean.setDataSource(dataSource());
//		return factoryBean.getObject();
//	}
}
