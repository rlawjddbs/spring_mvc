package kr.co.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.MyBatisDAO;
import kr.co.sist.domain.Notice;
import kr.co.sist.vo.DiaryVO;

@Component
public class MainService {
	
	@Autowired
	private MyBatisDAO mb_dao;
	
	public List<Notice> noticeList(){
		List<Notice> list = mb_dao.selectMainNotice();
		
		return list;
	} // noticeList
	
} // class
