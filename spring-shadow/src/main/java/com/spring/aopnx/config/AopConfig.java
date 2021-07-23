package com.spring.aopnx.config;

import com.spring.aopnx.util.EnableAop;
import com.spring.aopnx.util.NxBeanPostProcessor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


@Configuration
@ComponentScan(value = "com.spring.aopnx.listener")
//@EnableAop
@EnableAop
public class AopConfig {

}
