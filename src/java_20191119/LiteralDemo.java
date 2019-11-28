package java_20191119;

public class LiteralDemo {
	public static void main(String[] args){
		// byte 범위를 넘어서면 overflow 발생
		//byte b1 = 128;
		
		int a1 =128; 		// 10
		int a2 = 076;		// 8 
		int a3 = 0x123;		// 16
		int a4 = 0b10101;	// 2
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);
		
		// long literal 숫자뒤에 l , L 
		long l1 = 22000000l;
		
		// float literal 소수점뒤에  f , F
		float f1 = 123.43f;
		
		
		// double literal 소수점뒤에 d , D , 생략
		double d1 = 1234.56;
		
		// boolen literal true,false
		boolean isExisted = false;
		
		a1 = 10;
		d1 = 10.0;
		// primitive data type의 == 연산자 값만 비교함
		System.out.println(a1==d1);
		
		int first = 10;
		int second =first ;
		first = 20;
		System.out.print(first);
		System.out.print(second);
	}
}
