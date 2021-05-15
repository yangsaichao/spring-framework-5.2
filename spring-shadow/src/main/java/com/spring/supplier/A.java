package com.spring.supplier;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "e")
public class A {

	public A(){
		log.debug("default a");
	}

	public A(String s){
		log.debug("string a");
	}


	public A(int i){
		log.debug("int a");
	}
}
