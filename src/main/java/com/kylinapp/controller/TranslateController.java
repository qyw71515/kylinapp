/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.kylinapp.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kylinapp.constant.Constant;



/**    
 * @author：QYW   
 * @since：2019年1月18日上午9:26:11
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com) 
 */
@Controller
@RequestMapping(value = "/trans")
public class TranslateController {
	public static void main(String[] args) throws Exception {
        String appKey = Constant.ydy_appKey;
        String query = "hello,teacher我是一个没有感情的杀手";
        String salt = String.valueOf(System.currentTimeMillis());
        String from = "auto";
        String to = "auto";
        String sign = md5(appKey + query + salt+ Constant.ydy_secretKey);
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("q", query);
        params.put("from", from);
        params.put("to", to);
        params.put("sign", sign);
        params.put("salt", salt);
        params.put("appKey", appKey);
        params.put("ext", "mp3");
        System.out.println(requestForHttp( Constant.ydy_httpUrl, params));
       
    }
	
	@RequestMapping(value = "/query", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String query(HttpServletRequest request) {
		
        try {
        	String toLan = request.getParameter("toLan");
        	if("汉语".equals(toLan)) {
        		toLan = "zh-CHS";
        	}
        	if("英语".equals(toLan)) {
        		toLan = "EN";
        	}
        	String query = request.getParameter("query");
    		String appKey = Constant.ydy_appKey;
            String salt = String.valueOf(System.currentTimeMillis());
            String from = "auto";
            String to = toLan;
            String sign = md5(appKey + query + salt+ Constant.ydy_secretKey);
            Map<String,Object> params = new HashMap<String,Object>();
            params.put("q", query);
            params.put("from", from);
            params.put("to", to);
            params.put("sign", sign);
            params.put("salt", salt);
            params.put("appKey", appKey);
            params.put("ext", "mp3");
			String retContent = requestForHttp( Constant.ydy_httpUrl, params);
			System.err.println("有道云翻译返回结果-->"+retContent);
			return retContent;
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

    public static String requestForHttp(String url,Map requestParams) throws Exception{
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        /**HttpPost*/
        HttpPost httpPost = new HttpPost(url);
        System.out.println(new JSONObject(requestParams).toString());
        List params = new ArrayList();
        Iterator<Entry> it = requestParams.entrySet().iterator();
        while (it.hasNext()) {
            Entry en = it.next();
            String key = (String) en.getKey();
            String value = (String) en.getValue();
            if (value != null) {
                params.add(new BasicNameValuePair(key, value));
            }
        }
        httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
        /**HttpResponse*/
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
        try{
            HttpEntity httpEntity = httpResponse.getEntity();
            result = EntityUtils.toString(httpEntity, "utf-8");
            EntityUtils.consume(httpEntity);
        }finally{
            try{
                if(httpResponse!=null){
                    httpResponse.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 生成32位MD5摘要
     * @param string
     * @return
     */
    public static String md5(String string) {
        if(string == null){
            return null;
        }
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};

        try{
            byte[] btInput = string.getBytes("utf-8");
            /** 获得MD5摘要算法的 MessageDigest 对象 */
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            /** 使用指定的字节更新摘要 */
            mdInst.update(btInput);
            /** 获得密文 */
            byte[] md = mdInst.digest();
            /** 把密文转换成十六进制的字符串形式 */
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        }catch(Exception e){
            return null;
        }
    }

    /**
     * 根据api地址和参数生成请求URL
     * @param url
     * @param params
     * @return
     */
    public static String getUrlWithQueryString(String url, Map params) {
        if (params == null) {
            return url;
        }

        StringBuilder builder = new StringBuilder(url);
        if (url.contains("?")) {
            builder.append("&");
        } else {
            builder.append("?");
        }

        int i = 0;
        Set<String> set = params.keySet();
        for (String key : set ) {
            String value = (String) params.get(key);
            if (value == null) { // 过滤空的key
                continue;
            }

            if (i != 0) {
                builder.append('&');
            }

            builder.append(key);
            builder.append('=');
            builder.append(encode(value));

            i++;
        }

        return builder.toString();
    }
    /**
     * 进行URL编码
     * @param input
     * @return
     */
    public static String encode(String input) {
        if (input == null) {
            return "";
        }

        try {
            return URLEncoder.encode(input, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return input;
    }

}
