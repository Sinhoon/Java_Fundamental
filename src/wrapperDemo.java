import java.util.ArrayList;

public class wrapperDemo {
	public static void main(String[] args) {
		// 1.4이전버전은 wrapper로 집어넣어야되나 autoboxing에 의해서 primitive datatype 도 가능
		ArrayList list = new ArrayList();
		list.add(new Integer(1));
		list.add(new Integer(2));
		Integer i1 = (Integer) list.get(0);
		Integer i2 = (Integer) list.get(1);
		int a = i1.intValue() + i2.intValue();
		System.out.println(a);

		// 1.5 이후
        // <Integer> 안쓰면 그냥 object 나와서 형변환해줘야됨
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		System.out.println(list.get(0));
		Integer i3 = list1.get(0);
		Integer i4 = list1.get(1);
		int a1 = i3+i4;

		String str = String.valueOf(10); // 10+""
		Integer.parseInt(str);
		
		char[] ad= new char[]{'1','2','3'};
		System.out.println(ad.length);
		String ag= "123";
		System.out.println(ag.length());
	
	}
}
