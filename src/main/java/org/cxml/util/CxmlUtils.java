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
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

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
		StringWriter writer = new StringWriter();
		marshaller.marshal(obj, writer);
		return writer.toString(); 
	}
	
	public static <T> T xmlConvertBean(String content,Class<T> cls) throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance(cls);
		Unmarshaller unmarshaller = jc.createUnmarshaller(); 
		InputStream in = new ByteArrayInputStream(content.getBytes());
		System.setProperty("javax.xml.accessExternalDTD", "all");//设置该参数主要是为了避免解析出错 <!DOCTYPE cXML SYSTEM 'http://xml.cXML.org/schemas/cXML/1.2.008/cXML.dtd'>
		T object = (T)unmarshaller.unmarshal(in);
		return object;
	}
	
}
