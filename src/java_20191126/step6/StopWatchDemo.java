package java_20191126.step6;
public class StopWatchDemo {
	public static void execute(StopWatch s){
		s.run();
	}

	public static void main(String[] args) throws Exception {
		StopMilliWatch s1 = new StopMilliWatch();
		execute(s1);	
		StopNanoWatch s2 = new StopNanoWatch();
		execute(s2);
		StopMicroWatch s3 = new StopMicroWatch();
		execute(s3);	
		
/*		String input = args[0];
		input = "java_20191126.step5."+input;
		// java reflection 문자열(패키지명 + 클래스명)을 통해 객체 생성
		StopWatch s = (StopWatch)Class.forName(input).newInstance();
		execute(s);*/
	}
}