package java_20191203;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CoinMarket {
	public static void main(String[] args) {
/*		String[] coinlist = { "ethereum", "bitcoin" };
		for (int j = 0; j < coinlist.length; j++) {
			String url2 = String.format(
					"https://coinmarketcap.com/currencies/%s/historical-data/?start=20181203&end=20191203",
					coinlist[j]);
			Document doc2 = null;
			System.out.println("##################################################################################");
			try {
				doc2 = Jsoup.connect(url2).get();
				System.out.println(coinlist[j] + "성공");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("##################################################################################");

			System.out.printf("Date \t\tOpen*  Low  Close** \t Volume \n");

			Elements tableElement = doc2.select(".cmc-table__table-wrapper-outer table tbody tr");
			for (int i = 0; i < tableElement.size(); i++) {
				Element coinElement = tableElement.get(i);
				System.out.print(coinElement.child(0).text() +" ");
				System.out.print(coinElement.child(1).text() +" ");
				System.out.print(coinElement.child(2).text() +" ");
				System.out.print(coinElement.child(3).text() +" ");
				System.out.print(coinElement.child(4).text() +" ");
				System.out.println(coinElement.child(5).text());
			}
		}*/
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter("C:\\dev\\io\\2019\\12\\coin.txt");
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
			
			String[] coinlist = { "ethereum", "bitcoin" };
			for (int j = 0; j < coinlist.length; j++) {
				String url2 = String.format(
						"https://coinmarketcap.com/currencies/%s/historical-data/?start=20181203&end=20191203",
						coinlist[j]);
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
					pw.print(coinElement.child(0).text() +" \t");
					pw.print(coinElement.child(1).text() +" ");
					pw.print(coinElement.child(2).text() +" ");
					pw.print(coinElement.child(3).text() +" ");
					pw.print(coinElement.child(4).text() +" ");
					pw.println(coinElement.child(5).text());
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}
