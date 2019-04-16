package kr.co.sist.controller.webparam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.vo.SessionVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpSession;

@Controller
public class SessionController {

	
	// ��û�� Ư���̸����� ��� ó���Ϸ��� value="/�����̸�/��û.do"��
	// �������� ����Ѵ�.
	@RequestMapping(value="/session/use_session.do", method=GET)
	public String sessionForm() {
		return "session/session_form";
	} // sessionForm

	@RequestMapping(value="/session/session_param.do", method=GET)
	// �ԷµǴ� �Ű������� ���ǿ� �Ҵ��Ѵ�.
	public String sessionParam( SessionVO s_vo, HttpSession session) {
		System.out.println("-----param is-----"+s_vo.getName()+" / "+s_vo.getAddr());
		return "session/session_form";
	} // sessionForm
	
} // class
