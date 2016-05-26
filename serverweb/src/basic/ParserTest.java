package basic;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

@WebServlet(name = "test", urlPatterns = { "/test.do" })
public class ParserTest extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		Document document = Jsoup.connect("http://info.finance.naver.com/marketindex/").get();
		if(document!=null){
			Elements elements = document.select("div.market1");
			//System.out.println(elements.html());
			
			Elements h_market1 = elements.select("h2");
				
			String title = h_market1.get(0).text();
			
			Elements h_lst = elements.select("h3");
			int size = h_lst.size();
			/*String[] head = new String[h_lst.size()];
			for(int i=0; i<head.length;i++){
				head[i]= h_lst.get(i).text();
	
			}*/
			ArrayList<String> head = new ArrayList<String>();
			for(int i=0; i<size;i++){
				head.add(h_lst.get(i).text());
			}

			System.out.println(head);
			Elements head_info = elements.select("div.head_info");

			System.out.println("size"+size);
			/*String[] value = new String[size];
			String[] change = new String[size];
			String[] fluctuation = new String[size];
			for(int i=0;i<size;i++){
				value[i] = head_info.get(i).select("span.value").text()+ "¿ø";
				change[i] =head_info.get(i).select("span.change").text();
				fluctuation[i] =head_info.get(i).select("span.blind").get(1).text();
			}*/
			ArrayList<String> value = new ArrayList<String>();
			ArrayList<String> change = new ArrayList<String>();
			ArrayList<String> fluctuation = new ArrayList<String>();
			
			for(int i=0; i<size;i++){
				value.add(head_info.get(i).select("span.value").text()+ "¿ø");
				change.add(head_info.get(i).select("span.change").text());
				fluctuation.add(head_info.get(i).select("span.blind").get(1).text());
			}
			
			/*String[] img = new String[size] ;
			for(int i=0;i<size;i++){
				img[i] =elements.select("img").get(i).attr("src");
			}*/
			ArrayList<String> img = new ArrayList<String>();
			for(int i=0;i<size;i++){
				img.add(elements.select("img").get(i).attr("src"));
			}
			request.setAttribute("test", "test");
			request.setAttribute("title", title);
			request.setAttribute("head", head);
			request.setAttribute("value", value);
			request.setAttribute("change", change);
			request.setAttribute("flucuation", fluctuation);
			
			RequestDispatcher rd = request.getRequestDispatcher("/test.jsp");
			rd.forward(request, response);
		}
	
		
		
	}
}
