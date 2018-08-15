package com.chnjan.xmlutil;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class XmltoMapTest {
	private String stringxml="";
	
	@Before
	public void getxmlString() {
		this.stringxml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
				"<contentRoot>\r\n" + 
				"<tcpCont>\r\n" + 
				"	<transcode>de45f4e5ferg</transcode>\r\n" + 
				"	<requestTime>20170822121445</requestTime>\r\n" + 
				"</tcpCont>\r\n" + 
				"<svcCont>\r\n" + 
				"	<resultcode>0</resultcode>\r\n" + 
				"	<resultdesc>success</resultdesc>\r\n" + 
				"	<respdata>\r\n" + 
				"		<id>123</id>\r\n" + 
				"		<name>jack</name>\r\n" + 
				"		<age>27</age>\r\n" + 
				"	</respdata>\r\n" + 
				"</svcCont>\r\n" + 
				"</contentRoot>";
	}
	
	@Test
	public void dotest() {
		Map<String, Object> datamap = null;
		try {
			datamap = XmltoMap.toMap(stringxml, "utf-8");
		} catch (Exception e) {
			//异常
			e.printStackTrace();
		}
		System.out.println(datamap);
	}
}
