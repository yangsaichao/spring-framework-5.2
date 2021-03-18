package com.shadow.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


public interface IndexDaon {
	@Select("select * from N")
	public List<Map<String,Object>> list();


	@Select("select * from N")
	public List<Map<String,Object>> xxxx();
}
