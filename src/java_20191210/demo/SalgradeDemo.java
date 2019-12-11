package java_20191210.demo;

import java.util.ArrayList;

import java_20191210.dao.SalgradeDao;
import java_20191210.dto.SalgradeDto;

public class SalgradeDemo {
	public static void main(String[] args) {
		SalgradeDao s = SalgradeDao.getInstance();
		// System.out.println(s.insert(new SalgradeDto(6,10000,20000)));

/*		ArrayList<SalgradeDto> list2 = s.select();
		for (SalgradeDto dto : list2) {
			System.out.printf("%d %-10d %-15d %n", dto.getGrade(), dto.getLosal(), dto.getHisal());
		}*/
		
		SalgradeDto dto = s.select(4);
		System.out.printf("%d %-10d %-15d %n", dto.getGrade(), dto.getLosal(), dto.getHisal());

		
	}
}
