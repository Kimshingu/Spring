package com.example.demo;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {
	// 로그를 찍는다.
	// 인터페이스라서 pom.xml에 설정에 따라 다르다.
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class); // HomeController 관련된 로그를 찍는다.

	// http://localhost:8080/mvc/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	// C -> DS -> JSP, locale은 스프링이 준다. http 헤더정보 한국, 미국 등등...
	public String home(Locale locale, Model model) {
		// 로그의 중요도에 따라서 분류해서 관리하고자 메소드를 다르게 사용한다.
		logger.debug("Welcome home! The client locale is {}.", locale);
		logger.info("Welcome home! The client locale is {}.", locale);
		logger.trace("Welcome home! The client locale is {}.", locale);
		// 관리자의 이메일로 보내라라는 로직도 수행할 수 있다.
		logger.warn("Welcome home! The client locale is {}.", locale);
		logger.error("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		// 모델에 담겨져 있는 데이터는
		// DS에서 HttpServletRequest 객체에 옮겨진다.
		model.addAttribute("serverTime", formattedDate);

		return "home"; // home이라는 뷰에게 포워딩한다. 결국 home.jsp를 말한다.
	}

	// 요청방식을 생략하면 모든 요청방식에 대응한다.
	@RequestMapping(value = "/one", method = RequestMethod.GET)
	@ResponseBody // 리턴문자열은 뷰가 아니라 응답하는 데이터가 된다.
	public String one() {
		return "one";
	}
}
