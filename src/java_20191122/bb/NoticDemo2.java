package java_20191122.bb;

import java_20191122.aa.Notice;

// 서로다른  패키지의 클래스르 사용하기위해서 반드시 import

public class NoticDemo2 extends Notice {
	public static void main(String[] args) {
		NoticDemo2 nc = new NoticDemo2();
		nc.tiltle = "title";
		System.out.print(nc.a);
	}
}
