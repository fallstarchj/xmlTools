package com.chnjan.xmlutil;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.collections4.map.ListOrderedMap;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

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
			
		//转换
		Map<String, Object> converResult = resovle(rootElement);
		return converResult;
	}
	
	/**
	 * 将element对象解析成map
	 * @param element dom4j的Element对象
	 * @return 转换后的map类型
	 * 
	 * */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> resovle(Element element) 
	{
		Map<String, Object> result = new ListOrderedMap<String, Object>();
		//元素的迭代器
		Iterator<Element> iterator = element.elementIterator();
		//遍历元素
		while (iterator.hasNext()) {
			Element e = iterator.next();
			if (e.isTextOnly()) {
				//如果没有子节点了将元素名和值以键值对的形式放入map
				result.put(e.getName(), e.getText());
			} else {
				//如果此元素下还有子节点则递归
				Map<String, Object> childMap = resovle(e);
				result.put(e.getName(), childMap);
			}
		}
		
		return result;
	}

}
