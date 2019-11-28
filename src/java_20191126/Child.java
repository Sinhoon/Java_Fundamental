package java_20191126;

public class Child extends Parent{
	double height = 170.23;
	int age = 10;
	// overiding : 부모의 메서드를 재정의
	public void work(){
		System.out.println("child work()");
	}
	public void playGame(){
		System.out.println("child playgame()");
	}
}
