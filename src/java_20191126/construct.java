package java_20191126;
import java_20191122.aa.Notice;


public class construct {
	public static void main(String[] args) {		
		// StaticInitalizationDemo s = new StaticInitalizationDemo(); // error
		System.out.print(StaticInitalizationDemo.age);
		Notice.a=20;
		
		Notice nc = new Notice();
		System.out.print(nc.a);
		
	}
}
