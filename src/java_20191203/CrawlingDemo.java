package java_20191203;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingDemo {
	public static void main(String[] args) {

/*		String url = "http://www.imbc.com/"; // HTML 문서 전체를 관리하기 위한 객체
		Document doc = null;

		try {
			doc = Jsoup.connect(url).get();
			System.out.println("성공");
		} catch (IOException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		Elements element = doc.select(".con-wrap.notice-wrap");
		Elements titleElements = element.select("h3");
		String noticeTitle = titleElements.text();
		System.out.println(noticeTitle);
		Elements listElements = element.select(".notice-list ul li");
		for (int i = 0; i < listElements.size(); i++) {
			Element liElement = listElements.get(i);
			String text = liElement.text();
			System.out.println(text);
		}
		String hreg = listElements.select("a").attr("abs:href");
		System.out.println(hreg);
*/
		String url = "https://sports.news.naver.com/index.nhn"; // HTML 문서 전체를
																// 관리하기 위한 객체
		Document doc = null;

		try {
			doc = Jsoup.connect(url).get();
			System.out.println("성공");
		} catch (IOException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

		Elements element = doc.select("#news_category_contents_2_0");
		Elements listElements = element.select(".main_article_list li");
		for (int i = 0; i < listElements.size(); i++) {
			Element liElement = listElements.get(i);
			String text = liElement.text();
			System.out.println(text);
		}
		String hreg = listElements.select("a").attr("abs:href");
		System.out.println(hreg);		
	

	}
}
