package java_20191120;

public class BreakDemo {
	public static void main(String[] args) {
		for (int i = 2; i < 10; i++) {
			outter : 
			for (int j = 0; j < 10; j++) {
				if(j==9 && i==4) break outter;
				System.out.printf("%d * %d = %d \n",i,j,i*j);
			}
		}
	}
}
