package java_20191128.homework2;

import java.util.ArrayList;
import java.util.Scanner;

public class Calender {
	private int[] monthArray = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private String[] dayWeek = { "일", "월", "화", "수", "목", "금", "토" };
	private int total;
	private String[] res;

	private int countday(int year, int month, int day) throws Exception {
		total = (year - 1) * 365 + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400;
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			monthArray[1] = 29;
		} else {
			monthArray[1] = 28;
		}

		for (int i = 0; i < month - 1; i++) {
			total += monthArray[i];
		}

		if (monthArray[month - 1] >= day) {
			total += day;
		} else {
			throw new Exception();
		}
		return total % 7;
	}

	private void insert(int year) throws Exception {
		for (int i = 1; i <= 12; i++) {
			insert(year, i);
		}
	}

	private void insert(int year, int month) throws Exception {
		int onedayWeek = countday(year, month, 1);

		System.out.println(month + "월");
		for (String i : dayWeek) {
			System.out.print(i + "\t");
		}

		System.out.println();

		for (int i = 0; i < onedayWeek; i++) {
			System.out.print("\t");
		}
		for (int i = 1; i <= monthArray[month - 1]; i++) {
			System.out.print(i + "\t");
			if ((i + onedayWeek) % 7 == 0) {
				System.out.println();
			}
		}
		System.out.print("\n\n");
	}

	private void insert(int year, int month, int day) throws Exception {
		String message = dayWeek[countday(year, month, day) % 7];
		System.out.printf("%d년 %d월 %d일 %s 입니다. \n", year, month, day, message);
	}

	private void cut() throws Exception {
		String[] bound = { " ", "/", "-" };
		int max = 0;
		String resinput = new Scanner(System.in).nextLine();
		ArrayList<String[]> result = new ArrayList<String[]>();
		for (int i = 0; i < bound.length; i++) {
			result.add(resinput.split(bound[i]));
		}
		for (int i = 1; i < bound.length; i++) {
			if (result.get(max).length <= result.get(i).length) {
				max = i;
			}
		}
		res = result.get(max);
	}

	public void start() throws Exception {
		cut();
		if (res.length == 3) {
			insert(Integer.parseInt(res[0]), Integer.parseInt(res[1]), Integer.parseInt(res[2]));
		} else if (res.length == 2) {
			insert(Integer.parseInt(res[0]), Integer.parseInt(res[1]));
		} else if (res.length == 1) {
			insert(Integer.parseInt(res[0]));
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}
	}

}
