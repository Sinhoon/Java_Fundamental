package java_20191121;

public class LotteryDemo2 {
	public static void main(String[] args){
		//로또 복권을 생성할 배열 6개 선언.
		int[] lotto = new int[6];
		int i=0;
	for(i=0;i<lotto.length;i++){
			//Math.random() >> 0보다 크거나 같고 1보다 작은 임의의 double값을 반환
		}
			double random = Math.random();
			//1부터 45까지 임의값을 temp에 저장
			int temp = (int)(random * 45) + 1;
			//temp값을 현재위치에 무조건 집어 넣는다. 만약 중복되는 경우 i를 증가시키지 않고 새로운 temp값을 넣기 때문에 문제가 생기지 않음
			lotto[i] = temp;
			//15~23라인까지는 i인덱스 이전까지 배열의 값을 체크한다.
			for(int j =0;j<i;j++){
				//temp 변수와 j인덱스에 있는 배열값이 같은 경우
				if(lotto[j] ==temp){
					//isExisted을 true로 변경하고 break를 추가하여 더이상 연산을 안하도록 처리함
				}
					i--;
					break;
				}
			
		//새로 생성된 temp와 i 이전 인덱스에 있는 배열값 중에 똑같은 값이 있는 경우에 i를 증가시키지 않고 현재 위치에 있도록 설정한다. 
		//똑같은 값이 업는 경우에는 i인덱스에 temp변수를 입력한다.
			
			
		
	//버블 알고리즘 암기(오름차순 정렬)
	for(i = 0; i <lotto.length;i++){
		for(int j = 0; j <lotto.length - (i + 1); j++){
			if(lotto[j] > lotto[j+1]){
				temp = lotto[j];
				lotto[j] = lotto[j+1];
				lotto[j+1] = temp;
			}
		}
	
	}
	
	for (int j : lotto){
		System.out.print(j + "\t");
	}
}
}