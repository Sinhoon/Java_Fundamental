package java_20191202;

public class ThreadDemo extends Thread{
	
	public ThreadDemo(String threadName) {
		super(threadName);
		// TODO Auto-generated constructor stub
	}

	public void run(){
		for (int i = 0; i < 1000; i++) {
			String threadName= Thread.currentThread().getName();
			System.out.printf("%d : %s \n",i,threadName);
		}
		
	}
	
	public static void main(String[] args) {
		// 쓰레드 객체 생성하는법
		// thread 클래스 상속받는다
		// run 메소드  오버라이딩한다.
		// 해당 객체생성
		// 해당 객체로 start 메소드를 호출한다.
		System.out.println("---------start--------");
		ThreadDemo s1 = new ThreadDemo("first thread");
		s1.start();
		ThreadDemo s2 = new ThreadDemo("second thread");
		s2.start();
		System.out.println("----------end----------");
		
	}
}
