package com.example.demo.common.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

// 에노테이션에게 속성값을 전달할 떄, 속성키를 명시하지 않으면 자동으로 value 속성키가 사용된다.
//@RequestMapping("/")

// 클라이언트와 JSON 포맷의 문자열로 대화하는 클래스
// 1.  String을 리턴하면 그대로 클라이언트에게 전달된다.
// 2.  객체를 리턴하면 Jackson 라이브러리를 사용해서 JSON 포맷의 문자열로 변경한 후 클라이언트에게 전달된다.
@RestController
public class HomeRestController {
	// 연동기술로 URI를 사용한다.
	// 연동은 설정된 모든 속성이 만족해야만 가능하다.
	//http://localhost:9090/example/?plain
	@RequestMapping(value={"/"}, params="plain")
	public String homeForPlain(){
		return "welcome home";
	}
	
	// http://localhost:9090/example/?json
	@RequestMapping(value={"/"}, params="json")
	public String homeForJson(){
		// 수동으로 작성한 JSON 포맷의 문자열을 리턴한다.
		return "{\"message\" : \"welcome home\"}";
	}
	
	private Map<String, Object> map;
	
	@PostConstruct
	public void init() {
		map = new HashMap<>();
		map.put("id", 10);
		map.put("name","Tom");
		map.put("email", "love@is gone.com");
	}
	
	@RequestMapping(value={"/"}, params="json2")
	public Object exampleObjectToJson(){
		// 리턴값이 객체인 경우, 스프링이 JSON 포맷의 문자열로 변경하여
		// 클라이언트에게 전달한다.
		return map;
	}
	
	Gson gson = new Gson();
	
	@RequestMapping(value={"/"}, params="json3")
	public String exampleUsingGsonToJson(){
		
		return gson.toJson(map);
	}
}



