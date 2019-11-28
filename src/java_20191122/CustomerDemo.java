package java_20191122;
public class CustomerDemo {
	public static void main(String[] args) {
		Customer c1 = new Customer();
		c1.name = "신훈";
		c1.email = "loveshun77@naver.com";
		c1.phone = "01090506033";
		
		Customer c2 = new Customer();
		c2.name = "박종호";
		c2.email = "loveshun77@naver.com";
		c2.phone = "01090506033";

		Customer c3 = new Customer();
		c3.name = "박지현";
		c3.email = "loveshun77@naver.com";
		c3.phone = "01090506033";

		Customer[] c4 = {new Customer(), new Customer() , c3};	
		c4[0].name = "dd";
		int[] a = new int[]{1,2};
		a[0]=3;
		int[] b = {1,2};
		String[] c = new String[]{"11"};
		String[] d = new String[1];
		d[0]="2";
		Customer[] e = new Customer[1];
		e[0]= c3;
	}
}
