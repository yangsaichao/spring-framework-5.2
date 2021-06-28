package com.spring.batis.service;

import com.spring.batis.dao.MDao;
import com.spring.batis.dao.XDao;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j(topic = "e")
public class MService {

	//需要的是一个bean---对象
	@Autowired
	MDao mDao;

	@Autowired
	XDao xDao;

	public void query(){
		System.out.println(mDao.list());
//		log.debug("====================================");
//		xDao.list();
	}
}
