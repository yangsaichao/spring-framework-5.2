package com.spring.aopnx.beans.impl;

import com.spring.aopnx.beans.CService;
import com.spring.aopnx.beans.DService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("d")
@Slf4j(topic = "e")
public class DServiceImpl implements DService {

	@Override
	public void aa() {

	}
}
