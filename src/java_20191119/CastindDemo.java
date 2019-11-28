package java_20191119;

public class CastindDemo {
	public static void main(String[] args) {
		// overflow 발생 compile error
		// byte b1 = 250;
		
		byte b1 = (byte)250; // circuit
		System.out.println(b1);
		
		int i1 = (int)123.35; // cut
		System.out.println(i1);	
		
		double d1 = 123.35f; // auto casting
		
		byte b2 = 10;
		byte b3 = 20;
		// byte b4 = b1 + b2 ;   산술연산자 return int이기때문에 
		byte b4 = (byte)(b2 + b3);
		System.out.println(b4);	
		
		int a1 = 10_000_000;
		
		String arr = "1234-2142";
		String[] arrs = arr.split("-");
		System.out.println(arrs[0].split("")[0]);	
		
	}
}
