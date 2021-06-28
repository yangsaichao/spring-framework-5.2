package com.spring.batis.test;

import com.spring.batis.dao.MDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.core.env.Environment;
import org.springframework.transaction.jta.TransactionFactory;

import javax.sql.DataSource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Map;
@Slf4j(topic = "e")
public class Test {
	public static void main(String[] args) {

		/**
		 * 假设代码能够运行
		 */
		DataSource dataSource =null;
		TransactionFactory transactionFactory =null;
		Environment environment = null;
		Configuration configuration = null;
		//添加一个mapper--MDao.class接口  给mybaist
		configuration.addMapper(MDao.class);
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();



		//获取一个mapper 对象出来
		//在获取的时候生成了代理对象
		//sqlSession.getMapper  ==  Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[] { mapperInterface }, mapperProxy);
		MDao mapper = sqlSession.getMapper(MDao.class);




		List<Map<String, Object>> list = mapper.list();
		System.out.println(list);






	}
}
