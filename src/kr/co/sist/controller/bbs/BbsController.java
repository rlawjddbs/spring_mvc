package kr.co.sist.controller.bbs;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.domain.Diary;
import kr.co.sist.domain.DiaryDetail;
import kr.co.sist.domain.DiaryReply;
import kr.co.sist.service.DiaryService;
import kr.co.sist.vo.DiaryVO;
import kr.co.sist.vo.ReplyVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

@Controller
public class BbsController {

	@RequestMapping(value="/diary/list.do", method=GET)
	public String diaryList(DiaryVO dv, Model model) {
		
		DiaryService ds = new DiaryService();
		int totalCount = ds.totalCount(); // 총 게시물의 수
		int pageScale = ds.pageScale(); // 한 화면에 보여줄 게시물의 수
		int totalPage = ds.totalPage(totalCount); // 전체 게시물을 보여주기 위한 페이지 수
		
		if( dv.getCurrentPage() == 0 ) { // web parameter의 값이 없을 때
			dv.setCurrentPage(1); // 1번부터 조회해야 하므로 1로 설정
		} // end if
		
		int startNum = ds.startNum(dv.getCurrentPage()); // 시작 번호
		int endNum = ds.endNum(startNum); // 끝 번호
		
		dv.setStartNum(startNum);
		dv.setEndNum(endNum);
		
		List<Diary> diaryList = ds.searchDiaryList(dv); // 리스트 목록 조회
		String indexList = ds.indexList(dv.getCurrentPage(), totalPage, "list.do");
		System.out.println("------------"+totalPage);
		
		System.out.println(indexList);
		
		model.addAttribute("diaryList", diaryList);
		model.addAttribute("indexList", indexList);
		model.addAttribute("pageScale", pageScale);
		model.addAttribute("currengPage", dv.getCurrentPage());
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPage", dv.getCurrentPage()); // param.currentPage 해도 되지만 해당 parameter가 없을 수도 있으므로
		
		return "diary/list";
	} // diaryList
	
	@RequestMapping(value="/diary/bbs_read.do", method=GET)
	public String bbsRead(int num, Model model) {
		
		DiaryService ds = new DiaryService();
		DiaryDetail dd = ds.searchBbs(num); // 원글의 내용을 조회
		List<DiaryReply> replyList = ds.searchReplyList(num);
		
		model.addAttribute("searchData", dd);
		model.addAttribute("replyList", replyList);
		
		return "diary/bbs_read";
	} // bbsRead
	
	@ResponseBody
	@RequestMapping(value="/diary/add_reply.do", method=GET)
	public String writeReply(ReplyVO r_vo) {
		JSONObject json = null;
		
		DiaryService ds = new DiaryService();
		json = ds.writeReply(r_vo);
		
		return json.toJSONString();
	} // writeReply
	
} // class
