package com.spring.AnnotatedBeanDefinitionReader.config;

import com.spring.AnnotatedBeanDefinitionReader.util.ShadowAnno;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.type.filter.TypeFilter;

/**
 * @author 钢牌讲师-子路
 * @date 2021/3/162:21
 */
@Configuration
@ComponentScan(value = "com.spring.AnnotatedBeanDefinitionReader.bean",
		excludeFilters ={@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = ShadowAnno.class)} )
//@ImportResource("classpath:spring.xml")
public class Config {
}
