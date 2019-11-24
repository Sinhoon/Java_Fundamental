package homework;

public class Homework1 {
	public static void main(String[] args) {

		/*
		 * 달력 만들기 1. 1년 1월 1일은 월요일 2. 1년은 365일, 윤년은 366일 - 2월 29일 3. 윤년은 4년마다
		 * 발생하고 그중에서 100의 배수는 제외하고 400의 배수는 제외하지 않는다. 4. 2019년 12월 25일은 무슨 요일?
		 */
		int year = 2019;
		int month = 12;
		int day = 25;
		String message = null;
		int[] monthArray = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int total = (year - 1) * 365 + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400;

		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			monthArray[1] = 29;
		} else {
			monthArray[1] = 28;
		}

		for (int i = 0; i < month - 1; i++) {
			total += monthArray[i];
		}
		total += day;

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
}