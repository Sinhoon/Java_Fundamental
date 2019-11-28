package train;

public class StopMilliWatch extends StopWatch {
	private void start() {
		startTime = System.currentTimeMillis();
	}

	private void end() {
		endTime = System.currentTimeMillis();
	}

	private double count() {
		return (double) (endTime - startTime) / (double) 1000;
	}

	public void run() {
		start();
		for (long i = 0; i < 5_000_000_000l; i++) {

		}
		end();
		System.out.println(count());
	}
}
