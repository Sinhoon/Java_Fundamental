package homework;
//확인

public class Homework1 {
	private int year;
	private int month;
	private int day;
	private int[] monthArray = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private int total;

	public Homework1(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
		get();
	}

	public Homework1(int y, int m) {
		this(y, m, 0);
	}

	public Homework1(int y) {
		this(y, 0, 0);
	}

	public void set(int y, int m, int d) {
		year = y;
		month = m;
		day = d;
		get();
	}

	private int get() {
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
		return total;
	}

	public void print() {
		String message = null;
		switch (total % 7) {
		case 0:
			message = "일요일";
			break;
		case 1:
			message = "월요일";
			break;
		case 2:
			message = "화요일";
			break;
		case 3:
			message = "수요일";
			break;
		case 4:
			message = "목요일";
			break;
		case 5:
			message = "금요일";
			break;
		case 6:
			message = "토요일";
			break;
		default:
			System.out.printf("Error");
		}
		System.out.printf("%d년 %d월 %d일 %s 입니다.", year, month, day, message);

	}

	public static void main(String[] args) {
		Homework1 test = new Homework1(2019, 12, 25);
		// test.set(2019,12,25);
		test.print();
	}
}