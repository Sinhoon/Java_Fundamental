package java_20191128;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class SetDemo {
	public static void main(String[] args) {
		// 데이터의 중복을 허용하지않고 순서가 없음
		TreeSet<String> set = new TreeSet<String>();
		//HashSet set = new HashSet();
		while(true){
			Integer random = (int) (Math.random()*45+1);
			set.add(String.valueOf(random));
			if(set.size()==6) break;
		}
		
		Iterator<String> i = set.iterator();
		
		while(i.hasNext()){
			String temp = i.next();
			System.out.print(temp + "\t");
		}
		
		
		HashSet<Test> s= new HashSet<Test>();
		s.add(new Test(10));
		s.add(new Test(20));
		s.add(new Test(10));
		
		System.out.println(s.size());

	}
}

class Test{
	int a;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Test other = (Test) obj;
		if (a != other.a)
			return false;
		return true;
	}
	public Test(int a) {
		super();
		this.a = a;
	}

}