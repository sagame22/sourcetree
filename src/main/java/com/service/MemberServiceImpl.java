package com.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.member.MemberDAO;
import com.member.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO memberDAOImpl;
	
	public int getTotal() {
		int total = memberDAOImpl.getTotal();
		return total;
	}

	public void setMemberDAOImpl(MemberDAO memberDAOImpl) {
		this.memberDAOImpl = memberDAOImpl;
	}

	public void add(MemberVO bean) {
		memberDAOImpl.add(bean);
		
	}

	public void update(MemberVO bean) {
		memberDAOImpl.update(bean);		
	}

	public void delete(int id) {
		memberDAOImpl.delete(id);
	}

	public MemberVO get(int id) {
		MemberVO memberVO = memberDAOImpl.get(id);
		return memberVO;
	}

	public List<MemberVO> list() {
		List<MemberVO> list = memberDAOImpl.list();
		return list;
	}

	public MemberVO get(String name) {
		MemberVO get1 = memberDAOImpl.get1(name);
		return get1;
	}

	public MemberVO get(String name, String password) {
		MemberVO get2 = memberDAOImpl.get2(name, password);
		return get2;
	}
	public boolean isExist(String name) {
        MemberVO member = get(name);
        return member!=null;
 
    }

}

