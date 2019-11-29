package java_20191128.homework;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberManagementDemo {
	private ArrayList<Member> list;

	public MemberManagementDemo() {
		list = new ArrayList<Member>();
	}

	public void print() {
		System.out.println("************************************************");
		System.out.println("1)insert 2)update 3)delete 4)search 5)show 6)exit");
		System.out.println("****"
				+ "********************************************");

	}

	public String console(String msg) {
		System.out.print(msg);
		Scanner sc = new Scanner(System.in);
		return sc.next();

	}

	public void run(String index) {
		if (index.equals("1")) {
			insert();
		} else if (index.equals("2")) {
			update();
		} else if (index.equals("3")) {
			delete();
		} else if (index.equals("4")) {
			search();
		} else if (index.equals("5")) {
			show();
		} else if (index.equals("6")) {
			System.out.println("종료");
		} else {
			System.out.println("사요나라");
		}
	}

	public void insert() {
		String id = console("아이디>");
		String name = console("이름>");

		Member m = new Member(id, name);
		list.add(m);

		System.out.printf("총 회원은  %d 명입니다. %n", list.size());
		choice();
	}

	public void update() {
		String id = console("아이디>");
		int count = list.size();
		for (Member i : list) {
			count -= 1;
			if (i.getId().equals(id)) {
				i.setName(console("새로운 이름>"));
				System.out.println("<update member>");
				System.out.println(i);
				show();
				break;
			} else if (count == 0) {
				System.out.println("수정할 아이디가 없습니다.");
				choice();
			}
		}

	}

	public void delete() {
		String id = console("아이디>");
		int count = list.size();
		for (Member i : list) {
			count -= 1;
			if (i.getId().equals(id)) {
				System.out.println("<delete member>");
				System.out.println(i);
				list.remove(i);
				show();
				break;
			} else if (count == 0) {
				System.out.println("삭제할 아이디가 없습니다.");
				choice();
			}
		}
	}

	public void search() {
		String id = console("아이디>");
		int count = list.size();
		for (Member i : list) {
			count -= 1;
			if (i.getId().equals(id)) {
				System.out.println(i);
				break;
			} else if (count == 0) {
				System.out.println("검색한 결과가 없습니다.");
			}
		}
		choice();
	}

	public void show() {
		System.out.println("<all member>");
		for (Member i : list) {
			System.out.println(i);
		}
		choice();
	}

	public void choice() {
		print();
		String index = console("번호를 선택하세요 >");
		run(index);
	}

	public static void main(String[] args) {
		MemberManagementDemo m1 = new MemberManagementDemo();
		m1.print();
		String index = m1.console("번호를 선택하세요>");
		m1.run(index.trim());
	}
}
