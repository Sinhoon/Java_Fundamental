package java_20191210.demo;

import java.util.ArrayList;

import java_20191210.dao.DeptDao;
import java_20191210.dto.DeptDto;
import java_20191210.dto.SalgradeDto;

public class DeptDemo {
	public static void main(String[] args) {
		DeptDao d = DeptDao.getInstance();
		// System.out.println(d.insert(new DeptDto(90,"DEATH","SEOUL")));
		System.out.println(d.update(new DeptDto(10, "ANALYSIS", "SEOUL")));
		// System.out.println(d.delete(60));

		ArrayList<DeptDto> list = d.select();
		for (DeptDto dto : list) {
			System.out.printf("%d %-10s %-15s %n", dto.getNo(), dto.getName(), dto.getLoc());
		}

/*		DeptDto dto = d.select(10);
		if (dto == null) {
			System.out.println("데이터 없습니다");
		} else {
			System.out.printf("%d %.5s %.10s %n", dto.getNo(), dto.getName(), dto.getLoc());

		}*/

	}
}
