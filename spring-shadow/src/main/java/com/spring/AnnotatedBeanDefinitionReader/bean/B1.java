package com.spring.AnnotatedBeanDefinitionReader.bean;

import com.spring.AnnotatedBeanDefinitionReader.util.ShadowAnno;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/3/265:54
 */

@ShadowAnno
public class B1 implements BeanNameAware {
	@Override
	public void setBeanName(String name) {
		System.out.println("b1-name="+name);
	}

}
