package java_20191203;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java_20191128.homework2.Calender;

public class CrawlingThread extends Thread {
	private String fileName;

	public CrawlingThread(String fileName) {
		super();
		this.fileName = fileName;
	}

	@Override
	public void run() {
		int count  = 0;
		while (true) {
			count ++;
			String Name = fileName.substring(0,fileName.lastIndexOf("."));
			String Extension = fileName.substring(fileName.lastIndexOf("."));
			FileWriter fw = null;
			BufferedWriter bw = null;
			PrintWriter pw = null;
			Calendar c = Calendar.getInstance();
			SimpleDateFormat sdf = 
					new SimpleDateFormat("yyyyMMdd");
			String date = sdf.format(c.getTime());
			
			try {
				fw = new FileWriter("C:\\dev\\io\\2019\\12\\"+Name+count+Extension);
				bw = new BufferedWriter(fw);
				pw = new PrintWriter(bw);

				String[] coinlist = { "ethereum", "bitcoin" };
				for (int j = 0; j < coinlist.length; j++) {
					String url2 = String.format(
							"https://coinmarketcap.com/currencies/%s/historical-data/?start=20181203&end=%s",
							coinlist[j],date);
					Document doc2 = null;
					pw.println("##################################################################################");
					doc2 = Jsoup.connect(url2).get();
					pw.println(coinlist[j] + "성공");
					pw.println("##################################################################################");

					pw.printf("Date\t\tOpen*\tHigh  Low    Close** Volume");
					pw.println();

					Elements tableElement = doc2.select(".cmc-table__table-wrapper-outer table tbody tr");
					for (int i = 0; i < tableElement.size(); i++) {
						Element coinElement = tableElement.get(i);
						pw.print(coinElement.child(0).text() + " \t");
						pw.print(coinElement.child(1).text() + " ");
						pw.print(coinElement.child(2).text() + " ");
						pw.print(coinElement.child(3).text() + " ");
						pw.print(coinElement.child(4).text() + " ");
						pw.println(coinElement.child(5).text());
					}
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					fw.close();
					pw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
