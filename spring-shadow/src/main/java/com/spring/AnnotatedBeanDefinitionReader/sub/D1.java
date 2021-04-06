package com.spring.AnnotatedBeanDefinitionReader.sub;

import com.spring.AnnotatedBeanDefinitionReader.util.ShadowAnno;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/3/2610:03
 */
@ShadowAnno
public class D1 implements BeanNameAware {
	@Override
	public void setBeanName(String name) {
		System.out.println("d-name:"+name);
	}
}
