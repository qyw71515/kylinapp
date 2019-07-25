/** 
 * Copyright: Copyright (c)2015
 * Company: ����������Ϣ���޹�˾(jxhtxx.com) 
 */
package com.kylinapp.controller;

//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**    
 * @author��QYW   
 * @since��2019��1��28������10:04:17
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: ����������Ϣ���޹�˾(jxhtxx.com) 
 */
@Controller
@RequestMapping(value = "/mall")
public class MallController {
	@RequestMapping(value = "/getTypeTree", method = { RequestMethod.POST, RequestMethod.GET },produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getTypeTree (HttpServletRequest request, HttpServletResponse response){
//		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
//		Map<String,Object> typemap = new HashMap<String,Object>();
//		typemap.put("1", "test1");
		
		JSONObject retjson = new JSONObject();
		JSONArray typearr = new JSONArray();
		JSONObject typejson = new JSONObject();
		typejson.put("id", "1");
		typejson.put("name", "΢�ſ���");
		typearr.add(typejson);
		typejson.put("id", "2");
		typejson.put("name", "��վ��վ");
		typearr.add(typejson);
		typejson.put("id", "3");
		typejson.put("name", "��׿����");
		typearr.add(typejson);
		
		
		
		JSONArray goodsarr = new JSONArray();
		JSONObject goodsjson = new JSONObject();
		goodsjson.put("id", "1");
		goodsjson.put("name", "��΢��С����΢��С���򿪷�");
		JSONArray imgarr = new JSONArray();
		
		imgarr.add("http://img.027cgb.com/615537/wxt1.png");
		imgarr.add("http://img.027cgb.com/615537/wxt2.png");
		imgarr.add("http://img.027cgb.com/615537/wxt3.png");
		JSONArray contentimgarr = new JSONArray();
		contentimgarr.add("http://img.027cgb.com/615537/wxc1.png");
		contentimgarr.add("http://img.027cgb.com/615537/wxc2.png");
		contentimgarr.add("http://img.027cgb.com/615537/wxc3.png");
		goodsjson.put("imgarr", imgarr);
		goodsjson.put("contentimgarr", contentimgarr);
		goodsjson.put("price", "0");
		goodsjson.put("disprice", "0");
		goodsjson.put("jf", "0");
		goodsjson.put("des", "��΢��С����΢��С�����ƿ���������������ϵ�ң�΢�źţ���HHnler��(�����ִ�Сд)");
		
		JSONArray hlarr = new JSONArray();
		JSONObject hl = new JSONObject();
		hl.put("type", "��");
		hl.put("name", "��������0����");
		hlarr.add(hl);
		hl.put("type", "����");
		hl.put("name", "����");
		hlarr.add(hl);
		goodsjson.put("hlarr", hlarr);
		
		goodsarr.add(goodsjson);
		
		goodsjson = new JSONObject();
		goodsjson.put("id", "2");
		goodsjson.put("name", "��΢�Ź��ںš�΢�Ź��ںſ���");
		imgarr = new JSONArray();
		contentimgarr = new JSONArray();
		imgarr.add("https://gss3.bdstatic.com/-Po3dSag_xI4khGkpoWK1HF6hhy/baike/w%3D268%3Bg%3D0/sign=d6825072ed1190ef01fb95d9f620fa2b/4bed2e738bd4b31cd4b614248dd6277f9f2ff8a3.jpg");
		imgarr.add("https://imgsa.baidu.com/baike/pic/item/dc54564e9258d10922a39481dd58ccbf6c814d44.jpg");
		imgarr.add("https://gss3.bdstatic.com/-Po3dSag_xI4khGkpoWK1HF6hhy/baike/whfpf%3D268%2C152%2C50/sign=bbc60302b13eb1354492e4fbc0239ae5/342ac65c10385343c03ea8cb9e13b07ecb808862.jpg");
		contentimgarr.add("https://imgsa.baidu.com/baike/pic/item/dc54564e9258d10922a39481dd58ccbf6c814d44.jpg");
		contentimgarr.add("https://imgsa.baidu.com/baike/pic/item/dc54564e9258d10922a39481dd58ccbf6c814d44.jpg");
		contentimgarr.add("https://imgsa.baidu.com/baike/pic/item/dc54564e9258d10922a39481dd58ccbf6c814d44.jpg");
		goodsjson.put("imgarr", imgarr);
		goodsjson.put("contentimgarr", contentimgarr);
		goodsjson.put("price", "0");
		goodsjson.put("disprice", "0");
		goodsjson.put("jf", "0");
		goodsjson.put("des", "��΢�Ź��ںš�΢�Ź��ںŶ��ƿ���������������ϵ�ң�΢�źţ���HHnler��(�����ִ�Сд)");
		
		hlarr = new JSONArray();
		hl = new JSONObject();
		hl.put("type", "��");
		hl.put("name", "��������0����");
		hlarr.add(hl);
		hl.put("type", "����");
		hl.put("name", "����");
		hlarr.add(hl);
		goodsjson.put("hlarr", hlarr);
		
		goodsarr.add(goodsjson);
			
		
		retjson.put("errCode", "0000");
		retjson.put("errMSG", "suc");
		retjson.put("typearr", typearr);
		retjson.put("goodsarr", goodsarr);
		
		System.err.println("getTypeTree:retjson-->"+retjson);
		
		return retjson.toString();
	}
	
	@RequestMapping(value = "/getGoodsInfo", method = { RequestMethod.POST, RequestMethod.GET },produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getGoodsInfo (HttpServletRequest request, HttpServletResponse response){
//		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
//		Map<String,Object> typemap = new HashMap<String,Object>();
//		typemap.put("1", "test1");
		JSONObject retjson = new JSONObject();
		String id = request.getParameter("id");
		if(id.equals("1")) {
			JSONObject goodsInfo = new JSONObject();
			JSONArray imgarr = new JSONArray();
			imgarr.add("https://gss3.bdstatic.com/-Po3dSag_xI4khGkpoWK1HF6hhy/baike/w%3D268%3Bg%3D0/sign=d6825072ed1190ef01fb95d9f620fa2b/4bed2e738bd4b31cd4b614248dd6277f9f2ff8a3.jpg");
			imgarr.add("https://imgsa.baidu.com/baike/pic/item/dc54564e9258d10922a39481dd58ccbf6c814d44.jpg");
			imgarr.add("https://gss3.bdstatic.com/-Po3dSag_xI4khGkpoWK1HF6hhy/baike/whfpf%3D268%2C152%2C50/sign=bbc60302b13eb1354492e4fbc0239ae5/342ac65c10385343c03ea8cb9e13b07ecb808862.jpg");
			goodsInfo.put("imgarr", imgarr);
			goodsInfo.put("name", "��΢��С����΢��С���򿪷�");
			goodsInfo.put("des", "��΢��С����΢��С�����ƿ���������������ϵ�ң�΢�źţ���HHnler��(�����ִ�Сд)");
			goodsInfo.put("price", 0);
			goodsInfo.put("disprice", 0);
			JSONArray contentimgarr = new JSONArray();
			contentimgarr.add("https://imgsa.baidu.com/baike/pic/item/dc54564e9258d10922a39481dd58ccbf6c814d44.jpg");
			contentimgarr.add("https://imgsa.baidu.com/baike/pic/item/dc54564e9258d10922a39481dd58ccbf6c814d44.jpg");
			contentimgarr.add("https://imgsa.baidu.com/baike/pic/item/dc54564e9258d10922a39481dd58ccbf6c814d44.jpg");
			
			goodsInfo.put("contentimgarr", contentimgarr);
			JSONArray hlarr = new JSONArray();
			JSONObject hl = new JSONObject();
			hl.put("type", "��");
			hl.put("name", "��������0����");
			hlarr.add(hl);
			hl.put("type", "����");
			hl.put("name", "����");
			hlarr.add(hl);
			goodsInfo.put("hlarr", hlarr);
			retjson.put("goodsInfo", goodsInfo);
		}
		
		if(id.equals("2")) {
			JSONObject goodsInfo = new JSONObject();
			JSONArray imgarr = new JSONArray();
			imgarr.add("https://gss3.bdstatic.com/-Po3dSag_xI4khGkpoWK1HF6hhy/baike/w%3D268%3Bg%3D0/sign=d6825072ed1190ef01fb95d9f620fa2b/4bed2e738bd4b31cd4b614248dd6277f9f2ff8a3.jpg");
			imgarr.add("https://imgsa.baidu.com/baike/pic/item/dc54564e9258d10922a39481dd58ccbf6c814d44.jpg");
			imgarr.add("https://gss3.bdstatic.com/-Po3dSag_xI4khGkpoWK1HF6hhy/baike/whfpf%3D268%2C152%2C50/sign=bbc60302b13eb1354492e4fbc0239ae5/342ac65c10385343c03ea8cb9e13b07ecb808862.jpg");
			goodsInfo.put("imgarr", imgarr);
			goodsInfo.put("name", "��΢�Ź��ںš�΢�Ź��ںſ���");
			goodsInfo.put("des", "��΢�Ź��ںš�΢�Ź��ںŶ��ƿ���������������ϵ�ң�΢�źţ���HHnler��(�����ִ�Сд)");
			goodsInfo.put("price", 0);
			goodsInfo.put("disprice", 0);
			JSONArray contentimgarr = new JSONArray();
			contentimgarr.add("https://imgsa.baidu.com/baike/pic/item/dc54564e9258d10922a39481dd58ccbf6c814d44.jpg");
			contentimgarr.add("https://imgsa.baidu.com/baike/pic/item/dc54564e9258d10922a39481dd58ccbf6c814d44.jpg");
			contentimgarr.add("https://imgsa.baidu.com/baike/pic/item/dc54564e9258d10922a39481dd58ccbf6c814d44.jpg");
			
			goodsInfo.put("contentimgarr", contentimgarr);
			JSONArray hlarr = new JSONArray();
			JSONObject hl = new JSONObject();
			hl.put("type", "��");
			hl.put("name", "��������0����");
			hlarr.add(hl);
			hl.put("type", "����");
			hl.put("name", "����");
			hlarr.add(hl);
			goodsInfo.put("hlarr", hlarr);
			retjson.put("goodsInfo", goodsInfo);
		}
		
		if(id.equals("3")) {
			JSONObject goodsInfo = new JSONObject();
			JSONArray imgarr = new JSONArray();
			imgarr.add("https://gss3.bdstatic.com/-Po3dSag_xI4khGkpoWK1HF6hhy/baike/w%3D268%3Bg%3D0/sign=d6825072ed1190ef01fb95d9f620fa2b/4bed2e738bd4b31cd4b614248dd6277f9f2ff8a3.jpg");
			imgarr.add("https://imgsa.baidu.com/baike/pic/item/dc54564e9258d10922a39481dd58ccbf6c814d44.jpg");
			imgarr.add("https://gss3.bdstatic.com/-Po3dSag_xI4khGkpoWK1HF6hhy/baike/whfpf%3D268%2C152%2C50/sign=bbc60302b13eb1354492e4fbc0239ae5/342ac65c10385343c03ea8cb9e13b07ecb808862.jpg");
			goodsInfo.put("imgarr", imgarr);
			goodsInfo.put("name", "����վ����վ��������վ");
			goodsInfo.put("des", "����վ����վ���ƿ���������������ϵ�ң�΢�źţ���HHnler��(�����ִ�Сд)");
			goodsInfo.put("price", 0);
			goodsInfo.put("disprice", 0);
			JSONArray contentimgarr = new JSONArray();
			contentimgarr.add("https://imgsa.baidu.com/baike/pic/item/dc54564e9258d10922a39481dd58ccbf6c814d44.jpg");
			contentimgarr.add("https://imgsa.baidu.com/baike/pic/item/dc54564e9258d10922a39481dd58ccbf6c814d44.jpg");
			contentimgarr.add("https://imgsa.baidu.com/baike/pic/item/dc54564e9258d10922a39481dd58ccbf6c814d44.jpg");
			
			goodsInfo.put("contentimgarr", contentimgarr);
			JSONArray hlarr = new JSONArray();
			JSONObject hl = new JSONObject();
			hl.put("type", "��");
			hl.put("name", "��������0����");
			hlarr.add(hl);
			hl.put("type", "����");
			hl.put("name", "����");
			hlarr.add(hl);
			goodsInfo.put("hlarr", hlarr);
			retjson.put("goodsInfo", goodsInfo);
		}
		
		if(id.equals("4")) {
			JSONObject goodsInfo = new JSONObject();
			JSONArray imgarr = new JSONArray();
			imgarr.add("https://gss3.bdstatic.com/-Po3dSag_xI4khGkpoWK1HF6hhy/baike/w%3D268%3Bg%3D0/sign=d6825072ed1190ef01fb95d9f620fa2b/4bed2e738bd4b31cd4b614248dd6277f9f2ff8a3.jpg");
			imgarr.add("https://imgsa.baidu.com/baike/pic/item/dc54564e9258d10922a39481dd58ccbf6c814d44.jpg");
			imgarr.add("https://gss3.bdstatic.com/-Po3dSag_xI4khGkpoWK1HF6hhy/baike/whfpf%3D268%2C152%2C50/sign=bbc60302b13eb1354492e4fbc0239ae5/342ac65c10385343c03ea8cb9e13b07ecb808862.jpg");
			goodsInfo.put("imgarr", imgarr);
			goodsInfo.put("name", "����׿Ӧ�á���׿Ӧ�ÿ���");
			goodsInfo.put("des", "����׿Ӧ�á���׿Ӧ�ö��ƿ���������������ϵ�ң�΢�źţ���HHnler��(�����ִ�Сд)");
			goodsInfo.put("price", 0);
			goodsInfo.put("disprice", 0);
			JSONArray contentimgarr = new JSONArray();
			contentimgarr.add("https://imgsa.baidu.com/baike/pic/item/dc54564e9258d10922a39481dd58ccbf6c814d44.jpg");
			contentimgarr.add("https://imgsa.baidu.com/baike/pic/item/dc54564e9258d10922a39481dd58ccbf6c814d44.jpg");
			contentimgarr.add("https://imgsa.baidu.com/baike/pic/item/dc54564e9258d10922a39481dd58ccbf6c814d44.jpg");
			
			goodsInfo.put("contentimgarr", contentimgarr);
			JSONArray hlarr = new JSONArray();
			JSONObject hl = new JSONObject();
			hl.put("type", "��");
			hl.put("name", "��������0����");
			hlarr.add(hl);
			hl.put("type", "����");
			hl.put("name", "����");
			hlarr.add(hl);
			goodsInfo.put("hlarr", hlarr);
			retjson.put("goodsInfo", goodsInfo);
		}
		
		
		
		retjson.put("errCode", "0000");
		retjson.put("errMSG", "suc");

		System.err.println("getGoodsInfo:retjson-->"+retjson);
		
		return retjson.toString();
	}
	
	@RequestMapping(value = "/getGoodsTree", method = { RequestMethod.POST, RequestMethod.GET },produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getGoodsTree (HttpServletRequest request, HttpServletResponse response){
		JSONObject retjson = new JSONObject();
		String id = request.getParameter("id");
		if(id.equals("1")) {
			JSONArray goodsarr = new JSONArray();
			JSONObject goodsjson = new JSONObject();
			goodsjson.put("id", "1");
			goodsjson.put("name", "��΢��С����΢��С���򿪷�");
			JSONArray imgarr = new JSONArray();
			imgarr.add("http://img.027cgb.com/615537/wxt1.png");
			imgarr.add("http://img.027cgb.com/615537/wxt2.png");
			imgarr.add("http://img.027cgb.com/615537/wxt3.png");
			
			goodsjson.put("imgarr", imgarr);
			goodsjson.put("price", "0");
			goodsjson.put("disprice", "0");
			goodsjson.put("jf", "0");
			goodsjson.put("des", "��΢��С����΢��С�����ƿ���������������ϵ�ң�΢�źţ���HHnler��(�����ִ�Сд)");
			JSONArray contentimgarr = new JSONArray();
			
			contentimgarr.add("http://img.027cgb.com/615537/wxc1.png");
			contentimgarr.add("http://img.027cgb.com/615537/wxc2.png");
			contentimgarr.add("http://img.027cgb.com/615537/wxc3.png");
			
			goodsjson.put("contentimgarr", contentimgarr);
			JSONArray hlarr = new JSONArray();
			JSONObject hl = new JSONObject();
			hl.put("type", "��");
			hl.put("name", "��������0����");
			hlarr.add(hl);
			hl.put("type", "����");
			hl.put("name", "����");
			hlarr.add(hl);
			goodsjson.put("hlarr", hlarr);
			
			goodsarr.add(goodsjson);
			
			goodsjson = new JSONObject();
			goodsjson.put("id", "2");
			goodsjson.put("name", "��΢�Ź��ںš�΢�Ź��ںſ���");
			imgarr = new JSONArray();
			imgarr.add("https://gss3.bdstatic.com/-Po3dSag_xI4khGkpoWK1HF6hhy/baike/w%3D268%3Bg%3D0/sign=d6825072ed1190ef01fb95d9f620fa2b/4bed2e738bd4b31cd4b614248dd6277f9f2ff8a3.jpg");
			imgarr.add("https://imgsa.baidu.com/baike/pic/item/dc54564e9258d10922a39481dd58ccbf6c814d44.jpg");
			imgarr.add("https://gss3.bdstatic.com/-Po3dSag_xI4khGkpoWK1HF6hhy/baike/whfpf%3D268%2C152%2C50/sign=bbc60302b13eb1354492e4fbc0239ae5/342ac65c10385343c03ea8cb9e13b07ecb808862.jpg");
			goodsjson.put("imgarr", imgarr);
			goodsjson.put("price", "0");
			goodsjson.put("disprice", "0");
			goodsjson.put("jf", "0");
			goodsjson.put("des", "��΢�Ź��ںš�΢�Ź��ںŶ��ƿ���������������ϵ�ң�΢�źţ���HHnler��(�����ִ�Сд)");
			contentimgarr = new JSONArray();
			contentimgarr.add("https://imgsa.baidu.com/baike/pic/item/dc54564e9258d10922a39481dd58ccbf6c814d44.jpg");
			contentimgarr.add("https://imgsa.baidu.com/baike/pic/item/dc54564e9258d10922a39481dd58ccbf6c814d44.jpg");
			contentimgarr.add("https://imgsa.baidu.com/baike/pic/item/dc54564e9258d10922a39481dd58ccbf6c814d44.jpg");
			
			goodsjson.put("contentimgarr", contentimgarr);
			hlarr = new JSONArray();
			hl = new JSONObject();
			hl.put("type", "��");
			hl.put("name", "��������0����");
			hlarr.add(hl);
			hl.put("type", "����");
			hl.put("name", "����");
			hlarr.add(hl);
			goodsjson.put("hlarr", hlarr);
			
			goodsarr.add(goodsjson);
			
			retjson.put("goodsarr", goodsarr);
			
		}
		
		if(id.equals("2")) {
			
			
			JSONArray goodsarr = new JSONArray();
			JSONObject goodsjson = new JSONObject();
			goodsjson.put("id", "3");
			goodsjson.put("name", "����վ����վ��������վ");
			JSONArray imgarr = new JSONArray();
			imgarr.add("http://img.027cgb.com/615537/wzt1.png");
			imgarr.add("http://img.027cgb.com/615537/wzt2.png");
			imgarr.add("http://img.027cgb.com/615537/wzt3.png");
			
			goodsjson.put("imgarr", imgarr);
			goodsjson.put("price", "0");
			goodsjson.put("disprice", "0");
			goodsjson.put("jf", "0");
			goodsjson.put("des", "����վ����վ���ƿ���������������ϵ�ң�΢�źţ���HHnler��(�����ִ�Сд)");
			JSONArray contentimgarr = new JSONArray();
			contentimgarr.add("http://img.027cgb.com/615537/wzc1.png");
			contentimgarr.add("http://img.027cgb.com/615537/wzc2.png");

			
			goodsjson.put("contentimgarr", contentimgarr);
			JSONArray hlarr = new JSONArray();
			JSONObject hl = new JSONObject();
			hl.put("type", "��");
			hl.put("name", "��������0����");
			hlarr.add(hl);
			hl.put("type", "����");
			hl.put("name", "����");
			hlarr.add(hl);
			goodsjson.put("hlarr", hlarr);
			
			goodsarr.add(goodsjson);
			retjson.put("goodsarr", goodsarr);
			
		}
		
		if(id.equals("3")) {
			
			JSONArray goodsarr = new JSONArray();
			JSONObject goodsjson = new JSONObject();
			goodsjson.put("id", "4");
			goodsjson.put("name", "����׿Ӧ�á���׿Ӧ�ÿ���");
			JSONArray imgarr = new JSONArray();
			imgarr.add("https://gss3.bdstatic.com/-Po3dSag_xI4khGkpoWK1HF6hhy/baike/w%3D268%3Bg%3D0/sign=356c6916013387449cc5287a6934bec4/d53f8794a4c27d1e11530c8216d5ad6eddc4387a.jpg");

			goodsjson.put("imgarr", imgarr);
			goodsjson.put("price", "0");
			goodsjson.put("disprice", "0");
			goodsjson.put("jf", "0");
			goodsjson.put("des", "����׿Ӧ�á���׿Ӧ�ö��ƿ���������������ϵ�ң�΢�źţ���HHnler��(�����ִ�Сд)");
			JSONArray contentimgarr = new JSONArray();
			contentimgarr.add("http://img.027cgb.com/615537/andt1.jpg");
			contentimgarr.add("http://img.027cgb.com/615537/ant2.jpg");
			
			goodsjson.put("contentimgarr", contentimgarr);
			JSONArray hlarr = new JSONArray();
			JSONObject hl = new JSONObject();
			hl.put("type", "��");
			hl.put("name", "��������0����");
			hlarr.add(hl);
			hl.put("type", "����");
			hl.put("name", "����");
			hlarr.add(hl);
			goodsjson.put("hlarr", hlarr);
			
			goodsarr.add(goodsjson);
			retjson.put("goodsarr", goodsarr);
		}
		retjson.put("errCode", "0000");
		retjson.put("errMSG", "suc");

		System.err.println("getGoodsTree:retjson-->"+retjson);
		
		return retjson.toString();
	}
	
	
	public static void main(String[] args) {
		JSONObject retjson = new JSONObject();
		JSONArray typearr = new JSONArray();
		JSONObject typejson = new JSONObject();
		typejson.put("id", "1");
		typejson.put("name", "΢�ſ���");
		typearr.add(typejson);
		typejson.put("id", "2");
		typejson.put("name", "��վ��վ");
		typearr.add(typejson);
		typejson.put("id", "3");
		typejson.put("name", "��׿����");
		typearr.add(typejson);
		
		
		typearr.add(typejson);
		
		JSONArray goodsarr = new JSONArray();
		JSONObject goodsjson = new JSONObject();
		goodsjson.put("id", "1");
		goodsjson.put("name", "��΢��С����΢��С���򿪷�");
		goodsjson.put("picurl", "https://gss3.bdstatic.com/-Po3dSag_xI4khGkpoWK1HF6hhy/baike/w%3D268%3Bg%3D0/sign=d6825072ed1190ef01fb95d9f620fa2b/4bed2e738bd4b31cd4b614248dd6277f9f2ff8a3.jpg");
		goodsjson.put("price", "0");
		goodsjson.put("disprice", "0");
		goodsjson.put("jf", "0");
		goodsarr.add(goodsjson);
		goodsjson.put("id", "2");
		goodsjson.put("name", "��΢�Ź��ںš�΢�Ź��ںſ���");
		goodsjson.put("picurl", "https://gss3.bdstatic.com/-Po3dSag_xI4khGkpoWK1HF6hhy/baike/w%3D268%3Bg%3D0/sign=d6825072ed1190ef01fb95d9f620fa2b/4bed2e738bd4b31cd4b614248dd6277f9f2ff8a3.jpg");
		goodsjson.put("price", "0");
		goodsjson.put("disprice", "0");
		goodsjson.put("jf", "0");
		goodsarr.add(goodsjson);
		
		
		retjson.put("errCode", "0000");
		retjson.put("errMSG", "suc");
		retjson.put("typearr", typearr);
		retjson.put("goodsarr", goodsarr);
		System.err.println(retjson);
	}
}
