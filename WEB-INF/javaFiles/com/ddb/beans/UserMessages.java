package com.ddb.beans;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
// JAX-RS supports an automatic mapping from JAXB annotated class to XML and JSON
public class UserMessages {
  private String message;

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}
  
} 