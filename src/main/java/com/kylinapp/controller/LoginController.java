/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.kylinapp.controller;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kylinapp.constant.Constant;
import com.kylinapp.service.ITAB_WXAPPUSERService;
import com.kylinapp.utils.SendPost;
import com.kylinapp.utils.WxUtil;

import net.sf.json.JSONObject;

/**
 * @author：QYW
 * @since：2018年12月27日上午11:19:57
 * @description:
 * @version: 1.0
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com)
 */
@Controller
public class LoginController {
	@Resource
	private ITAB_WXAPPUSERService iTAB_WXAPPUSERService;

	/**   
	 * @Title: wxLogin   
	 * @Description: 微信小程序登录
	 * @param: @param model
	 * @param: @param code
	 * @param: @param rawData
	 * @param: @param signature
	 * @param: @param encrypteData
	 * @param: @param iv
	 * @param: @return      
	 * @return: Map<String,Object>      
	 * @throws   
	 */
	@RequestMapping(value = "/wxLogin", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Map<String, Object> wxLogin(Model model, @RequestParam(value = "code", required = false) String code,
			@RequestParam(value = "rawData", required = false) String rawData,
			@RequestParam(value = "signature", required = false) String signature,
			@RequestParam(value = "encrypteData", required = false) String encrypteData,
			@RequestParam(value = "iv", required = false) String iv) {
		System.err.println("Start get SessionKey");

		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("用户非敏感信息" + rawData);
		JSONObject rawDataJson = JSONObject.fromObject(rawData);

		System.out.println("签名" + signature);

		String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
		String param = "appid=" + Constant.wx_app_appid + "&secret=" + Constant.wx_app_secret + "&js_code=" + code
				+ "&grant_type=authorization_code";

		// 发送post请求读取调用微信接口获取openid用户唯一标识
		JSONObject SessionKeyOpenId = JSONObject.fromObject(SendPost.sendPost(requestUrl, param, "utf-8"));
		System.out.println("post请求获取的SessionAndopenId=" + SessionKeyOpenId);

		String openid = SessionKeyOpenId.getString("openid");

		String sessionKey = SessionKeyOpenId.getString("session_key");

		System.out.println("openid=" + openid + ",session_key=" + sessionKey);

		String nickName = rawDataJson.getString("nickName");
		String avatarUrl = rawDataJson.getString("avatarUrl");
		String gender = rawDataJson.getString("gender");
		String city = rawDataJson.getString("city");
		String country = rawDataJson.getString("country");
		String province = rawDataJson.getString("province");

		Calendar c = Calendar.getInstance();
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmss");
		String time = String.valueOf(f.format(c.getTime()));
		
		String timestamp = String.valueOf(System.currentTimeMillis());
		
		String uuid = UUID.randomUUID().toString();
		
		map.put("uuid", uuid);
		map.put("uid", openid);
		map.put("createtimestamp", timestamp);
		map.put("createtime", time);
		map.put("sessionkey", openid);
		map.put("ubalance", 0);
		map.put("skey", uuid);
		map.put("uaddress", country + "," + province + "," + city);
		map.put("uavatar", avatarUrl);
		map.put("ugender", Integer.parseInt(gender));
		map.put("uname", nickName);
		map.put("updatetimestamp", timestamp);
		map.put("updatetime", time);
		
		iTAB_WXAPPUSERService.insertOrUpdateWxappuser(map);
		
		// 把新的sessionKey和oppenid返回给小程序
		map.clear();
		map.put("userID", uuid);
		map.put("openid", openid);

		map.put("result", "0");

		JSONObject userInfo = WxUtil.getUserInfo(encrypteData, sessionKey, iv);
		System.out.println("根据解密算法获取的userInfo=" + userInfo);
		userInfo.put("balance", 0);
		map.put("userInfo", userInfo);

		return map;
	}

	
	@RequestMapping(value = "/wxKylinLogin", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Map<String, Object> wxKylinLogin(Model model, @RequestParam(value = "code", required = false) String code,
			@RequestParam(value = "rawData", required = false) String rawData,
			@RequestParam(value = "signature", required = false) String signature,
			@RequestParam(value = "encrypteData", required = false) String encrypteData,
			@RequestParam(value = "iv", required = false) String iv) {
		System.err.println("Start get SessionKey");

		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("用户非敏感信息" + rawData);
		JSONObject rawDataJson = JSONObject.fromObject(rawData);

		System.out.println("签名" + signature);

		String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
		String param = "appid=" + Constant.wx_app_Kylin_appid + "&secret=" + Constant.wx_app_Kylin_secret + "&js_code=" + code
				+ "&grant_type=authorization_code";

		// 发送post请求读取调用微信接口获取openid用户唯一标识
		JSONObject SessionKeyOpenId = JSONObject.fromObject(SendPost.sendPost(requestUrl, param, "utf-8"));
		System.out.println("post请求获取的SessionAndopenId=" + SessionKeyOpenId);

		String openid = SessionKeyOpenId.getString("openid");

		String sessionKey = SessionKeyOpenId.getString("session_key");

		System.out.println("openid=" + openid + ",session_key=" + sessionKey);

		String nickName = rawDataJson.getString("nickName");
		String avatarUrl = rawDataJson.getString("avatarUrl");
		String gender = rawDataJson.getString("gender");
		String city = rawDataJson.getString("city");
		String country = rawDataJson.getString("country");
		String province = rawDataJson.getString("province");

		Calendar c = Calendar.getInstance();
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmss");
		String time = String.valueOf(f.format(c.getTime()));
		
		String timestamp = String.valueOf(System.currentTimeMillis());
		
		String uuid = UUID.randomUUID().toString();
		
		map.put("uuid", uuid);
		map.put("uid", openid);
		map.put("createtimestamp", timestamp);
		map.put("createtime", time);
		map.put("sessionkey", openid);
		map.put("ubalance", 0);
		map.put("skey", uuid);
		map.put("uaddress", country + "," + province + "," + city);
		map.put("uavatar", avatarUrl);
		map.put("ugender", Integer.parseInt(gender));
		map.put("uname", nickName);
		map.put("updatetimestamp", timestamp);
		map.put("updatetime", time);
		
		iTAB_WXAPPUSERService.insertOrUpdateWxappuser(map);
		
		// 把新的sessionKey和oppenid返回给小程序
		map.clear();
		map.put("userID", uuid);

		map.put("result", "0");

		JSONObject userInfo = WxUtil.getUserInfo(encrypteData, sessionKey, iv);
		System.out.println("根据解密算法获取的userInfo=" + userInfo);
		userInfo.put("balance", 0);
		map.put("userInfo", userInfo);

		return map;
	}


	
}