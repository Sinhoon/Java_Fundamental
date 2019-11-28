package java_20191126;

public class ShapeDemo {
	public static void run(Shape s){
		s.draw();
	}
	public static void main(String[] args) {
		// 추상클래스는 객체를 생성할수 없습니다.
		Shape s1 = new Rectangle();
		s1.draw();
		Shape s2 = new Triangle();
		s2.draw();
		run(s1);
		run(s2);
		
	}

}
