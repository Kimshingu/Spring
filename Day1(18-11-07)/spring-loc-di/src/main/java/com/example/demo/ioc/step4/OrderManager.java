package com.example.demo.ioc.step4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/*
 * 웹 프로그램을 컨트롤러, 서비스, 리파지토리로 나누어 관리한다.
 * 클래스를 빈 컨테이너에 등록할 때, 역할에 따라 @Component를 상속한
 * Service 애노테이션을 대신 사용하는 이유이다.
 * */ 

@Service("manager")
public class OrderManager {
	//빈 컨테이너에서 자료형이 CarMaker인 객체를 직접 변수에 할당한다.
	@Autowired
	@Qualifier("kiaMaker")
	private CarMaker maker;
	
	public OrderManager() {
	}
	
	
	public OrderManager(@Qualifier("kiaMaker") CarMaker maker) {
		super();
		this.maker = maker;
		}
	
	public void order() {
		
		
		Money money = new Money(2000);
		System.out.println("OrderManager # " + money.getAmount() + "원을 만든다.");

		Car car = maker.sell(money);
		System.out.println("OrderManager # 돈을주고 " + car.getName() + "를 산다.");
	}
	
	// 빈 컨테이너에서 id가 hyundaiMaker인 객체를 파라미터로 주입
//	@Resource(name="hyundaiMaker")
	public void setMaker(CarMaker maker) {
		this.maker = maker;
	}


	public CarMaker getMaker() {
		return maker;
	}
	
}
