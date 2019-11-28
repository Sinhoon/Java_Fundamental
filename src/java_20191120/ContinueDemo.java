package java_20191120;

public class ContinueDemo {
	public static void main(String[] args) {
		outter: for (int i = 2; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				if (j == 5)
					continue outter;
				System.out.printf("%d * %d = %d \n", i, j, i * j);
			}
		}
	}
}