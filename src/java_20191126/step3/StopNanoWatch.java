package java_20191126.step3;

public class StopNanoWatch {
	private long startNanoTime;
	private long endNanoTime;

	public void start() {
		startNanoTime = System.nanoTime();
	}

	public void stop() {
		endNanoTime = System.nanoTime();
	}

	public double getElapsedTime() {
		return (double) (endNanoTime - startNanoTime) / (double) 1000000000;
	}
}
