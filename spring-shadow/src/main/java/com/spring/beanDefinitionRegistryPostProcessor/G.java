package com.spring.beanDefinitionRegistryPostProcessor;

import org.springframework.context.annotation.Bean;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/4/92:38
 */
public interface G {
	@Bean
	default H h(){
		return new H();
	}
}
