package com.spring.beanDefinitionRegistryPostProcessor.config;

import com.spring.beanDefinitionRegistryPostProcessor.E;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/4/721:12
 */
@Import(E.class)
@ComponentScan("com.spring.beanDefinitionRegistryPostProcessor")
public class Config {
}
