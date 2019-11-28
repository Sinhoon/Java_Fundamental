package java_20191119;

public class WhileDemo {
	public static void main(String[] args) {
		int sum = 0;
		int i = 1;
		while(i <= 100){
			sum += i;
			i++;
		}
		System.out.printf("1부터 100까지 합은 %d.\n",sum);
		
		int first = 2;
		while(first < 10){
			int second = 1;
			while(second <10){
				System.out.printf("%d.",first*second);
				second++;
			}
			System.out.printf("\n");
			first++;
		}
	}
}
