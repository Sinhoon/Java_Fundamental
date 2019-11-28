package java_20191119;

public class ForDemo {
	public static void main(String[] args) {
		String str = "hello";
		int a1 = 10;
		int a2 = 20;
		float d1 = 12.4567f;
		System.out.printf("%s %d %.4f \n", str, a1, d1);
		System.out.println(str + "," + a1 + "," + d1);

		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
		System.out.printf("1~100 ÇÕ = %d \n", sum);

		for (int i = 2; i < 10; i++) {
			System.out.printf("%d ´Ü \n", i);
			for (int j = 1; j < 10; j++) {
				System.out.printf("%d * %d  = %d \n", i, j, i * j);
			}
		}
		
		for (int i = 9; i > 1; i--) {
			System.out.printf("%d ´Ü \n", i);
			for (int j = 1; j < 10; j++) {
				System.out.printf("%d * %d  = %d \n", i, j, i * j);
			}
		}
		
		for (int i = 5; i >= 1; i--){
			for (int j = i; j > 0; j--){
				System.out.printf("*");
			}
			System.out.printf("\n");
		}
	}
}