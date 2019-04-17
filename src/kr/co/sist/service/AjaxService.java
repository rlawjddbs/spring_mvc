package kr.co.sist.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.json.simple.JSONObject;

public class AjaxService {
	public JSONObject createJson() {
		JSONObject json = new JSONObject();
		try {
			json.put("name", URLEncoder.encode("정택성", "UTF-8"));
			json.put("type", URLEncoder.encode("대담한 통솔자", "UTF-8"));
			json.put("age", 27);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return json;
	} // createJson
	
//	public static void main(String[] args) {
//		AjaxService as = new AjaxService();
//		System.out.println(as.createJson());
//	}
	
}
