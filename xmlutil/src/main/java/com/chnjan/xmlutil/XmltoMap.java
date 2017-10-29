package com.chnjan.xmlutil;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.collections4.map.ListOrderedMap;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/**
 * 
 * 处理xml的工具类
 * @author chenjian
 * 2017-10-28
 */
public class XmltoMap {
	
	
	/**
	 * 将xml的字符串转换成map类型
	 * @param xmlString 带转换的字符串
	 * @param encode 按指定的编码类型转换
	 * @throws UnsupportedEncodingException
	 * @throws DocumentException 
	 * @return Map对象
	 * */
	public static Map<String, Object> toMap(String xmlString,String encode) throws UnsupportedEncodingException, DocumentException
	{
		//按指定的编码转换成字节数组
		byte[] stringByte = xmlString.getBytes(encode);
		//构造输入流
		InputStream is = new ByteArrayInputStream(stringByte);
		
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(is);
		Element rootElement = document.getRootElement();
		
		//用于存放转换的map
		Map<String, Object> converResult = new ListOrderedMap<String, Object>();
		
		//转换
		resovle(rootElement, converResult);
		return converResult;
	}
	
	public static void resovle(Element element,Map<String, Object> result) 
	{
		
	}

}
