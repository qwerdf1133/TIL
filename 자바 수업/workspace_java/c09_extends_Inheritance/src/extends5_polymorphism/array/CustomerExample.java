package extends5_polymorphism.array;

public class CustomerExample {
	
	public static void main(String[] args) {
		Customer[] customerList = new Customer[5];
		
		Customer customerLee = new Customer(10110,"이준호");
		Customer customerKim = new Customer(10111,"김규민");
		customerList[0] = customerLee;
		customerList[1] = customerKim;
		customerList[2] = new GoldCustomer(20110,"박종현");
		customerList[3] = new GoldCustomer(20111,"송앙엽");
		customerList[4] = new VIPCustomer(77777,"최기근",10110);
		
		System.out.println("== 고객 정보 ==");
		for(Customer c : customerList) {
			if(c != null) {
			System.out.println(c.toString());
			}
		}
		
		System.out.println("== 할인율과 보너스 포인트 계산 ==");
		int price = 100000; // 지불 금액
		for(Customer c : customerList) {
			if(c != null) {
				int cost = c.calcPrice(price);
				System.out.println(c.customerName+"님이 "+cost+"원 지불하였습니다.");
				System.out.println(c.toString());
			}
		}
	}

}
