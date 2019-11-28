package java_20191126;

public class ChildDemo {
	public static void main(String[] args) {
		Parent p = new Child();  // 보통 parent 는 추상클래스 인터페이스 
		p.work();
		System.out.print(p.age);
		}
}
