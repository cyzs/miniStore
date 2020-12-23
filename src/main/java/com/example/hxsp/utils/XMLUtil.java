package com.example.hxsp.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * xml工具类
 * @author miklchen
 *
 */
public class XMLUtil {

    /**
	 * 解析xml,返回第一级元素键值对。如果第一级元素有子节点，则此节点的值是子节点的xml数据。
     * @param strXML XML字符串
     * 
     * @return XML数据转换后的Map
     * @throws Exception
     */
    public static Map<String, String> doXMLParse(String strXML) throws Exception {
        try {
            Map<String, String> data = new HashMap<String, String>();
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            String FEATURE = null;
        	FEATURE = "http://apache.org/xml/features/disallow-doctype-decl";
        	dbf.setFeature(FEATURE, true);
        	FEATURE = "http://xml.org/sax/features/external-general-entities";
        	dbf.setFeature(FEATURE, false);
        	FEATURE = "http://xml.org/sax/features/external-parameter-entities";
        	dbf.setFeature(FEATURE, false);
        	FEATURE = "http://apache.org/xml/features/nonvalidating/load-external-dtd";
        	dbf.setFeature(FEATURE, false);
        	dbf.setXIncludeAware(false);
        	dbf.setExpandEntityReferences(false);
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            InputStream stream = new ByteArrayInputStream(strXML.getBytes("UTF-8"));
            org.w3c.dom.Document doc = documentBuilder.parse(stream);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getDocumentElement().getChildNodes();
            for (int idx = 0; idx < nodeList.getLength(); ++idx) {
                Node node = nodeList.item(idx);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    org.w3c.dom.Element element = (org.w3c.dom.Element) node;
                    data.put(element.getNodeName(), element.getTextContent());
                }
            }
            try {
                stream.close();
            } catch (Exception ex) {
                // do nothing
            }
            return data;
        } catch (Exception ex) {
            throw ex;
        }

    }
	
	/**
	 * 获取子结点的xml
	 * @param children
	 * @return String
	 */
	public static String getChildrenText(List children) {
		StringBuffer sb = new StringBuffer();
		if(!children.isEmpty()) {
			Iterator it = children.iterator();
			while(it.hasNext()) {
				Element e = (Element) it.next();
				String name = e.getName();
				String value = e.getTextNormalize();
				List list = e.getChildren();
				sb.append("<" + name + ">");
				if(!list.isEmpty()) {
					sb.append(XMLUtil.getChildrenText(list));
				}
				sb.append(value);
				sb.append("</" + name + ">");
			}
		}
		
		return sb.toString();
	}
	
	/**
	 * 获取xml编码字符集
	 * @param strxml
	 * @return
	 * @throws IOException 
	 * @throws JDOMException 
	 */
	public static String getXMLEncoding(String strxml) throws JDOMException, IOException {
		InputStream in = HttpClientUtil.String2Inputstream(strxml);
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(in);
		in.close();
		return (String)doc.getProperty("encoding");
	}
	
	
}
