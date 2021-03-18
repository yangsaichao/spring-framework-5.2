package com.shadow.app;

import com.shadow.dao.IndexDao;
import com.shadow.dao.IndexDao1;
import com.shadow.test.CustomFactoryBean;
import com.shadow.test.CustomImportBeanDefinitionRegistart;
import com.shadow.test.CustomScan;
import com.shadow.test.CustomSqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.shadow")
@CustomScan
//@MapperScan("com.shadow.dao")
public class Appconfig {










}
