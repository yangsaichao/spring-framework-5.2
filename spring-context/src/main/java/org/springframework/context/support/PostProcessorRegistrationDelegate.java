/*
 * Copyright 2002-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.context.support;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.core.OrderComparator;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.lang.Nullable;

/**
 * Delegate for AbstractApplicationContext's post-processor handling.
 *
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @since 4.0
 */
final class PostProcessorRegistrationDelegate {

	private PostProcessorRegistrationDelegate() {
	}


	/**
	 * 执行所有的（存在spring容器当中的BeanFactoryPostProcessor(BeanDefinitionRegistryPostProcessor)）
	 * @param beanFactory
	 * @param beanFactoryPostProcessors
	 */
	public static void invokeBeanFactoryPostProcessors(
			ConfigurableListableBeanFactory beanFactory, List<BeanFactoryPostProcessor> beanFactoryPostProcessors) {


		// Invoke BeanDefinitionRegistryPostProcessors first, if any.
		//所有已经找出来的（已经处理了，已经执行完的） BeanFactoryPostProcessor 或者 BeanDefinitionRegistryPostProcessor
		//仅仅存放名字，保证不会重复执行
		Set<String> processedBeans = new HashSet<>();

		if (beanFactory instanceof BeanDefinitionRegistry) {

			BeanDefinitionRegistry registry = (BeanDefinitionRegistry) beanFactory;
			//存放所有找出来的 BeanFactoryPostProcessor  父类
			List<BeanFactoryPostProcessor> regularPostProcessors = new ArrayList<>();
			//存放所有找出来的 BeanDefinitionRegistryPostProcessor  子类的
			List<BeanDefinitionRegistryPostProcessor> registryProcessors = new ArrayList<>();

			//遍历beanFactoryPostProcessors 方法传进来的一个list集合
			//spring最先执行得是程序员通过api提供得 context.addBeanFactoryPostProcessor(new bfpp)
			//为什么最先执行他？为什么和扫描得执行时机不一样呢？
			//一般没有元素
			for (BeanFactoryPostProcessor postProcessor : beanFactoryPostProcessors) {
				//如果有的情况下首先 判断是否子类
				if (postProcessor instanceof BeanDefinitionRegistryPostProcessor) {
					BeanDefinitionRegistryPostProcessor registryProcessor =
							(BeanDefinitionRegistryPostProcessor) postProcessor;
					//如果是强转后直接执行
					registryProcessor.postProcessBeanDefinitionRegistry(registry);
					//执行完成后存放registryProcessors
					//为什么执行完成了之后还要存放到这个list当中呢？
					//主要是因为这里是判断子类，虽然子类的回调方法执行完成了
					//但是父类的回调方法没有执行，存放到这个list当中就是为了
					//后续到了执行父类回调的时机得时候，去遍历这个list，然后依次获取出来执行
					registryProcessors.add(registryProcessor);
				}
				else {
					//如果是父类的先不执行，先把他add到这个list当中
					//意义和上面一样，主要是为了时机到了时候遍历然后执行
					//既然这两个list仅仅是存放后在获取为什么需要两个呢？
					//其实一个就能解决
					//我的理解两个原因
					//1、毕竟这是两种类一种子类一种父类，分开存放更加的合理
					//2、也是最重要的原因，spring还是得区分这两种类的父类方法得执行顺序
					//虽然都是执行父类的回调，但是直接实现父类的类和直接实现子类的类如果分开存放
					//则可以控制这两类类的执行顺序和时机  当然这只是我的理解---不知道能不能说服你
					regularPostProcessors.add(postProcessor);
				}
			}





			// Do not initialize FactoryBeans here: We need to leave all regular beans
			// uninitialized to let the bean factory post-processors apply to them!
			// Separate between BeanDefinitionRegistryPostProcessors that implement
			// PriorityOrdered, Ordered, and the rest.
			//定义了一个集合来存放当前需要执行的 BeanDefinitionRegistryPostProcessor 为什么需要这个集合
			//因为在spring的代码角度考虑BeanDefinitionRegistryPostProcessor的种类很多
			//主要三种
			//1、实现了 PriorityOrdered接口类型的
			//2、实现了 Ordered 接口类型的
			//3、什么都没实现
			//站在BeanDefinitionRegistryPostProcessor的来源角度来考虑分为两种
			//1、spring自己提供的
			//2、外部提供的
			//3、api提供得
			//由于 BeanDefinitionRegistryPostProcessor种类很复杂，故而spring得分批执行
			//这样能保证这些不同类型得BeanDefinitionRegistryPostProcessor 得执行时机
			//所以每次找到合适得，就需要一个集合来存放，然后执行
			List<BeanDefinitionRegistryPostProcessor> currentRegistryProcessors = new ArrayList<>();

			/**
			 *需要执行BeanDefinitionRegistryPostProcessor 首先得实例化
			 *实例化之前首先spring得知道整个容器当中有哪些BeanDefinitionRegistryPostProcessor
			 * 容器里面有几个BeanDefinitionRegistryPostProcessor
			 *  执行内部的BeanDefinitionRegistryPostProcessor
			 *  ConfigrationClassPostPorcessor#postProcessBeanDefinitionRegistry  扫描
			 *  实例化这个类
			 */
			//首先从容器（单例池或者bdmap）当中找到所有实现了 BeanDefinitionRegistryPostProcessor接口得类得名字
			//从这里可知由于整个spring容器还在启动得过程中，所以这里能找到得就是spring内置得一些BeanDefinitionRegistryPostProcessor
			//正常情况下 执行玩这里 这个 postProcessorNames得长度=1
			//因为这里可以找到一个 属于BeanDefinitionRegistryPostProcessor类型的bd
			//spring在启动的时候自己往bdMap当中添加的那个 ConfigrationClassPostPorcessor
			// First, invoke the BeanDefinitionRegistryPostProcessors .
			String[] postProcessorNames =
					beanFactory.getBeanNamesForType(BeanDefinitionRegistryPostProcessor.class, true, false);

			//根据名字去得到这个bean（实例化）
			for (String ppName : postProcessorNames) {
				if (beanFactory.isTypeMatch(ppName, PriorityOrdered.class)) {
					//有则取，无则实例化然后put到单例池 然后在返回
					//得到bean之后放到当前需要执行得list当中
					currentRegistryProcessors.add(beanFactory.getBean(ppName, BeanDefinitionRegistryPostProcessor.class));
					//add完成之后表示spring接下来一定会去执行他
					//表示这个bean已经处理过了，下次在找到也不会添加到当前list当中
					processedBeans.add(ppName);
				}
			}

			//排序
			sortPostProcessors(currentRegistryProcessors, beanFactory);
			//为什么需要addAll
			//添加到 registryProcessors 方便执行父类得回调
			registryProcessors.addAll(currentRegistryProcessors);
			//因为这个currentRegistryProcessors当中正常情况里面只有一个bean ConfigrationClassPostPorcessor
			//所以这个方法的意义就是执行 ConfigrationClassPostPorcessor#postProcessBeanDefinitionRegistry
			//这个方法做了很多事情
			//1、完成了扫描
			//完成了扫描  postProcessor.postProcessBeanDefinitionRegistry 注册bd
			//2、对扫描出来的bd(所对应的类)上面的@Import注解的解析
			invokeBeanDefinitionRegistryPostProcessors(currentRegistryProcessors, registry);

			//因为已经执行完了，故而需要清除这个当前list
			currentRegistryProcessors.clear();

			// Next, invoke the BeanDefinitionRegistryPostProcessors that implement Ordered.
			// getBeanNamesForType  -----bean的名字
			//然后再从容器当中找BeanDefinitionRegistryPostProcessor
			//为什么还要找？前面不是找过了？
			//原因有两个
			//1、BeanDefinitionRegistryPostProcessor得主要功能就是往容器注册bd
			//由于前面执行过一次，你不能保证他没有向容器当中注册一些bd，故而有可能前面那次执行
			//就往容器里面注册了新的 BeanDefinitionRegistryPostProcessor 得bd 所以这里需要再找一此
			//2、正如1所说得，其实第一次执行 BeanDefinitionRegistryPostProcessor 就是完成扫描
			//所以有可能扫描到了程序员提供得 BeanDefinitionRegistryPostProcessor
			postProcessorNames = beanFactory.getBeanNamesForType(BeanDefinitionRegistryPostProcessor.class, true, false);
			for (String ppName : postProcessorNames) {
				//找到之后首先判断是否被处理过，因为这里肯定也能找i出来第一次已经执行过的哪些 BeanDefinitionRegistryPostProcessor
				//由于已经执行过的存在processedBeans这个集合，故而这里不会进if，也就是已经执行过的不会存在当前list
				//然后再去判断是否 实现了Ordered接口
				if (!processedBeans.contains(ppName) && beanFactory.isTypeMatch(ppName, Ordered.class)) {
					currentRegistryProcessors.add(beanFactory.getBean(ppName, BeanDefinitionRegistryPostProcessor.class));
					processedBeans.add(ppName);
				}
			}
			sortPostProcessors(currentRegistryProcessors, beanFactory);
			registryProcessors.addAll(currentRegistryProcessors);

			invokeBeanDefinitionRegistryPostProcessors(currentRegistryProcessors, registry);

			currentRegistryProcessors.clear();

			// Finally, invoke all other BeanDefinitionRegistryPostProcessors until no further ones appear.
			boolean reiterate = true;
			//这里为是什么需要进行一个while得循环?

			//执行所有没有实现PriorityOrdered 没有Ordered的BeanDefinitionRegistryPostProcessor的bean
			/**
			 * 为什么还需要找一次
			 * 这是因为执行子类的时候会往bdmap当中添加一些新的bd
			 * 而这些bd有可能就是属于子类
			 */
			while (reiterate) {
				reiterate = false;
				postProcessorNames = beanFactory.getBeanNamesForType(BeanDefinitionRegistryPostProcessor.class, true, false);
				for (String ppName : postProcessorNames) {
					if (!processedBeans.contains(ppName)) {
						currentRegistryProcessors.add(beanFactory.getBean(ppName, BeanDefinitionRegistryPostProcessor.class));
						processedBeans.add(ppName);
						//如果能够找到一个说明可能会往容器当中添加新的bd
						//如果能够再次找到一个BeanDefinitionRegistryPostProcessor 那么需要再次循环（再次找一遍）
						reiterate = true;
					}
				}
				sortPostProcessors(currentRegistryProcessors, beanFactory);
				registryProcessors.addAll(currentRegistryProcessors);
				//执行子类的子类方法
				invokeBeanDefinitionRegistryPostProcessors(currentRegistryProcessors, registry);
				currentRegistryProcessors.clear();
			}

			//到此为止 spring已经把容器所有得实现了 BeanDefinitionRegistryPostProcessor接口得
			// 回调全部执行完了  接下来需要执行父类得
			//由于前面执行得全部是子类所以必然也全部是父类
			//所以前面所有执行得子类都需要再执行一边父类
			//于是从registryProcessors（已经全部执行完子类回调得哪些类）遍历出来执行父类得回调

			//这里执行父类的回调，但是先是执行实现了子类的bean的父类回调
			// Now, invoke the postProcessBeanFactory callback of all processors handled so far.
			invokeBeanFactoryPostProcessors(registryProcessors, beanFactory);


			//执行直接实现了父类的回调  context.addBeanFactoryPostProcessor("父类");
			invokeBeanFactoryPostProcessors(regularPostProcessors, beanFactory);
		}

		else {
			// Invoke factory processors registered with the context instance.
			invokeBeanFactoryPostProcessors(beanFactoryPostProcessors, beanFactory);
		}

		/**
		 * 执行父类得回调(直接实现了父类得)  扫描得到得类
		 */

		// Do not initialize FactoryBeans here: We need to leave all regular beans
		// uninitialized to let the bean factory post-processors apply to them!
		String[] postProcessorNames =
				beanFactory.getBeanNamesForType(BeanFactoryPostProcessor.class, true, false);

		// Separate between BeanFactoryPostProcessors that implement PriorityOrdered,
		// Ordered, and the rest.
		List<BeanFactoryPostProcessor> priorityOrderedPostProcessors = new ArrayList<>();
		List<String> orderedPostProcessorNames = new ArrayList<>();
		List<String> nonOrderedPostProcessorNames = new ArrayList<>();
		for (String ppName : postProcessorNames) {
			if (processedBeans.contains(ppName)) {
				// skip - already processed in first phase above
			}
			else if (beanFactory.isTypeMatch(ppName, PriorityOrdered.class)) {
				priorityOrderedPostProcessors.add(beanFactory.getBean(ppName, BeanFactoryPostProcessor.class));
			}
			else if (beanFactory.isTypeMatch(ppName, Ordered.class)) {
				orderedPostProcessorNames.add(ppName);
			}
			else {
				nonOrderedPostProcessorNames.add(ppName);
			}
		}

		// First, invoke the BeanFactoryPostProcessors that implement PriorityOrdered.
		sortPostProcessors(priorityOrderedPostProcessors, beanFactory);
		invokeBeanFactoryPostProcessors(priorityOrderedPostProcessors, beanFactory);

		// Next, invoke the BeanFactoryPostProcessors that implement Ordered.
		List<BeanFactoryPostProcessor> orderedPostProcessors = new ArrayList<>(orderedPostProcessorNames.size());
		for (String postProcessorName : orderedPostProcessorNames) {
			orderedPostProcessors.add(beanFactory.getBean(postProcessorName, BeanFactoryPostProcessor.class));
		}
		sortPostProcessors(orderedPostProcessors, beanFactory);
		invokeBeanFactoryPostProcessors(orderedPostProcessors, beanFactory);

		// Finally, invoke all other BeanFactoryPostProcessors.
		List<BeanFactoryPostProcessor> nonOrderedPostProcessors = new ArrayList<>(nonOrderedPostProcessorNames.size());
		for (String postProcessorName : nonOrderedPostProcessorNames) {
			nonOrderedPostProcessors.add(beanFactory.getBean(postProcessorName, BeanFactoryPostProcessor.class));
		}
		invokeBeanFactoryPostProcessors(nonOrderedPostProcessors, beanFactory);

		// Clear cached merged bean definitions since the post-processors might have
		// modified the original metadata, e.g. replacing placeholders in values...
		//清除 mergedMap 清除allBeanNamesByType 缓存
		//这里清除缓存主要是为了合并 --
		// 因为到此为止，spring已经执行完了父类
		//意味着有可能执行得哪些父类修改了bd
		// 所以下次get得时候需要合并而不是直接从merged当中直接拿
		beanFactory.clearMetadataCache();
	}

	//spring已经完成了扫描
	//registerBeanPostProcessors  -- beanPostProcessors.add
	public static void registerBeanPostProcessors(
			ConfigurableListableBeanFactory beanFactory, AbstractApplicationContext applicationContext) {
		//bdmap 找到所有 BeanPostProcessor 找出来名字；但是不是所有都实例化好了---单例池当中
		String[] postProcessorNames = beanFactory.getBeanNamesForType(BeanPostProcessor.class, true, false);

		// Register BeanPostProcessorChecker that logs an info message when
		// a bean is created during BeanPostProcessor instantiation, i.e. when
		// a bean is not eligible for getting processed by all BeanPostProcessors.
		//beanProcessorTargetCount 一个如果正常走完生命周期他需要经历几次beanProcessor
		//+ 1 = BeanPostProcessorChecker
		//这个值不会更改了 =8
		//BeanPostProcessorChecker 检查期望执行的后置处理器次数和现在 当前拿到的所有后置处理器的数量是否一致
		//如果不一样 不会出异常 用来给程序员排除错误
		int beanProcessorTargetCount = beanFactory.getBeanPostProcessorCount() + 1 + postProcessorNames.length;

		beanFactory.addBeanPostProcessor(new BeanPostProcessorChecker(beanFactory, beanProcessorTargetCount));

		// Separate between BeanPostProcessors that implement PriorityOrdered,
		// Ordered, and the rest.
		List<BeanPostProcessor> priorityOrderedPostProcessors = new ArrayList<>();
		List<BeanPostProcessor> internalPostProcessors = new ArrayList<>();
		List<String> orderedPostProcessorNames = new ArrayList<>();
		List<String> nonOrderedPostProcessorNames = new ArrayList<>();
		for (String ppName : postProcessorNames) {
			if (beanFactory.isTypeMatch(ppName, PriorityOrdered.class)) {
				//comm  --init
				//mybpp
				BeanPostProcessor pp = beanFactory.getBean(ppName, BeanPostProcessor.class);

				priorityOrderedPostProcessors.add(pp);
				if (pp instanceof MergedBeanDefinitionPostProcessor) {
					internalPostProcessors.add(pp);
				}
			}
			else if (beanFactory.isTypeMatch(ppName, Ordered.class)) {
				orderedPostProcessorNames.add(ppName);
			}
			else {
				nonOrderedPostProcessorNames.add(ppName);
			}
		}

		// First, register the BeanPostProcessors that implement PriorityOrdered.
		sortPostProcessors(priorityOrderedPostProcessors, beanFactory);
		//AnnotationAwareAspectJAutoProxyCreator ---add  List<BeanPostProcessor> beanPostProcessors
		registerBeanPostProcessors(beanFactory, priorityOrderedPostProcessors);

		// Next, register the BeanPostProcessors that implement Ordered.
		List<BeanPostProcessor> orderedPostProcessors = new ArrayList<>(orderedPostProcessorNames.size());
		for (String ppName : orderedPostProcessorNames) {
			BeanPostProcessor pp = beanFactory.getBean(ppName, BeanPostProcessor.class);
			orderedPostProcessors.add(pp);
			if (pp instanceof MergedBeanDefinitionPostProcessor) {
				internalPostProcessors.add(pp);
			}
		}
		sortPostProcessors(orderedPostProcessors, beanFactory);
		registerBeanPostProcessors(beanFactory, orderedPostProcessors);

		// Now, register all regular BeanPostProcessors.
		List<BeanPostProcessor> nonOrderedPostProcessors = new ArrayList<>(nonOrderedPostProcessorNames.size());
		for (String ppName : nonOrderedPostProcessorNames) {
			BeanPostProcessor pp = beanFactory.getBean(ppName, BeanPostProcessor.class);
			nonOrderedPostProcessors.add(pp);
			if (pp instanceof MergedBeanDefinitionPostProcessor) {
				internalPostProcessors.add(pp);
			}
		}
		registerBeanPostProcessors(beanFactory, nonOrderedPostProcessors);

		// Finally, re-register all internal BeanPostProcessors.
		sortPostProcessors(internalPostProcessors, beanFactory);
		registerBeanPostProcessors(beanFactory, internalPostProcessors);

		// Re-register post-processor for detecting inner beans as ApplicationListeners,
		// moving it to the end of the processor chain (for picking up proxies etc).
		beanFactory.addBeanPostProcessor(new ApplicationListenerDetector(applicationContext));
	}

	private static void sortPostProcessors(List<?> postProcessors, ConfigurableListableBeanFactory beanFactory) {
		// Nothing to sort?
		if (postProcessors.size() <= 1) {
			return;
		}
		Comparator<Object> comparatorToUse = null;
		if (beanFactory instanceof DefaultListableBeanFactory) {
			comparatorToUse = ((DefaultListableBeanFactory) beanFactory).getDependencyComparator();
		}
		if (comparatorToUse == null) {
			comparatorToUse = OrderComparator.INSTANCE;
		}
		postProcessors.sort(comparatorToUse);
	}

	/**
	 * Invoke the given BeanDefinitionRegistryPostProcessor beans.
	 */
	private static void invokeBeanDefinitionRegistryPostProcessors(
			Collection<? extends BeanDefinitionRegistryPostProcessor> postProcessors, BeanDefinitionRegistry registry) {

		for (BeanDefinitionRegistryPostProcessor postProcessor : postProcessors) {
			postProcessor.postProcessBeanDefinitionRegistry(registry);

		}
	}

	/**
	 * Invoke the given BeanFactoryPostProcessor beans.
	 */
	private static void invokeBeanFactoryPostProcessors(
			Collection<? extends BeanFactoryPostProcessor> postProcessors, ConfigurableListableBeanFactory beanFactory) {

		for (BeanFactoryPostProcessor postProcessor : postProcessors) {
			postProcessor.postProcessBeanFactory(beanFactory);
		}
	}

	/**
	 * Register the given BeanPostProcessor beans.
	 */
	private static void registerBeanPostProcessors(
			ConfigurableListableBeanFactory beanFactory, List<BeanPostProcessor> postProcessors) {

		for (BeanPostProcessor postProcessor : postProcessors) {
			beanFactory.addBeanPostProcessor(postProcessor);
		}
	}


	/**
	 * BeanPostProcessor that logs an info message when a bean is created during
	 * BeanPostProcessor instantiation, i.e. when a bean is not eligible for
	 * getting processed by all BeanPostProcessors.
	 */
	private static final class BeanPostProcessorChecker implements BeanPostProcessor {

		private static final Log logger = LogFactory.getLog(BeanPostProcessorChecker.class);

		private final ConfigurableListableBeanFactory beanFactory;

		private final int beanPostProcessorTargetCount;

		public BeanPostProcessorChecker(ConfigurableListableBeanFactory beanFactory, int beanPostProcessorTargetCount) {
			this.beanFactory = beanFactory;
			this.beanPostProcessorTargetCount = beanPostProcessorTargetCount;
		}

		@Override
		public Object postProcessBeforeInitialization(Object bean, String beanName) {
			return bean;
		}

		@Override
		public Object postProcessAfterInitialization(Object bean, String beanName) {
			if (!(bean instanceof BeanPostProcessor) && !isInfrastructureBean(beanName) &&
					this.beanFactory.getBeanPostProcessorCount() < this.beanPostProcessorTargetCount) {
				if (logger.isInfoEnabled()) {
					logger.info("Bean '" + beanName + "' of type [" + bean.getClass().getName() +
							"] is not eligible for getting processed by all BeanPostProcessors " +
							"(for example: not eligible for auto-proxying)");
				}
			}
			return bean;
		}

		private boolean isInfrastructureBean(@Nullable String beanName) {
			if (beanName != null && this.beanFactory.containsBeanDefinition(beanName)) {
				BeanDefinition bd = this.beanFactory.getBeanDefinition(beanName);
				return (bd.getRole() == RootBeanDefinition.ROLE_INFRASTRUCTURE);
			}
			return false;
		}
	}

}
