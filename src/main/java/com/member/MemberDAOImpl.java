package com.member;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class MemberDAOImpl implements MemberDAO {
	private SqlSessionTemplate sessionTemplate;
	
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}
	
	public int getTotal() {
		MemberDAO mapper = sessionTemplate.getMapper(MemberDAO.class);
		int total = mapper.getTotal();
		return total;
	}

	public void add(MemberVO bean) {
		MemberDAO mapper = sessionTemplate.getMapper(MemberDAO.class);
		mapper.add(bean);
		
	}

	public void update(MemberVO bean) {
		MemberDAO mapper = sessionTemplate.getMapper(MemberDAO.class);
		mapper.update(bean);
	}

	public void delete(int id) {
		MemberDAO mapper = sessionTemplate.getMapper(MemberDAO.class);
		mapper.delete(id);
		
	}

	public MemberVO get(int id) {
		MemberDAO mapper = sessionTemplate.getMapper(MemberDAO.class);
		MemberVO memberVO = mapper.get(id);
		return memberVO;
	}

	public List<MemberVO> list() {
		MemberDAO mapper = sessionTemplate.getMapper(MemberDAO.class);
		List<MemberVO> allMem = mapper.list();
		return allMem;
		
	}

	public MemberVO get1(String name) {
		MemberDAO mapper = sessionTemplate.getMapper(MemberDAO.class);
		MemberVO memberVO = mapper.get1(name);
		return memberVO;
	}

	public MemberVO get2(String name, String password) {
		MemberDAO mapper = sessionTemplate.getMapper(MemberDAO.class);
		MemberVO memberVO = mapper.get2(name, password);
		return memberVO;
	}

}
