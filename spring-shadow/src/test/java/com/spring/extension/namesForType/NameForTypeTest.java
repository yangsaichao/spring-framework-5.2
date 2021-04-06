package com.spring.extension.namesForType;

import com.spring.namesForType.bean.X;
import com.spring.namesForType.bean.Y;
import com.spring.namesForType.bean.Z;
import com.spring.namesForType.dao.B;
import com.spring.namesForType.dao.C;
import com.spring.namesForType.dao.GenericRepository;
import com.spring.namesForType.service.MemberService;
import com.spring.namesForType.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Type;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/3/3020:55
 */

@Slf4j(topic = "e")
public class NameForTypeTest {


	@Test
	public void testNormal(){
		AnnotationConfigApplicationContext context
				= new AnnotationConfigApplicationContext();
		context.register(X.class);
		context.getBeanFactory().getBeanNamesForType(X.class);
		context.refresh();
	}

	@Test
	public void testFb(){
		AnnotationConfigApplicationContext context
				= new AnnotationConfigApplicationContext();
		context.register(Y.class);

		//context.registerAlias("x","aliasx");
		context.refresh();
		String[] beanNamesForType = context.getBeanNamesForType(Z.class);
		for (String s : beanNamesForType) {
			log.debug("s:{}",s);
		}
	}

	@Test
	public void testRegisterSingleton(){
		AnnotationConfigApplicationContext context
				= new AnnotationConfigApplicationContext();
		context.getBeanFactory().registerSingleton("xx",new Z());
		//context.registerAlias("x","aliasx");
		context.refresh();
		String[] beanNamesForType = context.getBeanNamesForType(Z.class);
		for (String s : beanNamesForType) {
			log.debug("s:{}",s);
		}
	}



	@Test
	public void testAutowiredGeneric(){
		AnnotationConfigApplicationContext context
				= new AnnotationConfigApplicationContext();
		context.scan("com.spring.namesForType");

		context.refresh();

		MemberService memberService = context.getBean(MemberService.class);
		memberService.query();

		OrderService orderService = context.getBean(OrderService.class);
		orderService.query();

	}



	public void testFoo(){
		GenericRepository<?> genericRepository = new GenericRepository<B>();

		genericRepository = new GenericRepository<C>();
	}
}
