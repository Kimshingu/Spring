package com.example.demo.ioc.step1;

public class OrderManager {
	// 비즈니스 환경에서 사용하는 프로그램은 변화의 요구가 극심하다.
	// 현대자동자에게 주문하던 것을 기아자동차로 변경해야 하는 요구가 발생한다.
	HyundaiMaker maker = new HyundaiMaker();
	
	public void order() {
		
		// 상태정보를 취급하는 클래스는 메소드내에서 만들어서 사용하고 버린다.
		Money money = new Money(2000);
		System.out.println("OrderManager # " + money.getAmount() + "원을 만든다.");

		Car car = maker.sell(money);
		System.out.println("OrderManager # 돈을주고 " + car.getName() + "를 산다.");
	}
}
