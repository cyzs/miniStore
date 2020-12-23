package com.example.hxsp.utils;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @ClassName HttpClient
 * @Description TODO
 * @Author Zoran
 * @CreateDate 2020年05月25日  15:46:56
 * @Version 1.0.0
 */


public class HttpClient {

    // private static Logger logger = LoggerFactory.getLogger(HttpClient.class);

    // Http服务器域名/IP + PORT
    private String httpServerUrl;
    // 是否编码请求参数
    private boolean isEncode;
    // 是否采用POST发送请求
    private boolean isPost;
    // 读取cookie用于保持session
    private String cookie;
    // 指定编码
    private String encode = "UTF-8";
    // 是否保存日志
    @SuppressWarnings("unused")
    private boolean isSaveLog = false;

    public HttpClient(String httpServerUrl) {
        this(httpServerUrl, true, true);
    }

    public HttpClient(String httpServerUrl, boolean isEncode, boolean isPost) {
        this.httpServerUrl = httpServerUrl;
        this.isEncode = isEncode;
        this.isPost = isPost;
    }

    public HttpClient(String httpServerUrl, boolean isEncode, String encode,
                      boolean isPost) {
        this.httpServerUrl = httpServerUrl;
        this.isEncode = isEncode;
        this.encode = encode;
        this.isPost = isPost;
    }

    public HttpClient(String httpServerUrl, boolean isEncode, boolean isPost,
                      boolean isSaveLog) {
        this.httpServerUrl = httpServerUrl;
        this.isEncode = isEncode;
        this.isPost = isPost;
        this.isSaveLog = isSaveLog;
    }

    /**
     * 获取字符串
     *
     * @param uri
     * @param paramMap
     * @return
     * @throws Exception
     * @throws ParserConfigurationException
     * @throws SAXException
     */
    public String getString(String uri, Map<String, ?> paramMap)
            throws IOException {
        String paramStr = createParam(paramMap);
        return commonGetString(uri, paramStr);

    }

    /**
     * 获取字符串
     *
     * @param uri
     * @return
     * @throws Exception
     * @throws ParserConfigurationException
     * @throws SAXException
     */
    String getString(String uri, String paramStr) throws Exception {
        return commonGetString(uri, paramStr);
    }

    private String commonGetString(String uri, String paramStr)
            throws IOException {
        //String queryPath = httpServerUrl + uri + "?" + paramStr;
        // logger.info("commonGetString请求路径:"+queryPath);
        HttpURLConnection urlConnection = getHttpURLConnection(uri, paramStr);
        BufferedReader in = null;
        try {
            StringBuilder builder = new StringBuilder();
            in = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream(), encode));
            for (String line; (line = in.readLine()) != null;) {
                builder.append(line);
            }
            cookie = urlConnection.getHeaderField("set-cookie");
            try {
                int statusCode = urlConnection.getResponseCode();
                System.out.println("状态码:" + statusCode);
                // if(statusCode!=200){
                // saveHttpLog(queryPath);
                // }else{
                // // if(isSaveLog){
                // // if(!HttpClientLog.parserJsonToMap(builder.toString())){
                // // saveHttpLog(queryPath);
                // // }
                // // }
                // }
            } catch (Exception e) {
                // logger.info("日志保存错误:",e);
            }
            return builder.toString();
        } catch (Exception e) {
            // logger.error("出错:"+e);
            // saveHttpLog(queryPath);
            return "";
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                } // 忽略
                in = null;
            }
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }

    /**
     * 获取XML Document
     *
     * @param uri
     * @param paramMap
     * @return
     * @throws IOException
     * @throws ParserConfigurationException
     * @throws SAXException
     */
    public Document getXml(String uri, Map<String, ?> paramMap)
            throws IOException, ParserConfigurationException, SAXException {
        String paramStr = createParam(paramMap);
        HttpURLConnection urlConnection = getHttpURLConnection(uri, paramStr);
        InputStream in = null;
        try {
            in = new BufferedInputStream(urlConnection.getInputStream());
            DocumentBuilder builder = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder();
            Document doc = builder.parse(in);
            cookie = urlConnection.getHeaderField("set-cookie");
            return doc;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                } // 忽略
                in = null;
            }
        }
    }

    /**
     * 获取Http连接
     *
     * @param uri
     * @param paramMap
     * @return
     * @throws IOException
     */
    private HttpURLConnection getHttpURLConnection(String uri,
                                                   String paramString) throws IOException {
        // logger.debug("{}{}?{}", new String[]{httpServerUrl, uri,
        // paramString});
        // 获取Http连接
        URL url = isPost ? new URL(httpServerUrl + uri) : new URL(httpServerUrl
                + uri + "?" + paramString);
        HttpURLConnection urlConnection = (HttpURLConnection) url
                .openConnection();
        // 允许输入输出
        urlConnection.setDoOutput(true);
        urlConnection.setDoInput(true);
        // 禁止使用缓存
        urlConnection.setUseCaches(false);
        // 模拟firefox17头部
        urlConnection
                .setRequestProperty("User-Agent",
                        "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:17.0) Gecko/20100101 Firefox/17.0");
        urlConnection.setRequestProperty("Accept-Language",
                "zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3");
        // 设置连接10秒超时，读取30秒超时
        urlConnection.setConnectTimeout(15 * 1000);
        urlConnection.setReadTimeout(30 * 1000);
        // 若cookie存在，则增加请求属性"cookie"
        if (cookie != null) {
            urlConnection.setRequestProperty("cookie", cookie);
        }
        // 发送POST请求参数
        if (isPost) {
            PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(
                        urlConnection.getOutputStream(), encode));
                out.write(paramString);
            } finally {
                if (out != null) {
                    out.close();
                    out = null;
                }
            }
        }
        return urlConnection;
    }

    // 参数拼接
    private String createParam(Map<String, ?> paramMap)
            throws UnsupportedEncodingException {
        // 编码请求参数
        StringBuilder paramBuilder = new StringBuilder(256);
        if (paramMap != null && !paramMap.isEmpty()) {
            for (Map.Entry<String, ?> entry : paramMap.entrySet()) {
                Object paramValue = entry.getValue();
                if (paramValue != null && paramValue.getClass().isArray()) {
                    Object[] values = (Object[]) paramValue;
                    for (int i = 0; i < values.length; i++) {
                        paramBuilder.append(isEncode ? URLEncoder.encode(
                                entry.getKey(), encode) : entry.getKey());
                        paramBuilder.append("=");
                        if (values[i] != null) {
                            paramBuilder.append(isEncode ? URLEncoder.encode(
                                    values[i].toString(), encode) : values[i]
                                    .toString());
                        }
                        paramBuilder.append("&");
                    }
                } else {
                    paramBuilder.append(isEncode ? URLEncoder.encode(
                            entry.getKey(), encode) : entry.getKey());
                    paramBuilder.append("=");
                    if (paramValue != null) {
                        paramBuilder.append(isEncode ? URLEncoder.encode(
                                paramValue.toString(), encode) : paramValue
                                .toString());
                    }
                    paramBuilder.append("&");
                }
            }
            paramBuilder.deleteCharAt(paramBuilder.length() - 1);
        }
        String paramString = paramBuilder.toString();
        return paramString;
    }

    // private void saveHttpLog(String queryPath){
    // if(isSaveLog){
    // //保存日志
    // HttpClientLog httpLog=HttpClientLog.getInstance();
    // try {
    // httpLog.info(queryPath);
    // } catch (Exception e) {
    // logger.error("-----------------保存日志出错-----------------",e);
    // }
    // }
    // }
}
