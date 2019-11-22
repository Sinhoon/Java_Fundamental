package java_20191121;

public class ArrayCopyDemo {
	public static void main(String[] args){
			String[] fruits = {"apple","banana","watermelon","peach"};
			
			String[] temp = new String[6];
			// fruits >> 원본배열
			// 0>> 원본배열의 취치, 즉 원본배열의 복사할 시작 위치
			// temp >> 복사항 배열
			// 2 >> 복사항 배열의 시작위치
			// 4 >> 원본배열의 4개 요소를 복사
			
			System.arraycopy(fruits,0,temp,2,4);
			//temp = {null,null,"apple","banana","watermelon","peach"};
			
			temp[0] = "blueberry";
			//temp = {"blueberry",null,"apple","banana","watermelon","peach"};
			temp[1] = "rasberry";
			//temp = {"blueberry","rasberry","apple","banana","watermelon","peach"};
			
			
			for (String f : temp){
					System.out.println(f);
			}
					
			String[] ref = fruits;
			ref[0] = "Jobs";
			
			System.out.println(fruits[0]);
			System.out.println(ref[0]);
			
			int[] a = {1,2,3,4};
			int[] b = {1,2,3,4};
			int[] c = b;
			System.out.println(a==b);
			System.out.println(c==b);	
		    
			
			
			
	}
}
