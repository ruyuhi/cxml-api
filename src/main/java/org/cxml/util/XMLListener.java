/*
 * @(#)XMLListener.java V2.0 2018年8月23日
 * 摩贝化学品电商综合服务平台	版权所有
 * 
 * 文件描述...
 *
 * @Title: XMLListener.java 
 * @Package com.molbase.oms.model.config 
 * @author ruyu.tan
 * @date 2018年8月23日 上午11:04:32
 * @version
 * 	【2018年8月23日】 创建文件   by 谭如余
 */
package org.cxml.util;

import java.lang.reflect.Field;

import javax.xml.bind.Marshaller;

/** 
 * TODO 对该类总结性的描述
 * 
 * @ClassName: XMLListener 
 * @author ruyu.tan
 * @date 2018年8月23日 上午11:04:32
 * @version V2.0 
 *  
 */
public class XMLListener extends Marshaller.Listener {
	

	public static final String BLANK_CHAR = "";
	
	@Override
	public void beforeMarshal(Object source) {
		super.beforeMarshal(source);
		Field[] fields = source.getClass().getDeclaredFields();
		for (Field f : fields) {
			f.setAccessible(true);
			// 获取字段上注解<pre name="code" class="java">
			try {
				if (f.getType() == String.class && f.get(source) == null) {
					f.set(source, BLANK_CHAR);
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}

	}

}
