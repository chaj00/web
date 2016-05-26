package openapi.logic;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class OpenapiLogicImpl implements OpenapiLogic {

	@Override
	public void getweather() throws IOException {
		String url = "http://weather.naver.com/";
		Document document = Jsoup.connect(url).get();
		if(document!=null){
			Elements elements= document.select("ol#realrank >li:not(#lastrank) >a");
				
			System.out.println(elements.html());
			for(int i =0; i<elements.size();i++){
				Element tag = elements.get(i);
				System.out.println("*******************************");
				System.out.println((i+1)+">검색어:"+tag.attr("title"));
				System.out.println((i+1)+">비고:"+tag.select("span.tx").text());
				System.out.println((i+1)+">비고:"+tag.select("span.rk").text());
			}
		}
		
	}
	
}
