package com.nx.beanFactoryPostProcessor;

import com.nx.beanFactoryPostProcessor.scan.NxClasspathBeanDefinitionScanner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
@Slf4j(topic = "e")
public class B implements BeanDefinitionRegistryPostProcessor, Ordered {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		log.debug("b  ---postProcessBeanFactory");
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		NxClasspathBeanDefinitionScanner scanner = new NxClasspathBeanDefinitionScanner(registry);
		int scan = scanner.scan("com.nx.beanFactoryPostProcessor.scan");
		System.out.println(scan);
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
