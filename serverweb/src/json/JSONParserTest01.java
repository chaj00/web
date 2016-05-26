package json;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
//mydata.json파일을 파싱해서 콘솔에 출력하기
//name:_____
//addr:_____
//age:______
//subject:______

public class JSONParserTest01 {
	public static void main(String[] args) throws Exception {
		JSONParser jsonparser = new JSONParser();
		JSONObject jsonObj = (JSONObject)jsonparser.parse(new FileReader("src/json/mydata.json"));
		String name = (String)jsonObj.get("name");
		String addr = (String)jsonObj.get("addr");
		String age = (String)jsonObj.get("age");
		
		System.out.println("name:"+name);
		System.out.println("addr:"+addr);
		System.out.println("age:"+age);
		
		JSONArray subjectlist = (JSONArray)jsonObj.get("subjectlist");
		for(int i=0;i<subjectlist.size();i++){
			String arrayData = (String)subjectlist.get(i);
			System.out.println("subjectlist:"+arrayData);			
		}
	}

}
