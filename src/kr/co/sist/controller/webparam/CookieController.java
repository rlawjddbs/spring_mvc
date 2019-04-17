package kr.co.sist.controller.webparam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.service.CookieService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CookieController {

	@RequestMapping(value="cookie/read_cookie.do", method=GET)
	public String readCookie(HttpServletRequest request, Model model) {
		
		// 1. ��Ű�� �б�
		Cookie[] cookies = request.getCookies();
		model.addAttribute("rCookie",cookies); // �о���� ��� ��Ű�� JSP���� ����� �� �ִ�.  

		if( cookies != null ) { // �о���� ��Ű�� �����Ѵٸ�
			
			CookieService cs = new CookieService();
			
			Cookie tempCookie = null;
			int cnt=0;
			for(int i=0; i < cookies.length; i++) {
				tempCookie=cookies[i];
				if("JSESSIONID".equals(tempCookie.getName())) {
					cnt++;
				} // end if
				
				if("name".equals(tempCookie.getName())) {
					model.addAttribute("name", cs.nameMsg(tempCookie.getValue()));
					cnt++;
				} // end if
				if("age".equals(tempCookie.getName())) {
					model.addAttribute("birth", cs.birth(Integer.parseInt(tempCookie.getValue())));
					cnt++;
				} // end if
			} // end for
			
			if(cnt == 1) { // JSESSIONID�� �����ϴ� ���
				model.addAttribute("rCookie", null);
			} // end if
			
		} // end if
		
		
		return "cookie/read_cookie";
	} // readCookie
	
	@RequestMapping(value="cookie/add_cookie.do", method=GET)
	public String addCookie(HttpServletResponse response, Model model) {
		// 1. ��Ű ����
		Cookie nameCookie = new Cookie("name", "seonui.gong");
		Cookie ageCookie = new Cookie("age", "28");
		
		// 2. ��Ű �����ð� ����
		// ������ ���� �� �����ð��� ����ȴ�.
		nameCookie.setMaxAge(60*2);
		ageCookie.setMaxAge(60*2);
		// 3. ��Ű �ɱ�
		response.addCookie(nameCookie);
		response.addCookie(ageCookie);
		
		model.addAttribute("cookieFlag",true);
		model.addAttribute("msg","������ ��ǻ�ͷ� ��Ű ����");
		
		return "cookie/read_cookie";
	} // addCookie
	
	@RequestMapping(value="/cookie/remove_cookie.do", method=GET)
	public String removeCookie(HttpServletResponse response, Model model) {
		// 1. ���� �̸��� ��Ű�� �����Ѵ�.
		Cookie nameCookie = new Cookie("name", "");
		Cookie ageCookie = new Cookie("age", "");
		
		// 2. ��Ű �����ð� ������ 0���� �Ѵ�.
		// ������ ���� �� �����ð��� ����ȴ�.
		nameCookie.setMaxAge(0);
		ageCookie.setMaxAge(0);
		// 3. ��Ű �ɱ�
		response.addCookie(nameCookie);
		response.addCookie(ageCookie);
		
		model.addAttribute("cookieFlag",true);
		model.addAttribute("msg","��Ű�� ���� �Ǿ����ϴ�.");
		
		// 2. �����ð��� 0���� ����
		// 3. ��Ű�� �ɴ´�.
		return "cookie/read_cookie";
	} // remove Cookie
	
	///////////////////////////////// @CookieValue ��� //////////////////////////////////////
	@RequestMapping(value="/cookie/an_read_cookie.do", method=GET)
	public String anReadCookie(
		@CookieValue(value="an_name", defaultValue="")String an_name,
		@CookieValue(value="an_age", defaultValue="")String an_age, Model model) {
			System.out.println("��Ű �� �̸� : "+an_name);
			System.out.println("��Ű �� ���� : "+an_age);
			
			model.addAttribute("an_name", an_name);
			model.addAttribute("an_age", an_age);
			
			return "cookie/an_read_cookie";
	} // anReadCookie

	@RequestMapping(value="/cookie/an_add_cookie.do", method=GET)
	public String anAddCookie(HttpServletResponse response) {
			// 1. ��Ű ����
			Cookie nameCookie = new Cookie("an_name", "jungyun.kimg");
			Cookie ageCookie = new Cookie("an_age", "31");
			
			// 2. ��Ű �����ð� ����
			// ������ ���� �� �����ð��� ����ȴ�.
			nameCookie.setMaxAge(60*60);
			ageCookie.setMaxAge(60*60);
			// 3. ��Ű �ɱ�
			response.addCookie(nameCookie);
			response.addCookie(ageCookie);
		
		return "cookie/an_cookie_result";
	} // anReadCookie

	
	
} // class
