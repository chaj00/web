package openapi;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parser {
	public static void main(String[] args) throws IOException {

		//1. 원하는 정보가 있는 HTML페이지에 접속해서 원하는 정보를 가져오기
		Document document = Jsoup.connect("http://info.finance.naver.com/marketindex/").get();
		if(document!=null){
			Elements elements = document.select("div.market1");
			//System.out.println(elements.html());
			
			Elements h_market1 = elements.select("h2");
				
			String title1 = h_market1.get(0).text();
			
			Elements h_lst = elements.select("h3");
			int size = h_lst.size();
			String[] head = new String[h_lst.size()];
			for(int i=0; i<head.length;i++){
				head[i]= h_lst.get(i).text();
			
			}

			
			Elements head_info = elements.select("div.head_info");

			System.out.println("size"+size);
			String[] value = new String[size];
			String[] change = new String[size];
			String[] fluctuation = new String[size];
			for(int i=0;i<size;i++){
				value[i] = head_info.get(i).select("span.value").text()+ "원";
				change[i] =head_info.get(i).select("span.change").text();
				fluctuation[i] =head_info.get(i).select("span.blind").get(1).text();
			}

			
			String[] img = new String[size] ;
			for(int i=0;i<size;i++){
				img[i] =elements.select("img").get(i).attr("src");
			}
			
			
			
			//System.out.println(head_info);
			System.out.println(title1);
			System.out.println(head[0]);
			System.out.println(value[0] + change[0]+ fluctuation[0]);
			System.out.println(img[0]);
			
			
			for(int i =0; i<elements.size();i++){
				Element tag = elements.get(i);
				
				
		/*		System.out.println("*******************************");
				System.out.println((i+1)+">검색어:"+tag.attr("title"));
				System.out.println((i+1)+">비고:"+tag.select("span.tx").text());
				System.out.println((i+1)+">비고:"+tag.select("span.rk").text());*/
			}
		
			
		}
		
	}

}
