package openapi;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import dept.dto.MyDeptDTO;

public class OpenAPIParserTest {

	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {	
			DocumentBuilder dombuilder = factory.newDocumentBuilder();
			String pharm_url ="http://openapi.hira.or.kr/openapi/service/pharmacyInfoService/"
								+ "getParmacyBasisList"
								+"?pageNo=1&numOfRows=10"
								+"&sidoCd=110000&sgguCd=110019"
								+"&ServiceKey=";
			
			String key = "67pv6%2BtAs3UC0ZQckCbUws6P4WRar%2FTaou696hbOOnWYRFwX7L1ee9QFUnCiGzmS2Skwbh9GevfU%2F5M22On6Fw%3D%3D";
			String url = pharm_url+key;
			
			Document document = dombuilder.parse(url);
			Element root = document.getDocumentElement();
			
			NodeList nodelist = root.getElementsByTagName("item");
			
			for( int i=0 ; i<nodelist.getLength();i++){
				Node node = nodelist.item(i);
				Element element = (Element)node;
				String addr = getText(element, "addr");
				String clCd = getText(element, "clCd");
				String clCdNm = getText(element, "clCdNm");
				String emdongNm = getText(element, "emdongNm");
				String postNo = getText(element, "postNo");
				String sgguCd = getText(element, "sgguCd");
				String sgguCdNm = getText(element, "sgguCdNm");
				String sidoCdNm = getText(element, "sidoCd");
				String XPos = getText(element, "XPos");
				String YPos = getText(element, "YPos");
				String yadmNm = getText(element, "ykiho");
				
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static String getText(Element child, String tagName){
		String nodeValue="";
		//tagName에 해당하는 NodeList에서 첫번째 node를 구하기
		Node node = child.getElementsByTagName(tagName).item(0);
		//ex)tagName에 해당하는 노드의 첫번째 자식노드의 nodeValue구하기
		nodeValue = node.getChildNodes().item(0).getNodeValue();
		System.out.println(node.getNodeName()+":"+nodeValue);
		return nodeValue;
	}

}
