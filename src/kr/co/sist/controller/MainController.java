package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class MainController {
	@RequestMapping(value="/index.do",method=GET)
	public String indexPage() {
		
		// Model�� ���� DB��ȸ�� �̷�� ���� ��
		
		return "index";
	} // indexPage
	
	@RequestMapping(value="/request_get.do",method=GET)
	public String requestGet() {
		
		// Model�� ���� DB��ȸ�� �̷�� ���� ��
		
		return "get";
	} // requestGet
	
	@RequestMapping(value="/request_post.do",method=POST)
	public String requestPost() {
		
		// Model�� ���� DB��ȸ�� �̷�� ���� ��
		
		return "post";
	} // requestPost

	// �ϳ��� ��û(method)ó�� method�� GET/POST ����� ��� ó���ؾ� �� ��
	// method�� �迭�� ó���Ѵ�. method = { GET, POST }
	@RequestMapping(value="/request_all.do",method= {GET, POST})
	public String requestAll() {
		
		// Model�� ���� DB��ȸ�� �̷�� ���� ��
		
		return "all";
	} // requestPost
	
	
	
	
} // class
