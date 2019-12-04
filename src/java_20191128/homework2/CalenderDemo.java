package java_20191128.homework2;

import java.util.Scanner;

public class CalenderDemo {
	public static void main(String[] args) {
		Calender s = new Calender();
		while (true) {
			try {
				boolean a = s.start();
				if(a==false){
					break;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.err.println("월을 제대로 적으세요 (1~12)");
			} catch (NumberFormatException e) {
				System.err.println("포맷을 제대로 적으세요 (yyyy/mm/dd)");
			} catch (Exception e) {
				System.err.println("일을 제대로 적으세요");
			}
		}
	}
}
