package homework;

import java.util.ArrayList;

public class Homework2 {
	public static void main(String[] args) {
		// 문자 reverse 하기
		// 1.input "abcd" => "dcba"
		// 2.input "abcde" => "edcba"
		String input = "abcd";
		char[] ch = input.toCharArray();
		char temp;

		for (int i = 0; i < ch.length / 2 - 1; i++) {
			temp = ch[i];
			ch[i] = ch[ch.length - (i + 1)];
			ch[ch.length - (i + 1)] = temp;
		}
		for (char res : ch) {
			System.out.print(res);
		}
		System.out.println();

		// 1-100가지 소수를 구하시오
		int maxrange = 100;
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 2; i <= maxrange; i++) {
			for (int j = 2; j <= i; j++) {
				if (j == i) {
					result.add(i);
				} else if (i % j == 0) {
					break;
				}

			}
		}
		for (int res : result) {
			System.out.print(res + " ");
		}

	}
}
