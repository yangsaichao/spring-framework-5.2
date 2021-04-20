package com.spring.beanDefinitionRegistryPostProcessor.config;

import com.spring.AnnotatedBeanDefinitionReader.util.ShadowBeanNameAnnoGenerator;
import com.spring.AnnotatedBeanDefinitionReader.util.ShadowBeanNameGenerator;
import com.spring.beanDefinitionRegistryPostProcessor.*;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScannerRegistrar;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.*;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/4/721:12
 */
@ComponentScan(value = "com.spring.beanDefinitionRegistryPostProcessor",excludeFilters
		= {@ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE,classes = D.class)})
@Slf4j(topic = "e")
@Import(X.class)
public class Config implements G {

	@Bean
	public H h(){
		log.debug("h invoke");
		return new H();
	}

//	class MemberClz{
//		@Bean
//		public J j(){
//			log.debug("xxxx");
//			return new J();
//		}
//	}
}
