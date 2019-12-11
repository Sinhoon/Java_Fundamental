package java_20191210.demo;

import java.util.ArrayList;

import java_20191210.dao.EmpDao;
import java_20191210.dto.EmpDto;

public class EmpDemo {
	public static void main(String[] args) {
		EmpDao e = EmpDao.getInstance();
/*		boolean isSuccess = e.insert(new EmpDto(9300,"hoon","dancer",7369,null,500,100,10));
		System.out.println(isSuccess);
		*/
		ArrayList<EmpDto> list = e.select(0,10);
		for (EmpDto dao : list){
			System.out.printf("%d %s %s %s %n",dao.getNo(),dao.getName(),dao.getJob(),dao.getHiredate());
		}
		
		EmpDto dao = e.select(8000);
		if(dao != null)
		System.out.printf("%d %s %s %n",dao.getNo(),dao.getName(),dao.getJob());
		else
		System.out.println("해당사원없음");
		
	}
}
