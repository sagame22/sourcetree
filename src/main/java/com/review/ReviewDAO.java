package com.review;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ReviewDAO {

	public int getTotal(@Param("pid")int pid);
	public void add(ReviewVO bean);
	public void update(ReviewVO bean);
	public void delete(@Param("id")int id);
	public ReviewVO get(@Param("id")int id);
	public List<ReviewVO> list(@Param("pid")int pid);
	public int getCount(@Param("pid")int pid);
	public int isExist(@Param("content")String content, @Param("pid")int pid);
	
}
