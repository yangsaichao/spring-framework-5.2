package com.spring.batis.util;

import com.spring.batis.app.BatisConfig;
import com.spring.batis.dao.MDao;
import com.spring.batis.service.MService;
import com.spring.batis.util.bean.X;
import com.spring.batis.util.bean.Y;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 假设我模拟的这个山寨版的mybatis还行的话
 * 缺陷：不考虑功能;没有办法和spring整合
 */

@Slf4j(topic = "e")
public class TestBatis {
	public static void main(String[] args) {


		/**
		 * 1、连接db
		 * 2、获取sql --获取当前方法上面的@Select注解里面的字符串
		 * 3、exe sql  ResultSet
		 * 4、ResultSet --list 返回
		 */
		//dao.list();


		/**
		 * 因为 mdao这个对象不存在spring容器当中
		 *
		 * 怎么让一个对象存到spring容器当中去呢？
		 * 有几种办法？
		 * 1、通过容器的api   context.getBeanFactory().registerSingleton
		 *    是不是mybatis？flase
		 *    why,因为这种方法需要程序员手动的调用api 比较麻烦
		 *    而且我们在做开发的时候ssm也没有去手动调用
		 *    这种方式只能一次注入一个  比较繁琐
		 *
		 * 2、@bean
		 *    @Bean
		 *    public MDao dao(){
		 * 		MDao dao = (MDao) SqlSessionImpl.getMapper(MDao.class);
		 * 		return dao;
		 *    }
		 *
		 *    是不是mybatis？flase
		 *    why 因为这种方式和上面那只方式 大同小异
		 *
		 *	3、factoryBean
		 *	public class CustomFactoryBean implements FactoryBean
		 *  	是不是mybatis? true
		 *  	缺陷：一次只能注入一个mapper
		 *  	怎么注入多个呢？
		 *
		 *
		 * mybatis采用的是哪种办法
		 */
		AnnotationConfigApplicationContext
				context
				= new AnnotationConfigApplicationContext();


		context.register(BatisConfig.class);
		context.refresh();

		context.getBean(MService.class).query();


		Map<String,BeanDefinition> map=null;//他是定义在beanFactory当中的
//		//x y
//		List<Class> list=null;
//		for (Class aClass : list) {
//			if(aClass-->@Component){
//				GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
//				//解析类的信息 存到 bd里面
//				beanDefinition.setBeanClassName("com.xxx.Y");
//				beanDefinition.setScope("singleton");
//				beanDefinition.setLazyInit(false);
//				beanDefinition.setDependsOn("xxx");
//				beanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
//				....
//				map.put(aClass.getSimpleName(),beanDefinition)
//
//			}
//		}
//		//调用 BeanFactoryPostProcessor   CustomBeanFactoryPostProcessor
//
//		for (String s : map.keySet()) {
//			BeanDefinition beanDefinition = map.get(s);
//			实例化bean 反射实例化
//		}
	}
}
