package com.example.demo.ioc.step3;

public class OrderManager {

	private CarMaker maker;
	
//	public OrderManager() {
//	}
	
	public OrderManager(CarMaker maker) {
		super();
		this.maker = maker;
		}
	
	public void order() {
		
		
		Money money = new Money(2000);
		System.out.println("OrderManager # " + money.getAmount() + "원을 만든다.");

		Car car = maker.sell(money);
		System.out.println("OrderManager # 돈을주고 " + car.getName() + "를 산다.");
	}
	public void setMaker(CarMaker maker) {
		this.maker = maker;
	}
}
