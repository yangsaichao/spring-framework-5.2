package com.spring.extension.beanFactoryPostProcessor.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/3/2221:15
 */
@Slf4j(topic = "e")
@Component
public class Z implements ApplicationContextAware{


	ApplicationContext applicationContext;

	/**
	 * 他会在Z这个bean的生命周期某一步骤被调用
	 * setApplicationContext 是spring在特定时机调用的
	 * 没有实现接口的情况下，他的调用时机是在填充属性的时候
	 * @param applicationContext the ApplicationContext object to be used by this object
	 * @throws BeansException
	 */

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
			this.applicationContext=applicationContext;
			log.debug("applicationContext-name:{}",applicationContext.getClass().getSimpleName());
			log.debug("现在容器对象已经有了，你可以在你的Z当中放肆使用了");
	}




}
