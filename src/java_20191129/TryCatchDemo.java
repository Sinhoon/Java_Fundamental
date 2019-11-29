package java_20191129;

public class TryCatchDemo {
	public static double getAvg(int k , int e){
		int sum = k+ e;
		double avg = (double)sum/(double)2;
		return avg;
	}
	public static void main(String[] args) {
		try{
			int k = Integer.parseInt(args[0]);
			int e = Integer.parseInt(args[1]);
			
		}
		catch(NumberFormatException e){
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("문자말고 숫자");
		}
	}
}
