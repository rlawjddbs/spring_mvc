package kr.co.sist.controller.webparam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class ChainController {
	@RequestMapping(value="/chain/chain_a.do", method=GET)
	public String chainA(Model model) {
		
		String[] lunch= {"����ŷ","KFC","�Ƶ�����","�ҵ�����","������ġ"};
		model.addAttribute("lunch", lunch);
		return "forward:/chain/chain_b.do";
		// return�� forward�� redirect�� �پ������� ViewResolver�� ��ġ�� �ʰ�
		// ���ǵ� URL�� ���� ȣ���ϰ� �ȴ�.
	} // chainA
	
	@RequestMapping(value="/chain/chain_b.do", method=GET)
	public String chainB() { // ���� ȣ�� �� ���� �ְ�, A�� ���ļ� ȣ�� �� ���� �ִ�.
		return "chain/chain_b_result";
	} // chainB
} // class
