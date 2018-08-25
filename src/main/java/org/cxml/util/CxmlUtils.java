/*
 * @(#)CxmlUtils.java V2.0 2018年8月17日
 * 摩贝化学品电商综合服务平台	版权所有
 * 
 * 文件描述...
 *
 * @Title: CxmlUtils.java 
 * @Package org.cxml.util 
 * @author ruyu.tan
 * @date 2018年8月17日 上午9:24:03
 * @version
 * 	【2018年8月17日】 创建文件   by 谭如余
 */
package org.cxml.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

/** 
 * cxml 解析工具类
 * 
 * @ClassName: CxmlUtils 
 * @author ruyu.tan
 * @date 2018年8月17日 上午9:24:03
 * @version V2.0 
 *  
 */
public class CxmlUtils {
	
	private static Marshaller.Listener mylistener = new XMLListener();
	
	private static final String DTD = "\\<!DOCTYPE(.*?)\\>";
	
	private static final String DOCTYPE = "\\<!DOCTYPE\\>";
	
	/**
	 * 方法描述：   将javabean 转换为 xml字符串
	 * @Title: beanConvertXml 
	 * @date 2018年8月17日 下午1:25:20
	 * @author ruyu.tan
	 * @modifier 
	 * @modifydate 
	 * @param obj
	 * @return
	 * @throws JAXBException
	 */
	public static String beanConvertXml(Object obj) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.setListener(mylistener);
		StringWriter writer = new StringWriter();
		marshaller.marshal(obj, writer);
		return writer.toString(); 
	}
	
	public static <T> T xmlConvertBean(String content,Class<T> cls) throws JAXBException, SAXException, ParserConfigurationException {
		JAXBContext jc = JAXBContext.newInstance(cls);
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		//去掉<!DOCTYPE>
		Pattern p = Pattern.compile(DTD);
		Matcher m = p.matcher(content);
		String s = null;
		if (m.find()) {
			s = m.group(1);
		}
		if(s != null) {
			content = content.replaceFirst(s, "").replaceFirst(DOCTYPE, "");
		}
		InputStream in = new ByteArrayInputStream(content.getBytes());
		System.setProperty("javax.xml.accessExternalDTD", "all");//设置该参数主要是为了避免解析出错 <!DOCTYPE cXML SYSTEM 'http://xml.cXML.org/schemas/cXML/1.2.008/cXML.dtd'>
		T object = (T)unmarshaller.unmarshal(in);
		return object;
	}
	
}
