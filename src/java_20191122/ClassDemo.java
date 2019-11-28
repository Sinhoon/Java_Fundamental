package java_20191122;

public class ClassDemo {
	public static void main(String[] args) {
		String res = "abc";
		String[] res2;
		String[] res3;
		res2 = res.split("");
		res3 = new String[res2.length];

		for (int i = res2.length - 1; i >= 0; i--) {
			res3[res2.length - i - 1] = res2[i];
		}
		for (String a : res3) {
			System.out.printf(a);
		}

	}
}
