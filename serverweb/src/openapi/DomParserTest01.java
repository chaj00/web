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
		//1. DocumentBuilder�� �̿��ؼ� parsing�� ���̹Ƿ� DocumentBuilder�� 
		//   ������ִ� DocumentBuilderFactory�� ���� �����Ѵ�.
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		ArrayList<MyDeptDTO> list = new ArrayList<MyDeptDTO>();
		try {
			//2. xml������ �Ľ��� �� �ִ� ����� �����ϴ� DocumentBuilder����
			DocumentBuilder dombuilder = factory.newDocumentBuilder();
			//3. xml������ �Ľ� - �����̳� InputStream���·� �����ϴ� ���� �Ϲ���
			Document document = dombuilder.parse("src/openapi/dept.xml");
			//System.out.println(document);
			//4. root��带 ���ϱ�
			Element root = document.getDocumentElement();
			//System.out.println(root.getTagName()+","+root.getNodeName());
			
			//5. root����� �ڽĳ�带 ���ϱ�
			NodeList nodelist = root.getChildNodes();
			NodeList deptlist = root.getElementsByTagName("dept");
			
			//6. NodeListŽ��
			for(int i =0; i<deptlist.getLength();i++){
				Node node = deptlist.item(i);
				//System.out.println("^^^^"+node.getTextContent());
				//����� �Ӽ��� �Ӽ����� Ž��
				printAttInfo(node);
				Element deptelement = (Element)node;
				System.out.println("********����������Ʈ�� ���� ���********");
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
		System.out.println("�� ����� �Ӽ��� ����=>"+attMap.getLength());
		Node attrNode = attMap.item(0);
		System.out.println("�Ӽ���:"+attrNode.getNodeName());
		System.out.println("�Ӽ���:"+attrNode.getNodeValue());
		
	}

	public static String getText(Element child, String tagName){
		String nodeValue="";
		//tagName�� �ش��ϴ� NodeList���� ù��° node�� ���ϱ�
		Node node = child.getElementsByTagName(tagName).item(0);
		//ex)tagName�� �ش��ϴ� ����� ù��° �ڽĳ���� nodeValue���ϱ�
		nodeValue = node.getChildNodes().item(0).getNodeValue();
		System.out.println(node.getNodeName()+":"+nodeValue);
		return nodeValue;
	}

}
