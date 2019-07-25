/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.kylinapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kylinapp.model.Tab_MessageBoard;
import com.kylinapp.service.ITab_MessageBoardService;
import com.kylinapp.utils.TimeUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**    
 * @author：QYW   
 * @since：2019年1月21日上午10:31:01
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com) 
 */
@Controller
@RequestMapping(value = "/messageBoard")
public class MessageBoardController {
	@Resource
	private ITab_MessageBoardService tab_MessageBoardService;
	
	@RequestMapping(value = "/submitMes", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String submitMes(HttpServletRequest request) throws InterruptedException {
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String usericon = request.getParameter("usericon");
		String message = request.getParameter("message");
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("uuid", UUID.randomUUID().toString());
		map.put("userid", userid);
		map.put("username", username);
		map.put("usericon", usericon);
		map.put("messageContent", message);
		map.put("timestamp", System.currentTimeMillis());
		map.put("time", TimeUtil.getTime());

		JSONObject alljson = new JSONObject();
		tab_MessageBoardService.submitMes(map);
		
		map.put("start", 0);
		
		List<Tab_MessageBoard> mesBoardList = tab_MessageBoardService.getMesListByPage(map);
		JSONArray jarr = new JSONArray();
		if(mesBoardList != null) {
			for(Tab_MessageBoard mes : mesBoardList) {
				JSONObject mesJson = new JSONObject();
				mesJson.put("userName", mes.getUsername());
				String time = mes.getTime();
				time = TimeUtil.timeFormat(time);
				mesJson.put("time", time);
				mesJson.put("userIcon", mes.getUsericon());
				mesJson.put("mesContent", mes.getMessagecontent());
				jarr.add(mesJson);
			}
		}
		
		map.clear();
		int mesCount = tab_MessageBoardService.getCount(map);
		
		alljson.put("count", mesCount);
		alljson.put("retCode", "0000");
		alljson.put("errMSG", "suc");
		alljson.put("message", jarr);
		
		return alljson.toString();
	}
	
	@RequestMapping(value = "/getMesList", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getMesList(HttpServletRequest request) throws InterruptedException {
		
		JSONObject retjson = new JSONObject();
		String page = request.getParameter("page");
		try {
			int p = Integer.parseInt(page);
			int start = (p - 1) * 5;
			
			Map<String,Object> map = new HashMap<String, Object>();
			
			map.put("start", start);
			
			List<Tab_MessageBoard> mesBoardList = tab_MessageBoardService.getMesListByPage(map);
			JSONArray jarr = new JSONArray();
			if(mesBoardList != null) {
				for(Tab_MessageBoard mes : mesBoardList) {
					JSONObject mesJson = new JSONObject();
					mesJson.put("userName", mes.getUsername());
					String time = mes.getTime();
					time = TimeUtil.timeFormat(time);
					mesJson.put("time", time);
					mesJson.put("userIcon", mes.getUsericon());
					mesJson.put("mesContent", mes.getMessagecontent());
					jarr.add(mesJson);
				}
			}
			
			map.clear();
			int mesCount = tab_MessageBoardService.getCount(map);
			
			retjson.put("count", mesCount);
			retjson.put("retCode", "0000");
			retjson.put("errMSG", "suc");
			retjson.put("message", jarr);
		}catch(NumberFormatException e) {
			retjson.put("retCode", "0001");
			retjson.put("errMSG", "没有页码");
		}
		
		return retjson.toString();
	}
}
