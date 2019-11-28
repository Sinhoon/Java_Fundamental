package java_20191126.step1;

// 1. 요구사항 : 밀리 세컨드로 경과 시간을 만들어 주세요 ...

// 2. 요구사항 : 나노 세컨드롤 결과 시간을 만들어주세요 ... 
public class FootNanoStopWatch {
	long startTime;
	long endTime;
	long startNanoTime;
	long endNanoTime;
	public double getElapsedNanoTime(){
		return	(double)(endNanoTime-startNanoTime)/(double)1000000000;
	}
	public static void main(String[] args) {
		FootNanoStopWatch f = new FootNanoStopWatch();
		// 1970.1.1 기준 
		f.startNanoTime = System.nanoTime();
		for (long i = 0; i < 5_200_000_000l; i++) {

		}
		f.endNanoTime = System.nanoTime();
		double elapsedTime = f.getElapsedNanoTime();
		System.out.printf("경과시간 : %.3f",elapsedTime);
	}
}
