package kr.co.sist.service;

import org.json.simple.JSONObject;

public class AjaxService {
	public JSONObject createJson() {
		JSONObject json = new JSONObject();
		json.put("name", "���ü�");
		json.put("type", "����� �����");
		json.put("age", "27");
		
		return json;
	} // createJson
}
