package java_20191126;

public class CallByRefDemo {
	public static void change(int a,int b[]){
		a = 20;
		b[3]=400;
	}
	public static void main(String[] args) {
		int a = 10;
		int b[]= {1,2,3,4};
		System.out.println(a);
		System.out.println(b[3]);
		
		change(a,b);
		
		System.out.println(a);
		System.out.println(b[3]);		
	}
}
