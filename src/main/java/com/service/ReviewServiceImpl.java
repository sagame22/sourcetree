package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.review.ReviewDAO;
import com.review.ReviewVO;
@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	private ReviewDAO reviewDAOImpl;
	@Override
	public int getTotal(int pid) {
		int total = reviewDAOImpl.getTotal(pid);
		return total;
	}

	@Override
	public void add(ReviewVO bean) {
		reviewDAOImpl.add(bean);
		
	}

	@Override
	public void update(ReviewVO bean) {
		reviewDAOImpl.update(bean);
		
	}

	@Override
	public void delete(int id) {
		reviewDAOImpl.delete(id);
		
	}

	@Override
	public ReviewVO get(int id) {
		ReviewVO reviewVO = reviewDAOImpl.get(id);
		return reviewVO;
	}

	@Override
	public List<ReviewVO> list(int pid) {
		List<ReviewVO> list = reviewDAOImpl.list(pid);
		return list;
	}

	@Override
	public int getCount(int pid) {
		Integer count = reviewDAOImpl.getCount(pid);
		return count;
	}

	@Override
	public boolean isExist(String content, int pid) {
		int exist = reviewDAOImpl.isExist(content, pid);
		if(exist==0)
			return false;
		else 
			return true;
	}

	public void setReviewDAOImpl(ReviewDAO reviewDAOImpl) {
		this.reviewDAOImpl = reviewDAOImpl;
	}
	
	

}
