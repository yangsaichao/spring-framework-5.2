package com.spring.earlyBean.bean;

import com.spring.earlyBean.anno.Shadow;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
@Log4j2
@Shadow
public class B implements I{


	public void printf() {
		log.info("bbbbb");
	}
}
