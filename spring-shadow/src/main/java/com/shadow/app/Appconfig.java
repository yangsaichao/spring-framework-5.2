package com.shadow.app;

import com.shadow.dao.IndexDao;
import com.shadow.test.CustomSqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.shadow")
@ImportResource("classpath:spring.xml")
//@MapperScan("com.shadow.dao")
public class Appconfig {

	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource driverManagerDataSource
				= new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driverManagerDataSource.setPassword("root");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/shadow?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC");
		return driverManagerDataSource;
	}






	@Bean
	@Autowired
	public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		return sqlSessionFactoryBean;
	}



}
