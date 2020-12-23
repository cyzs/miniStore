package com.example.hxsp.utils;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 请求处理类
 * 请求处理类继承此类，重写createSign方法即可。
 * @author miklchen
 *
 */
public class RequestHandler {
	
	/** 网关url */
	private String gateUrl;
	
	/** 密钥 */
	private String key;
	
	/** 请求的参数 */
	private SortedMap parameters;
	
	/** debug信息 */
	private String debugInfo;
	
	protected HttpServletRequest request;
	
	protected HttpServletResponse response;
	
	/**
	 * 构造函数
	 * @param request
	 * @param response
	 */
	public RequestHandler(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		
		this.gateUrl = "https://gw.tenpay.com/gateway/pay.htm";
		this.key = "";
		this.parameters = new TreeMap();
		this.debugInfo = "";
	}
	
	/**
	*初始化函数。
	*/
	public void init() {
		//nothing to do
	}

	/**
	*获取入口地址,不包含参数值
	*/
	public String getGateUrl() {
		return gateUrl;
	}

	/**
	*������ڵ�ַ,�������ֵ
	*/
	public void setGateUrl(String gateUrl) {
		this.gateUrl = gateUrl;
	}

	/**
	*获取密钥
	*/
	public String getKey() {
		return key;
	}

	/**
	*设置密钥
	*/
	public void setKey(String key) {
		this.key = key;
	}
	
	/**
	 * 获取参数值
	 * @param parameter 参数名称
	 * @return String 
	 */
	public String getParameter(String parameter) {
		String s = (String)this.parameters.get(parameter); 
		return (null == s) ? "" : s;
	}
	
	/**
	 * 设置参数值
	 * @param parameter 参数名称
	 * @param parameterValue 参数值
	 */
	public void setParameter(String parameter, String parameterValue) {
		String v = "";
		if(null != parameterValue) {
			v = parameterValue.trim();
		}
		this.parameters.put(parameter, v);
	}
	
	/**
	 * 返回所有的参数
	 * @return SortedMap
	 */
	public SortedMap getAllParameters() {		
		return this.parameters;
	}

	/**
	*获取debug信息
	*/
	public String getDebugInfo() {
		return debugInfo;
	}
	

	


	
	/**
	*设置debug信息
	*/
	protected void setDebugInfo(String debugInfo) {
		this.debugInfo = debugInfo;
	}
	
	protected HttpServletRequest getHttpServletRequest() {
		return this.request;
	}
	
	protected HttpServletResponse getHttpServletResponse() {
		return this.response;
	}
	
	/**
	 * 自定义函数，官方没有
	 * @param return_code
	 * @param return_msg
	 * @return
	 */
	public static String setXML(String return_code, String return_msg) {
		return "<xml><return_code><![CDATA[" + return_code + "]]></return_code><return_msg><![CDATA[" + return_msg
				+ "]]></return_msg></xml>";
	}


}
