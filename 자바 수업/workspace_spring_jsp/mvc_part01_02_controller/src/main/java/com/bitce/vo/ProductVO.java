package com.bitce.vo;

/**
 * ��ǰ ������ �����ϴ� ��ü
 */
public class ProductVO {

	private String name;
	private int price;
	
	public ProductVO() {
		System.out.println("�⺻ ������ ȣ��");
	}
	
	public ProductVO(String name, int price) {
		this.name = name;
		this.price = price;
		System.out.println("�Ű����� �ΰ��� ���� �޴� ������ ȣ��");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("setName ȣ�� - " + name);
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		System.out.println("setPrice ȣ�� - " + price);
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductVO [name=" + name + ", price=" + price + "]";
	}
	
}






