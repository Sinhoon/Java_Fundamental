package java_20191203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputStreamReaderDemo {
	public static void main(String[] args) {
		//String resinput = new Scanner(System.in).nextLine();
		System.out.println("입력");	
		InputStream in = System.in; // source 키보드인 경우
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		isr = new InputStreamReader(in);
		br = new BufferedReader(isr);
		try {
			String readLine = null;
			while ((readLine = br.readLine()) != null){
				if (readLine.equals("exit")) break;
				System.out.println(readLine);
				System.out.println("입력");	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
				try {
					if(in != null) in.close();
					if(br != null) br.close();
					if(isr != null) isr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
