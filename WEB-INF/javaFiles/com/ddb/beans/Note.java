package com.ddb.beans;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
// JAX-RS supports an automatic mapping from JAXB annotated class to XML and JSON
public class Note {
  private String title;
  private String contents;
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContents() {
    return contents;
  }
  public void setContents(String contents) {
    this.contents = contents;
  }  
  
  @Override
	public String toString() {		
		
		return "{" 
				+ "\"title\":\"" + title + "\""
				+ ", \"contents\":\"" + contents + "\"}";
	}
} 