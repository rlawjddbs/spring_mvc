package kr.co.sist.controller.webparam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.vo.SessionVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpSession;

@Controller
public class SessionController {

	
	// 요청을 특정이름으로 묶어서 처리하려면 value="/묶을이름/요청.do"의
	// 형식으로 사용한다.
	@RequestMapping(value="/session/use_session.do", method=GET)
	public String sessionForm() {
		return "session/session_form";
	} // sessionForm

	@RequestMapping(value="/session/session_param.do", method=GET)
	// 입력되는 매개변수를 세션에 할당한다.
	public String sessionParam( SessionVO s_vo, HttpSession session) {
		System.out.println("-----param is-----"+s_vo.getName()+" / "+s_vo.getAddr());
		return "session/session_form";
	} // sessionForm
	
} // class
