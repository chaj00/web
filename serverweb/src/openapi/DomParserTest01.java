package openapi;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import dept.dto.MyDeptDTO;

public class DomParserTest01 {

	public static void main(String[] args) {
		//1. DocumentBuilder를 이용해서 parsing할 것이므로 DocumentBuilder를 
		//   만들어주는 DocumentBuilderFactory를 먼저 생성한다.
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		ArrayList<MyDeptDTO> list = new ArrayList<MyDeptDTO>();
		try {
			//2. xml문서를 파싱할 수 있는 기능을 제공하는 DocumentBuilder생성
			DocumentBuilder dombuilder = factory.newDocumentBuilder();
			//3. xml문서를 파싱 - 파일이나 InputStream형태로 존재하는 것이 일반적
			Document document = dombuilder.parse("src/openapi/dept.xml");
			//System.out.println(document);
			//4. root노드를 구하기
			Element root = document.getDocumentElement();
			//System.out.println(root.getTagName()+","+root.getNodeName());
			
			//5. root노드의 자식노드를 구하기
			NodeList nodelist = root.getChildNodes();
			NodeList deptlist = root.getElementsByTagName("dept");
			
			//6. NodeList탐색
			for(int i =0; i<deptlist.getLength();i++){
				Node node = deptlist.item(i);
				//System.out.println("^^^^"+node.getTextContent());
				//노드의 속성과 속성값을 탐색
				printAttInfo(node);
				Element deptelement = (Element)node;
				System.out.println("********하위엘리먼트의 값을 출력********");
				String code = getText(deptelement, "code");
				String name = getText(deptelement, "name");
				String loc = getText(deptelement, "loc");
				String tel = getText(deptelement, "tel");
				
				MyDeptDTO dept = new MyDeptDTO(code, name, loc, tel);
				list.add(dept);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private static void printAttInfo(Node node) {
		NamedNodeMap attMap = node.getAttributes();
		System.out.println("각 노드의 속성의 갯수=>"+attMap.getLength());
		Node attrNode = attMap.item(0);
		System.out.println("속성명:"+attrNode.getNodeName());
		System.out.println("속성값:"+attrNode.getNodeValue());
		
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
