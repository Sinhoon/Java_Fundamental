package homework;

public class Homework2 {
	public static void main(String[] args) {
		// 문자 reverse 하기
		// 1.input "abcd"  => "dcba"
		// 2.input "abcde" => "edcba"
		
		String input = "abcd";
		char[] ch = input.toCharArray();
		char temp ;

		for (int i=0;i<ch.length/2 -1 ;i++){
			temp = ch[i];
			ch[i] = ch[ch.length-(i+1)]; 
			ch[ch.length-(i+1)] =temp; 
		}
		for(char res:ch){
			System.out.print(res);
		}
		
		
		// 1-100가지 소수를 구하시오
		
		int[] result = new int[100];
		int num =0;
		for(int i=2;i<=100;i++){
			for(int j=2;j<=i;j++){
				if(j==i){
					System.out.println(i);
				}
				if(i%j == 0){
					break;
				}

			}
		}

		
		
	}
}
