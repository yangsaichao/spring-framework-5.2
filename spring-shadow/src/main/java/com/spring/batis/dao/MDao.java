package com.spring.batis.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface MDao {
	@Select({"select * from m"})
	public List<Map<String,Object>> list();
}
