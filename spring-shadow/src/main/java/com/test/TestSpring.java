package com.test;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.ChildBeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/3/2316:47
 */
public class TestSpring {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext
				ac = new AnnotationConfigApplicationContext();



		//把p类变成rootbd  作为一个父类，也可以作为一个正常
		RootBeanDefinition p = new RootBeanDefinition(P.class);
		//给p的bd设置了一些属性  scope=prototype
		p.setScope(AbstractBeanDefinition.SCOPE_PROTOTYPE);





		//实例化一个childbd，这个bd继承了名字为p的bd
		ChildBeanDefinition c = new ChildBeanDefinition("p");
		//再把这个bd去关联C类
		c.setBeanClass(C.class);


//		GenericBeanDefinition p = new GenericBeanDefinition();
//		p.setBeanClass(P.class);
//		p.setScope(AbstractBeanDefinition.SCOPE_PROTOTYPE);
//
//
//		GenericBeanDefinition c = new GenericBeanDefinition();
//		c.setParentName("p");
//		c.setBeanClass(C.class);

		//往bdmapd当中添加bd
		ac.registerBeanDefinition("p",p);
		ac.registerBeanDefinition("c",c);
		ac.refresh();

		System.out.println(ac.getBean(Bean1.class));
	}
}
