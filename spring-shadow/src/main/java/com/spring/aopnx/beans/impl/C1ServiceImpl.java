package com.spring.aopnx.beans.impl;

import com.spring.aopnx.beans.CService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j(topic = "e")
public class C1ServiceImpl implements CService {
	@Override
	public void defaultMethod() {
		log.debug("C 接口的Introductions 默认方法逻辑");
	}
}
