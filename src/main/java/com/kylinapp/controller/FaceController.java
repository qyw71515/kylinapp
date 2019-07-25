/** 
 * Copyright: Copyright (c)2015
 * Company: ����������Ϣ���޹�˾(jxhtxx.com) 
 */
package com.kylinapp.controller;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.net.ssl.SSLException;
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

import com.kylinapp.service.ITab_OCRService;
import com.kylinapp.utils.FileUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author��QYW
 * @since��2019��1��22������3:41:07
 * @description:
 * @version: 1.0
 * @copyright: Copyright (c)2015
 * @company: ����������Ϣ���޹�˾(jxhtxx.com)
 */
@Controller
public class FaceController {
	@Resource
	private ITab_OCRService tab_OCRService;
	
	@RequestMapping(value = "/face", method = { RequestMethod.POST,
			RequestMethod.GET }, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String uploadImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("����get������");
		try {
			MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
			MultipartFile multipartFile = req.getFile("file");
			System.err.println("multipartFile-->" + multipartFile.getSize());
			CommonsMultipartFile commonsmultipartfile = (CommonsMultipartFile) multipartFile;
			DiskFileItem diskFileItem = (DiskFileItem) commonsmultipartfile.getFileItem();
			File file = diskFileItem.getStoreLocation();
			System.err.println("file-->" + file.length());
//			if(file.length() == 0) {
//				file = new File("C:\\Users\\91117\\quicklink\\images\\qyw.jpg");
//			}
			
			String username = request.getParameter("username");
			String usericonurl = request.getParameter("usericonurl");
			Calendar c = Calendar.getInstance();
			SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmss");
			String cjsj = String.valueOf(f.format(c.getTime()));
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("username", username);
			map1.put("usericonurl", usericonurl);
			map1.put("cjsj", cjsj);
			map1.put("code", "0");
			map1.put("message", "OK");
System.err.println(map1);
			if (multipartFile.getSize() < 1000 * 1024) {
				try {
					map1.put("img", multipartFile.getBytes());

					tab_OCRService.insert(map1);

				} catch (Exception e) {
					e.printStackTrace();

				}
			}
			
			
			byte[] buff = FileUtils.getBytesFromFile(file);
			String url = "https://api-cn.faceplusplus.com/facepp/v3/detect";
			HashMap<String, String> map = new HashMap<String, String>();
			HashMap<String, byte[]> byteMap = new HashMap<String, byte[]>();
			map.put("api_key", "sFMMy_BKWlTs4nAi8ZlI4VNjREj1HhHS");
			map.put("api_secret", "H0gszlFcqz72DOYCBTEOYaA5ynuwfs0g");
			map.put("return_landmark", "1");
			map.put("return_attributes",
					"gender,age,smiling,headpose,facequality,blur,eyestatus,emotion,ethnicity,beauty,mouthstatus,eyegaze,skinstatus");
			byteMap.put("image_file", buff);

			byte[] bacd = post(url, map, byteMap);
			String retJsonstr = new String(bacd);
			System.out.println("face:" + retJsonstr);
			
			JSONObject retJson = JSONObject.fromObject(retJsonstr);
			JSONArray facearr = retJson.getJSONArray("faces");
			JSONObject attributes = new JSONObject();
			JSONObject allJson = new JSONObject();
			JSONArray facejsonarr = new JSONArray();
			for(int i=0;i<facearr.size();i++) {
				JSONObject facejson = facearr.getJSONObject(i);
				attributes = facejson.getJSONObject("attributes");
				facejson.clear();
				
				/*
				 * 		 emotion
				 * */
				JSONObject emotion = attributes.getJSONObject("emotion");
				double sadness = emotion.getDouble("sadness");
				double neutral = emotion.getDouble("neutral");
				double disgust = emotion.getDouble("disgust");
				double anger = emotion.getDouble("anger");
				double surprise = emotion.getDouble("surprise");
				double fear = emotion.getDouble("fear");
				double happiness = emotion.getDouble("happiness");
				String emo = "";
				double tempdouble = 0;
				if(sadness > tempdouble) {
					emo = "����";
					tempdouble = sadness;
				}
				if(neutral > tempdouble) {
					emo = "ƽ��";
					tempdouble = neutral;
				}
				if(disgust > tempdouble) {
					emo = "���";
					tempdouble = disgust;
				}
				if(anger > tempdouble) {
					emo = "��ŭ";
					tempdouble = anger;
				}
				if(surprise > tempdouble) {
					emo = "����";
					tempdouble = surprise;
				}
				if(fear > tempdouble) {
					emo = "�־�";
					tempdouble = fear;
				}
				if(happiness > tempdouble) {
					emo = "����";
					tempdouble = happiness;
				}
				facejson.put("emotion", emo);
				
				/*
				 * 		beauty
				 * */
				JSONObject beauty = attributes.getJSONObject("beauty");
				double female_score = beauty.getDouble("female_score");
				double male_score = beauty.getDouble("male_score");
				facejson.put("beauty", female_score>male_score ? String.valueOf(female_score) : String.valueOf(male_score));
				
				/*
				 * 		gender
				 * */
				JSONObject gender = attributes.getJSONObject("gender");
				String genderstr = gender.getString("value");
				facejson.put("gender", "Male".equals(genderstr) ? "����" : "Ů��");
				
				/*
				 * 		age
				 * */
				JSONObject age = attributes.getJSONObject("age");
				facejson.put("age", String.valueOf(age.getString("value")));
				
				/*
				 * 		�첿״̬��Ϣ		
				 * 		mouthstatus
				 * */
				JSONObject mouthstatus = attributes.getJSONObject("mouthstatus");
				double close = mouthstatus.getDouble("close");
				double surgical_mask_or_respirator = mouthstatus.getDouble("surgical_mask_or_respirator");
				double open = mouthstatus.getDouble("open");
				double other_occlusion = mouthstatus.getDouble("other_occlusion");
				emo = "";
				tempdouble = 0;
				if(close > tempdouble) {
					emo = "�첿û���ڵ��ұ���";
					tempdouble = close;
				}
				if(surgical_mask_or_respirator > tempdouble) {
					emo = "�첿��ҽ�ÿ��ֻ���������ڵ�";
					tempdouble = surgical_mask_or_respirator;
				}
				if(open > tempdouble) {
					emo = "�첿û���ڵ����ſ�";
					tempdouble = open;
				}
				if(other_occlusion > tempdouble) {
					emo = "�첿�����������ڵ�";
					tempdouble = other_occlusion;
				}
				facejson.put("mouthstatus", emo);
				
				/*
				 * 		�沿����
				 * 		skinstatus
				 * */
				JSONObject skinstatus = attributes.getJSONObject("skinstatus");
				double dark_circle = skinstatus.getDouble("dark_circle");
				double stain = skinstatus.getDouble("stain");
				double acne = skinstatus.getDouble("acne");
				double health = skinstatus.getDouble("health");
				emo = "";
				if(dark_circle > 60) {
					emo = emo + "�к���Ȧ��";
				}
				if(stain > 60) {
					emo = emo + "��ɫ�ߣ�";
				}
				if(acne > 60) {
					emo = emo + "�ഺ����";
				}
				if(health > 60) {
					emo = emo + "�ȽϽ�����";
				}
				if("".equals(emo)) {
					tempdouble = 0;
					if(dark_circle > tempdouble) {
						emo = "����΢����Ȧ��";
						tempdouble = dark_circle;
					}
					if(stain > tempdouble) {
						emo = "����΢��ɫ�ߣ�";
						tempdouble = stain;
					}
					if(acne > tempdouble) {
						emo = "����΢�ഺ����";
						tempdouble = acne;
					}
					if(dark_circle > tempdouble) {
						emo = "�ȽϽ�����";
						tempdouble = dark_circle;
					}
				}else {
					emo = emo.substring(0, emo.length()-1);
				}
				facejson.put("skinstatus", emo);
				
				/*
				 * 		smile
				 * 		Ц��
				 * */
				
				JSONObject smile = attributes.getJSONObject("smile");
				emo = "";
				double value = smile.getDouble("value");
				double threshold = smile.getDouble("threshold");
				double d = value - threshold;
				if(d <= 0) {
					emo = "Ц�Ⱥ���";
				}
				if(d > 0 && d < 10) {
					emo = "��Ц��Ц";
				}
				if(d >= 10 && d < 20) {
					emo = "ϲüЦ��";
				}
				if(d >= 20 && d < 30) {
					emo = "���溬��";
				}
				if(d >= 30 && d < 40) {
					emo = "ü����Ц";
				}
				if(d >= 40) {
					emo = "ü��ɫ��";
				}
				BigDecimal b = new BigDecimal(d);
				d = b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(); 
				facejson.put("smile", emo + "("+ d +")");
				
				/*
				 * 		ethnicity
				 * 		����
				 * */
				JSONObject ethnicity = attributes.getJSONObject("ethnicity");
				emo = ethnicity.getString("value");
				if("asian".equals(emo.toLowerCase())) {
					emo = "������";
				}
				if("white".equals(emo.toLowerCase())) {
					emo = "����";
				}
				if("black".equals(emo.toLowerCase())) {
					emo = "����";
				}
				facejson.put("ethnicity", emo);
				
				
				/*
				 * 		eyestatus
				 * 		�۲�״̬
				 * */
				JSONObject eyestatus = attributes.getJSONObject("eyestatus");
				JSONObject left_eye_status = eyestatus.getJSONObject("left_eye_status");
				double normal_glass_eye_open = left_eye_status.getDouble("normal_glass_eye_open");
				double no_glass_eye_close = left_eye_status.getDouble("no_glass_eye_close");
				double occlusion = left_eye_status.getDouble("occlusion");
				double no_glass_eye_open = left_eye_status.getDouble("no_glass_eye_open");
				double normal_glass_eye_close = left_eye_status.getDouble("normal_glass_eye_close");
				double dark_glasses = left_eye_status.getDouble("dark_glasses");
				emo = "";
				tempdouble = 0;
				if(normal_glass_eye_open > tempdouble) {
					emo = "�����ͨ�۾�������";
					tempdouble = normal_glass_eye_open;
				}
				if(no_glass_eye_close > tempdouble) {
					emo = "�����۾��ұ���";
					tempdouble = no_glass_eye_close;
				}
				if(occlusion > tempdouble) {
					emo = "�۾����ڵ�";
					tempdouble = occlusion;
				}
				if(no_glass_eye_open > tempdouble) {
					emo = "�����۾�������";
					tempdouble = no_glass_eye_open;
				}
				if(normal_glass_eye_close > tempdouble) {
					emo = "�����ͨ�۾��ұ���";
					tempdouble = normal_glass_eye_close;
				}
				if(dark_glasses > tempdouble) {
					emo = "���ī��";
					tempdouble = dark_glasses;
				}
				facejson.put("left_eye_status", emo);
				JSONObject right_eye_status = eyestatus.getJSONObject("right_eye_status");
				normal_glass_eye_open = right_eye_status.getDouble("normal_glass_eye_open");
				no_glass_eye_close = right_eye_status.getDouble("no_glass_eye_close");
				occlusion = right_eye_status.getDouble("occlusion");
				no_glass_eye_open = right_eye_status.getDouble("no_glass_eye_open");
				normal_glass_eye_close = right_eye_status.getDouble("normal_glass_eye_close");
				dark_glasses = right_eye_status.getDouble("dark_glasses");
				emo = "";
				tempdouble = 0;
				if(normal_glass_eye_open > tempdouble) {
					emo = "�����ͨ�۾�������";
					tempdouble = normal_glass_eye_open;
				}
				if(no_glass_eye_close > tempdouble) {
					emo = "�����۾��ұ���";
					tempdouble = no_glass_eye_close;
				}
				if(occlusion > tempdouble) {
					emo = "�۾����ڵ�";
					tempdouble = occlusion;
				}
				if(no_glass_eye_open > tempdouble) {
					emo = "�����۾�������";
					tempdouble = no_glass_eye_open;
				}
				if(normal_glass_eye_close > tempdouble) {
					emo = "�����ͨ�۾��ұ���";
					tempdouble = normal_glass_eye_close;
				}
				if(dark_glasses > tempdouble) {
					emo = "���ī��";
					tempdouble = dark_glasses;
				}
				facejson.put("right_eye_status", emo);
				facejson.put("no", "��" + (i+1) + "��");
				facejsonarr.add(facejson);
			}
			allJson.put("faces", facejsonarr);
			allJson.put("facecount", facejsonarr.size());
			allJson.put("errCode", "0000");
			allJson.put("errMSG", "suc");
			System.err.println("facecontroller-retjson-->"+allJson);
			
			
			
			
			return allJson.toString();

		} catch (Exception e) {
			JSONObject allJson = new JSONObject();
			allJson.put("faces", null);
			allJson.put("facecount", 0);
			allJson.put("errCode", "0001");
			allJson.put("errMSG", e.getMessage());
			System.err.println("facecontroller-retjson-->"+allJson);
			e.printStackTrace();
			return allJson.toString();
		}
//return "{\"faces\":[{\"emotion\":\"ƽ��\",\"beauty\":\"76.402\",\"gender\":\"����\",\"age\":\"32\",\"mouthstatus\":\"�첿û���ڵ��ұ���\",\"skinstatus\":\"�첿û���ڵ��ұ��ϱȽϽ���\",\"smile\":\"Ц�Ⱥ���(-4.882)\",\"ethnicity\":\"������\",\"left_eye_status\":\"�����۾�������\",\"right_eye_status\":\"�����۾�������\",\"no\":\"��1��\"},{\"emotion\":\"ƽ��\",\"beauty\":\"76.403\",\"gender\":\"����\",\"age\":\"32\",\"mouthstatus\":\"�첿û���ڵ��ұ���\",\"skinstatus\":\"ASIAN\",\"smile\":\"Ц�Ⱥ���(-5.101)\",\"left_eye_status\":\"�����۾�������\",\"right_eye_status\":\"�����۾�������\",\"no\":\"��1��\"}],\"facecount\":2,\"errCode\":\"0000\",\"errMSG\":\"suc\"}";
	}

	private final static int CONNECT_TIME_OUT = 30000;
	private final static int READ_OUT_TIME = 50000;
	private static String boundaryString = getBoundary();

	protected static byte[] post(String url, HashMap<String, String> map, HashMap<String, byte[]> fileMap)
			throws Exception {
		HttpURLConnection conne;
		URL url1 = new URL(url);
		conne = (HttpURLConnection) url1.openConnection();
		conne.setDoOutput(true);
		conne.setUseCaches(false);
		conne.setRequestMethod("POST");
		conne.setConnectTimeout(CONNECT_TIME_OUT);
		conne.setReadTimeout(READ_OUT_TIME);
		conne.setRequestProperty("accept", "*/*");
		conne.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundaryString);
		conne.setRequestProperty("connection", "Keep-Alive");
		conne.setRequestProperty("user-agent", "Mozilla/4.0 (compatible;MSIE 6.0;Windows NT 5.1;SV1)");
		DataOutputStream obos = new DataOutputStream(conne.getOutputStream());
		Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, String> entry = iter.next();
			String key = entry.getKey();
			String value = entry.getValue();
			obos.writeBytes("--" + boundaryString + "\r\n");
			obos.writeBytes("Content-Disposition: form-data; name=\"" + key + "\"\r\n");
			obos.writeBytes("\r\n");
			obos.writeBytes(value + "\r\n");
		}
		if (fileMap != null && fileMap.size() > 0) {
			Iterator<Map.Entry<String, byte[]>> fileIter = fileMap.entrySet().iterator();
			while (fileIter.hasNext()) {
				Map.Entry<String, byte[]> fileEntry = (Map.Entry<String, byte[]>) fileIter.next();
				obos.writeBytes("--" + boundaryString + "\r\n");
				obos.writeBytes("Content-Disposition: form-data; name=\"" + fileEntry.getKey() + "\"; filename=\""
						+ encode(" ") + "\"\r\n");
				obos.writeBytes("\r\n");
				obos.write(fileEntry.getValue());
				obos.writeBytes("\r\n");
			}
		}
		obos.writeBytes("--" + boundaryString + "--" + "\r\n");
		obos.writeBytes("\r\n");
		obos.flush();
		obos.close();
		InputStream ins = null;
		int code = conne.getResponseCode();
		try {
			if (code == 200) {
				ins = conne.getInputStream();
			} else {
				ins = conne.getErrorStream();
			}
		} catch (SSLException e) {
			e.printStackTrace();
			return new byte[0];
		}
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buff = new byte[4096];
		int len;
		while ((len = ins.read(buff)) != -1) {
			baos.write(buff, 0, len);
		}
		byte[] bytes = baos.toByteArray();
		ins.close();
		return bytes;
	}

	private static String getBoundary() {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 32; ++i) {
			sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_-".charAt(
					random.nextInt("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_".length())));
		}
		return sb.toString();
	}

	private static String encode(String value) throws Exception {
		return URLEncoder.encode(value, "UTF-8");
	}
}
