package com.ABMdata.org;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//Solution for Question 2
public class XmlParsing {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// creating a constructor of file class and parsing an XML file
		File file = new File("C:\\Users\\lenovo\\Desktop\\ABM\\ABM.xml");
		// an instance of factory that gives a document builder
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// an instance of builder to parse the specified xml file
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(file);
		doc.getDocumentElement().normalize();

		NodeList nodeList = doc.getElementsByTagName("Reference");
		for (int itr = 0; itr < nodeList.getLength(); itr++) {
			Node node = nodeList.item(itr);
			String RefCode = node.getAttributes().getNamedItem("RefCode").getNodeValue();
			if (RefCode.equals("MWB") || RefCode.equals("CAR") || RefCode.equals("TRV")) {

				System.out.println(RefCode + " : " + node.getTextContent().trim());
			}
		}
	}
}
