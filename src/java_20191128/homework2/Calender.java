package java_20191128.homework2;

public class Calender {
	private int[] monthArray = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private String[] dayWeek = { "일", "월", "화", "수", "목", "금", "토" };
	private int total;

	private int countday(int year, int month, int day) {
		total = (year - 1) * 365 + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400;
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			monthArray[1] = 29;
		} else {
			monthArray[1] = 28;
		}

		for (int i = 0; i < month - 1; i++) {
			total += monthArray[i];
		}
		total += day;
		return total % 7;
	}

	public void insert(int year) {
		for (int i = 1; i <= 12; i++) {
			insert(year, i);
		}
	}

	public void insert(int year, int month) {
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

	public void insert(int year, int month, int day) {
		String message = dayWeek[countday(year, month, day) % 7];
		System.out.printf("%d년 %d월 %d일 %s 입니다. \n", year, month, day, message);
	}

}
