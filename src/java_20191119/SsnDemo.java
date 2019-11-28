package java_20191119;

public class SsnDemo {
	public static void main(String[] args) {
		String Num = "111111-1111118";
		String[] FullNum = Num.split("-");
		String[] FrontNum = FullNum[0].split("");
		String[] BackNum = FullNum[1].split("");

		// 1.
		int sum = 0;
		for(int i=2;i<14;i++){
			if(i<8){
				sum += Integer.parseInt(FrontNum[i-2])*i;
			}
				
			else if(i>=8){
				if(i<10){
					sum += Integer.parseInt(BackNum[i-8])*i;
				}
				else{
					sum += Integer.parseInt(BackNum[i-8])*(i-8);
				}
			}
		}
		System.out.println(sum);

		// 2.
		int res2 = 0;
		res2 = sum % 11;
		System.out.println(res2);
		
		// 3.
		int res3 = 0;
		res3 = 11 - res2;
		System.out.println(res3);		
		
		//4.
		int res4 = 0;
		res4 = res3 % 10;
		System.out.println(res4);		
		
		//5.
		if(BackNum[6] == Integer.toString(res4)){
			System.out.println("Á¤»ó ÁÖ¹Î");	
		}
		else{
			System.out.println("ºñÁ¤»ó ÁÖ¹Î");	
		}
	}
}
