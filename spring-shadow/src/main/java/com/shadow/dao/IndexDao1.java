package com.shadow.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


public interface IndexDao1 {
	@Select("select * from zl")
	public List<Map<String,Object>> list();


	@Select("select * from zl")
	public List<Map<String,Object>> xxxx();
}
