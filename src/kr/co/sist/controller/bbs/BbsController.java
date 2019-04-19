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
		int totalCount = ds.totalCount(); // �� �Խù��� ��
		int pageScale = ds.pageScale(); // �� ȭ�鿡 ������ �Խù��� ��
		int totalPage = ds.totalPage(totalCount); // ��ü �Խù��� �����ֱ� ���� ������ ��
		
		if( dv.getCurrentPage() == 0 ) { // web parameter�� ���� ���� ��
			dv.setCurrentPage(1); // 1������ ��ȸ�ؾ� �ϹǷ� 1�� ����
		} // end if
		
		int startNum = ds.startNum(dv.getCurrentPage()); // ���� ��ȣ
		int endNum = ds.endNum(startNum); // �� ��ȣ
		
		dv.setStartNum(startNum);
		dv.setEndNum(endNum);
		
		List<Diary> diaryList = ds.searchDiaryList(dv); // ����Ʈ ��� ��ȸ
		String indexList = ds.indexList(dv.getCurrentPage(), totalPage, "list.do");
		System.out.println("------------"+totalPage);
		
		System.out.println(indexList);
		
		model.addAttribute("diaryList", diaryList);
		model.addAttribute("indexList", indexList);
		model.addAttribute("pageScale", pageScale);
		model.addAttribute("currengPage", dv.getCurrentPage());
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPage", dv.getCurrentPage()); // param.currentPage �ص� ������ �ش� parameter�� ���� ���� �����Ƿ�
		
		return "diary/list";
	} // diaryList
	
	@RequestMapping(value="/diary/bbs_read.do", method=GET)
	public String bbsRead(int num, Model model) {
		
		DiaryService ds = new DiaryService();
		DiaryDetail dd = ds.searchBbs(num); // ������ ������ ��ȸ
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
