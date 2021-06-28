package com.spring.batis.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface XDao {
	@Select({"select * from x"})
	public List<Map<String,Object>> list();
}
