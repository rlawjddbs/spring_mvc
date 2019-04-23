package kr.co.sist.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import kr.co.sist.domain.Diary;
import kr.co.sist.domain.DiaryDetail;
import kr.co.sist.domain.DiaryReply;
import kr.co.sist.domain.Notice;
import kr.co.sist.vo.DiaryVO;
import kr.co.sist.vo.ReplyVO;

@Component
public class MyBatisDAO {

	private static MyBatisDAO mb_dao;
	private SqlSessionFactory ssf = null;
	
	private MyBatisDAO() {
	} // MyBatisDAO
	
	public static MyBatisDAO getInstance() {
		if(mb_dao == null) {
			mb_dao = new MyBatisDAO();
		} // end if
		return mb_dao;
	} // getInstance
	
	public synchronized SqlSessionFactory getSessionFactory() {
		if(ssf == null) {
			org.apache.ibatis.logging.LogFactory.useLog4JLogging();
			
			Reader reader = null;
			try {
				// 1. 설정용 xml 로딩
				reader = Resources.getResourceAsReader("kr/co/sist/dao/mybatis_config.xml");
				// 2. MyBatis Framework 생성
				SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
				// 3. DB와 연동된 객체 받기
				ssf = ssfb.build(reader);
				if( reader != null ) {
					reader.close();
				} // end if
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // end if
		return ssf;
	} // getSessionFactory
	
	public List<Notice> selectMainNotice(){
		SqlSession ss = getSessionFactory().openSession();
		List<Notice> list = ss.selectList("noticeList");
		ss.close();
		return list;
	} // selectMainNotice
	
	/**
	 * 총 게시물의 수 얻기
	 * @return
	 */
	public int selectTotalCount() {
		SqlSession ss = getSessionFactory().openSession();
		int cnt = ss.selectOne("diaryTotalCnt");
		ss.close();
		return cnt;
	} // selectTotalCount
	
	public List<Diary> selectList(DiaryVO dv){
		List<Diary> list = null;
		SqlSession ss = getSessionFactory().openSession();
		list = ss.selectList("diaryList", dv);
		ss.close();
		return list;
	} // selectList
	
	public DiaryDetail selectDiaryDetail(int num) {
		DiaryDetail dd = null;
		SqlSession ss = getSessionFactory().openSession();
		dd = ss.selectOne("diaryDetail", num);
		ss.close();
		return dd;
	} // selectDiaryDetail
	
	public List<DiaryReply> selectReplyList(int num){
		List<DiaryReply> list = null;
		SqlSession ss = getSessionFactory().openSession();
		list = ss.selectList("diaryReply", num);
		ss.close();
		return list;
	} // selectReplyList
	
	public int insertReply(ReplyVO r_vo) {
		int cnt = 0;
		SqlSession ss = getSessionFactory().openSession();
		cnt = ss.insert("insertReply", r_vo);
		if( cnt == 1 ) {
			ss.commit();
		} // end if
		ss.close();
		return cnt;
	} // insertReply
	
} // class
