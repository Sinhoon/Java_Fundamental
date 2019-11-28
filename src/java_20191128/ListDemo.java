package java_20191128;

import java.util.ArrayList;

public class ListDemo {
	public static void main(String[] args) {
		ArrayList<Product> list= new ArrayList<Product>();
		list.add(new Product(1,"terra",2500));
		list.add(new Product(2,"신라면",1000));
		list.add(new Product(3,"진라면",3000));
		list.add(new Product(4,"열라면",3000));
		
		for (int i = 0; i < list.size(); i++) {
			Product temp= list.get(i);
			System.out.println(temp);
		}
		
		//모두삭제
		System.out.println(list.size());
		for (int i = 0; i < list.size() ; i++) {
			list.remove(i--);
		}

		for (Product product : list) {
			System.out.println(product);
		}
		
		
	}
}

class Product{
	int number;
	String name;
	double price;
	Product(int number,String name,double price){
		this.number = number;
		this.name   = name;
		this.price  = price;
		
	}
	@Override
	public String toString() {
		return "Product [number=" + number + ", name=" + name + ", price=" + price + "]";
	}
}