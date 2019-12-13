package com.ABMdata.org.util;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLValidator {
///RestAPI_XML_Validator/src/main/resources/xml_payload.xsd
	public boolean validate(String xml) {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
        	///codility_demo_task/src/com/codility/test.xml
            Schema schema = schemaFactory.newSchema(new File("C://Users/Dell/Practice workspace/RestAPI_XML_Validator/src/main/resources/xml_payload.xsd"));
            Validator validator = schema.newValidator();
            //validator.validate(new StreamSource(xmlContent));
            validator.validate(new StreamSource(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8))));
            
            return true;
        } catch (SAXException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }

	public boolean validateDeclarationTag(String xmlContent)
	{
		// TODO Auto-generated method stub
		
		try
		{
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// an instance of builder to parse the specified xml file
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc;
			doc = db.parse(new InputSource(new StringReader(xmlContent)));
			doc.getDocumentElement().normalize();
			
			NodeList nodeList = doc.getElementsByTagName("Declaration");
			for (int itr = 0; itr < nodeList.getLength(); itr++) {
				Node node = nodeList.item(itr);
				String RefCode =node.getAttributes().getNamedItem("Command").getNodeValue();
				if(RefCode.equalsIgnoreCase("DEFAULT"));
				return true;
			}
			
			
		} catch (SAXException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (ParserConfigurationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean validateSiteIdTag(String xml)
	{
		// TODO Auto-generated method stub
		
		try
		{
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// an instance of builder to parse the specified xml file
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc;
			doc = db.parse(new InputSource(new StringReader(xml)));
			doc.getDocumentElement().normalize();
			
			NodeList nodeList = doc.getElementsByTagName("SiteID");
			for (int itr = 0; itr < nodeList.getLength(); itr++) {
				Node node = nodeList.item(itr);
				String SiteValue =node.getTextContent();
				if(SiteValue.equalsIgnoreCase("DUB"))
				return true;
			}
			
			
		} catch (SAXException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (ParserConfigurationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
		
}