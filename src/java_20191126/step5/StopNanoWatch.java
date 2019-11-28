package java_20191126.step5;

import java_20191126.step4.StopMilliWatch;

public class StopNanoWatch extends StopWatch {
	private void start() {
		startTime = System.nanoTime();
	}

	private void stop() {
		endTime = System.nanoTime();
	}

	private double getElapsedTime() {
		return (double) (endTime - startTime) / (double) 1000000000;
	}

	public void run() {
		start();
		for (long i = 0; i < 5_200_000_000l; i++) {

		}
		stop();
		double elapsedTime = getElapsedTime();
		System.out.printf("경과시간 : %.3f ", elapsedTime);
	}
}
