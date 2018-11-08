package com.example.demo.proxy.step2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test { // Client
	   /*
	    * 빈 컨테이너에 Hellolmpl 객체가 등록되었다면
	    * Client는 Hellolmpl 객체를 주입 받아서 사용하게 되고
	    * 핵심 로직만 수행될 것이다
	    * 
	    * 빈 컨테이너에 Proxy 객체가 등록되었다면
	    * Client 는 Proxy 객체를 주입 받아서 사용하게 되고
	    * 핵심로직과 핵심로직 앞두로 부가로직도 같이 수행될 것이다
	    * 
	    * 결국. 빈 컨테이너 환경설정에서 Client가 사용할 로직을
	    * 결정할 수 있다. 변화하는 부분을 클래스에서 추출하여
	    * 빈 컨테이너 환경설정으로 처리할 수 있게 되었다
	    * 
	    */

	@Autowired
	private Hello hello;
	public void order() {
		hello.say();
	}
	public static void main(String[] args) {
		
		/*
		 * Client가 Service가 가져야 할 로직을 갖고 있으면 SRP 원칙에 위반된다.
		 * 그래서 줄 긋는 로직을 서비스 역할의 객체로 옮겼습니다.
		 * 그랬더니 항상 같은 로직을 제공하게 됩니다.
		 * - 클라이언트는 Hello! 만 출력하거나
		 * - 앞 뒤로 줄을 그으면서 Hello!를 출력하고 싶습니다.
		 *  어떻게 해결해야 할까요?
		 */
		
		Hello hello = new HelloImpl(); // Service
		hello.say();
		
		System.out.println();
		
		Hello proxy = new Proxy(hello);
		proxy.say();
	}
}
