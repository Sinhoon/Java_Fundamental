package java_20191210;

public class MemoryLoad {
	public static String name;
	static{
		name = "성영한";
		System.out.println("name : "+name);
		m();
	}
	public static void m(){
		System.out.println("MemoryLoad - m()");
	}
	public MemoryLoad(){
		System.out.println("MemoryLoad Constructor");
	}
}
