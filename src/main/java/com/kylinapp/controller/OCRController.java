/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.kylinapp.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.kylinapp.constant.Constant;
import com.kylinapp.model.TAB_OCR;
import com.kylinapp.service.ITab_OCRService;
import com.qcloud.image.ImageClient;
import com.qcloud.image.exception.AbstractImageException;
import com.qcloud.image.request.GeneralOcrRequest;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**    
 * @author：QYW   
 * @since：2018年12月29日上午10:17:59
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com) 
 */
@Controller
public class OCRController {
	@Resource
	private ITab_OCRService tab_OCRService;

	@RequestMapping(value = "/ocr", method = { RequestMethod.POST, RequestMethod.GET },produces = "application/json; charset=utf-8")
	@ResponseBody
	public String uploadImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("进入get方法！");

		MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = req.getFile("file");
		CommonsMultipartFile commonsmultipartfile = (CommonsMultipartFile) multipartFile;
		DiskFileItem diskFileItem = (DiskFileItem) commonsmultipartfile.getFileItem();
		File file = diskFileItem.getStoreLocation();
		System.err.println("file-->" + file.length());

		ImageClient imageClient = new ImageClient(Constant.ocr_appId, Constant.ocr_secretId, Constant.ocr_secretKey,
				ImageClient.NEW_DOMAIN_recognition_image_myqcloud_com/* 根据文档说明选择域名 */);

		String ret = null;

		System.out.println("====================================================");
		GeneralOcrRequest generalOcrRequest = new GeneralOcrRequest(Constant.ocr_bucketName, file);
		try {
			ret = imageClient.generalOcr(generalOcrRequest);
		} catch (AbstractImageException e) {
			e.printStackTrace();
		}
		System.out.println("ocrGeneral:" + ret);

		JSONObject json = JSONObject.fromObject(ret);
		int code = json.getInt("code");
		String message = json.getString("message");

		String username = request.getParameter("username");
		String usericonurl = request.getParameter("usericonurl");
		Calendar c = Calendar.getInstance();
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmss");
		String cjsj = String.valueOf(f.format(c.getTime()));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", username);
		map.put("usericonurl", usericonurl);
		map.put("cjsj", cjsj);
		map.put("code", code);
		map.put("message", message);

		if (multipartFile.getSize() < 1000 * 1024) {
			try {
				map.put("img", multipartFile.getBytes());

				tab_OCRService.insert(map);

			} catch (Exception e) {
				e.printStackTrace();

			}
		}

		if (file.exists()) {
			file.delete();
		}

		if(code == 0) {
			String retContent = "";
			json = json.getJSONObject("data");
			JSONArray jsonarr = new JSONArray();
			jsonarr = json.getJSONArray("items");
			int charCount = 0;
			for(int i=0;i<jsonarr.size();i++) {
				JSONObject j = jsonarr.getJSONObject(i);
				charCount = charCount + j.getString("itemstring").length();
				retContent = retContent + j.getString("itemstring") + "\n";
			}
			JSONObject retjson = new JSONObject();
			retjson.put("code", code);
			retjson.put("message", message);
			retjson.put("retContent", retContent);
			retjson.put("charCount", charCount);
			System.err.println(retjson.toString());
			return retjson.toString();
		}
		imageClient.shutdown();
		return ret;
	}

	
	
	@RequestMapping(value = "/getImg")
	public void getImg(HttpServletRequest request,HttpServletResponse response) {
		System.err.println("come getImg....");
		try {
			String id = (String) request.getParameter("id");
			
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("id", id);
			
			System.err.println("获取图片参数map-->"+map);
			
			List<TAB_OCR> TAB_OCRlist = tab_OCRService.getImgList(map);
			TAB_OCR TAB_OCR= TAB_OCRlist.get(0);
			byte[] b = TAB_OCR.getImg();
//			if(b!=null&&b.length>0) {
//				response.setContentType("img/jpeg");
//		    	response.setCharacterEncoding("utf-8");
//		    	String filename = TAB_OCR.getCjsj()+"jpg";
//		    	response.setHeader("Content-Disposition","attachment;"+filename);  
//				OutputStream outputStream=response.getOutputStream();
//				InputStream in=new ByteArrayInputStream(b);
//				
//				int len=0;
//				byte[]buf=new byte[1024];
//				while((len=in.read(buf,0,1024))!=-1){
//					outputStream.write(buf, 0, len);
//				}
//				outputStream.close();
//			}
			if(b!=null&&b.length>0) {
				response.setContentType("img/jpeg");
		    	response.setCharacterEncoding("utf-8");
				OutputStream outputStream=response.getOutputStream();
				InputStream in=new ByteArrayInputStream(b);
				
				int len=0;
				byte[]buf=new byte[1024];
				while((len=in.read(buf,0,1024))!=-1){
					outputStream.write(buf, 0, len);
				}
				outputStream.close();
			}
	    	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
