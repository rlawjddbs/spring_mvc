package kr.co.sist.service;

import org.json.simple.JSONObject;

public class AjaxService {
	public JSONObject createJson() {
		JSONObject json = new JSONObject();
		json.put("name", "정택성");
		json.put("type", "대담한 통솔자");
		json.put("age", "27");
		
		return json;
	} // createJson
}
