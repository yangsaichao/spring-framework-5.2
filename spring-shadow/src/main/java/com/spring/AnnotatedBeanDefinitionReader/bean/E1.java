package com.spring.AnnotatedBeanDefinitionReader.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;

import java.lang.reflect.Constructor;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/4/512:36
 */
@Slf4j(topic = "e")
public class E1 {

	public E1(){

		log.debug("d1 Constructor invoke");
	}
}
