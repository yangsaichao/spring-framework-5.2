package com.spring.beanDefinitionRegistryPostProcessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/4/93:14
 */
@Component
@PropertySource("classpath:application.properties")
@Slf4j(topic = "e")
public class I {
	@Autowired
	private Environment environment;

	private String face;
	private String salary;

	@Value("${zl.face}")
	public void setFace(String face) {
		log.debug("face:{}",face);
		this.face = face;
	}
	@Value("${zl.salary}")
	public void setSalary(String salary) {
		environment.getProperty("zl");
		log.debug("salary:{}",salary);
		this.salary = salary;
	}
}
