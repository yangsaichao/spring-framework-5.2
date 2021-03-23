package com.spring.extension.beanFactoryPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/3/232:24
 */

public class TestFrozen implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		AbstractBeanDefinition e =
				(AbstractBeanDefinition) beanFactory.getBeanDefinition("e");
		System.out.println("自己提供的bffpp执行了");

		//不管掉不掉用对下面的这行代码没有影响
		//beanFactory.freezeConfiguration();
		//仅仅是针对本次实例化bean生效
		//修改的是bd---bean--

		/**
		 *
		 * 运行测试类，发掘E被创建了，从结果来说，他是被当成单例来创建的
		 * 容器的状态角度来看：单例当中讲道理会存在这个bean
		 */
		//e.setScope(BeanDefinition.SCOPE_PROTOTYPE);
		//e.setLazyInit(true);



	}
}
