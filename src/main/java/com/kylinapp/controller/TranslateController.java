/** 
 * Copyright: Copyright (c)2015
 * Company: ����������Ϣ���޹�˾(jxhtxx.com) 
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
 * @author��QYW   
 * @since��2019��1��18������9:26:11
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: ����������Ϣ���޹�˾(jxhtxx.com) 
 */
@Controller
@RequestMapping(value = "/trans")
public class TranslateController {
	public static void main(String[] args) throws Exception {
        String appKey = Constant.ydy_appKey;
        String query = "hello,teacher����һ��û�и����ɱ��";
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
        	if("����".equals(toLan)) {
        		toLan = "zh-CHS";
        	}
        	if("Ӣ��".equals(toLan)) {
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
			System.err.println("�е��Ʒ��뷵�ؽ��-->"+retContent);
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
     * ����32λMD5ժҪ
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
            /** ���MD5ժҪ�㷨�� MessageDigest ���� */
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            /** ʹ��ָ�����ֽڸ���ժҪ */
            mdInst.update(btInput);
            /** ������� */
            byte[] md = mdInst.digest();
            /** ������ת����ʮ�����Ƶ��ַ�����ʽ */
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
     * ����api��ַ�Ͳ�����������URL
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
            if (value == null) { // ���˿յ�key
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
     * ����URL����
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
