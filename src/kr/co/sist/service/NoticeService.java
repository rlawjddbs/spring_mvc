package kr.co.sist.service;

import java.util.List;

import kr.co.sist.dao.MyBatisDAO;
import kr.co.sist.domain.Notice;

public class NoticeService {

	public List<Notice> searchMainNotice(){
		List<Notice> list = null;
		
		MyBatisDAO mb_dao = MyBatisDAO.getInstance();
		list = mb_dao.selectMainNotice();
		// 공지사항은 15자까지만 보여준다.
		for(Notice temp : list ) {
			if( temp.getSubject().length() > 15) {
				temp.setSubject(temp.getSubject().substring(0, 14)+"...");
			} // end if
		} // end for
		
		return list;
	} // searchMainNotice
	
	public static void main(String[] args) {
		NoticeService ns = new NoticeService();
		ns.searchMainNotice();
	} // main
} // class
