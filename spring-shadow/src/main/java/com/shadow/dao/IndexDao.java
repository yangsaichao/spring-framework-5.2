package com.shadow.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


public interface IndexDao {
	@Select("select * from member111")
	public List<Map<String,Object>> list();


	@Select("select * from aaaaa")
	public List<Map<String,Object>> xxxx();
}
