package java_20191203;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderWriterDemo {
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			fr = new FileReader("C:\\dev\\io\\2019\\12\\test3.txt");
			fw = new FileWriter("C:\\dev\\io\\2019\\12\\test4.txt");
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);

			String readLine = null;
			while ((readLine = br.readLine()) != null) {
				System.out.println(readLine);
				bw.write(readLine);
				bw.newLine();
			}
			bw.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (fr != null)
					fr.close();
				if (br != null)
					br.close();
				/*if (fw != null)
					fw.close();*/
				if (bw != null)
					bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
