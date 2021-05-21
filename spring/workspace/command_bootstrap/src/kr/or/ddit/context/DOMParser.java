package kr.or.ddit.context;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParser {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
		// XML 문서 파싱
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document document = documentBuilder.parse("./application-context.xml");
		
		// root 구하기
		Element root = document.getDocumentElement();
		
		// root의 속성
		System.out.println("class name: " + root.getNodeName());
		
		NodeList childeren = root.getChildNodes();
		
		for(int i = 0; i < childeren.getLength(); i++){
			Node node = childeren.item(i);
			
			if(node.getNodeType() == Node.ELEMENT_NODE){ // 해당 노드의 종류 판정(Element일 때)
				
				Element ele = (Element)node;
				System.out.println(ele.getAttribute("id") + " : " + ele.getAttribute("class"));
				if(ele.getAttribute("id").equals("menuService")) {
					
					NodeList childeren_node = ele.getChildNodes();
					
					for(int j = 0; j < childeren_node.getLength(); j++){
						Node child_node = childeren_node.item(j);
						
						if(child_node.getNodeType() == Node.ELEMENT_NODE){ // 해당 노드의 종류 판정(Element일 때)
							
							Element child_ele = (Element)child_node;
							System.out.println("@@@@@  " + child_ele.getAttribute("name") + " : " + child_ele.getAttribute("ref-value"));
						}
					}
				}
			}
		}
	}
}