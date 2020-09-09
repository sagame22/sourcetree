package com.service;

import java.util.List;

import com.member.MemberVO;


public interface MemberService {
	
	public int getTotal();
	public void add(MemberVO bean);
	public void update(MemberVO bean);
	public void delete(int id);
    public MemberVO get(int id);
    public List<MemberVO> list();
    public MemberVO get( String name);
    public MemberVO get( String name,  String password);
    public boolean isExist(String name);
     
    
}
