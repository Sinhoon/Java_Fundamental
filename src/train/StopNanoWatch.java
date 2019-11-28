package train;

public class StopNanoWatch extends StopWatch {
	private void start() {
		startTime = System.nanoTime();
	}

	private void end() {
		endTime = System.nanoTime();
	}

	private double count() {
		return (double) (endTime - startTime) / (double) 1000000000;
	}

	public void run() {
		start();
		for (long i = 0; i < 5_000_000_000l; i++) {

		}
		end();
		System.out.println(count());
	}

}
