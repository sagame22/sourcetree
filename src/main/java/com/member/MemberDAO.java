package com.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MemberDAO {
	
	public int getTotal();
	public void add(MemberVO bean);
	public void update(MemberVO bean);
	public void delete(@Param("memberId") int id);
    public MemberVO get(@Param("memberId") int id);
    public List<MemberVO> list();
    public MemberVO get1(@Param("userName") String name);
    public MemberVO get2(@Param("userName") String name, @Param("password") String password);
}
