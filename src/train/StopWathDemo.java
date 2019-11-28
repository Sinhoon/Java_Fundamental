package train;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class StopWathDemo {
	static Collection syncronizedCollection(Collection c){
		return c;
	}
	
	public static void execute(StopWatch s) {
		s.run();
	}

	public static void main(String[] args) {
		StopWatch s1 = new StopNanoWatch();
		execute(s1);
		StopWatch s2 = new StopMilliWatch();
		execute(s2);
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(3);
		a.add(14);
		a.add(12);
		Collections.sort(a);
		Collection b = new ArrayList<>();
		b= syncronizedCollection(a);
		System.out.print(b);
	
	}
	
}
