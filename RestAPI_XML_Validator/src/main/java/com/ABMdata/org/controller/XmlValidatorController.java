package com.ABMdata.org.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.ABMdata.org.util.XMLValidator;

@Path("/validate")
public class XmlValidatorController {
	
	  @GET
	  public int validateXml(String xmlContent){
		  XMLValidator validator  = new XMLValidator();
		   if(validator.validate(xmlContent)) {
			   if(validator.validateDeclarationTag(xmlContent)) {
				   return -1;
			   }
			   else if(validator.validateSiteIdTag(xmlContent)) {
				   return -2;
			   }
			   return 0;  
		   }	
		   else
			   return 1;
	  }
}
