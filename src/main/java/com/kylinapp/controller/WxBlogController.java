/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.kylinapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kylinapp.model.TAB_WXARTICLE;
import com.kylinapp.model.TAB_WXBLOGCATEGORY;
import com.kylinapp.model.TAB_WxArticleLike;
import com.kylinapp.model.TAB_WxArticleMessage;
import com.kylinapp.service.ITAB_WXBLOGCATEGORYService;
import com.kylinapp.service.ITAB_WxArticleMessageService;
import com.kylinapp.service.ITAB_WxArticlePageViewService;
import com.kylinapp.service.ITAB_WxArticleService;
import com.kylinapp.service.ITAB_WxArticlelikeService;
import com.kylinapp.utils.TimeUtil;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author：QYW
 * @since：2018年12月28日上午9:32:15
 * @description:
 * @version: 1.0
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com)
 */
@Controller
@RequestMapping(value = "/wxblog")
public class WxBlogController {
	@Resource
	private ITAB_WXBLOGCATEGORYService iTAB_WXBLOGCATEGORYService;
	@Resource
	private ITAB_WxArticleService iTAB_WxArticleService;
	@Resource
	private ITAB_WxArticlelikeService iTAB_WxArticlelikeService;
	@Resource
	private ITAB_WxArticleMessageService iTAB_WxArticleMessageService;
	@Resource
	private ITAB_WxArticlePageViewService iTAB_WxArticlePageViewService;

	@RequestMapping(value = "/getBolgCategoryList", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getBolgCategoryList(HttpServletRequest request) throws InterruptedException {
		String tabtap_num = request.getParameter("tabtap_num");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", tabtap_num);
		List<TAB_WXBLOGCATEGORY> categoryList = iTAB_WXBLOGCATEGORYService.getBolgCategoryList(map);

		JSONObject json = new JSONObject();
		JSONArray data1 = new JSONArray();
		JSONArray data2 = new JSONArray();
		JSONArray data3 = new JSONArray();

		for (TAB_WXBLOGCATEGORY category : categoryList) {
			json.clear();
			String categoryName = category.getCategoryName();
			String categoryIcon = category.getCategoryIcon();
			String categoryDescription = category.getCategoryDescription();
			String articleTotle = category.getArticleTotle();
			String id = category.getId();
			String type = category.getType();
			if (categoryDescription.length() > 15) {
				categoryDescription = categoryDescription.substring(0, 13) + "...";
			}
			if (categoryName.length() > 7) {
				categoryDescription = categoryDescription.substring(0, 7) + "...";
			}
			if ("3".equals(tabtap_num)) {
				articleTotle = articleTotle + "张";
			} else {
				articleTotle = articleTotle + "篇";
			}

			json.put("categoryName", categoryName);
			json.put("categoryIcon", categoryIcon);
			json.put("categoryDescription", categoryDescription);
			json.put("articleTotle", articleTotle);
			json.put("id", id);

			if ("1".equals(type)) {
				data1.add(json);
			}
			if ("2".equals(type)) {
				data2.add(json);
			}
			if ("3".equals(type)) {
				data3.add(json);
			}

		}

		json.clear();
		json.put("data1", data1);
		json.put("data2", data2);
		json.put("data3", data3);
		System.err.println("getBolgCategoryList,json-->" + json.toString());
		return json.toString();

	}

	@RequestMapping(value = "/getArticleList", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getArticleList(HttpServletRequest request) throws InterruptedException {
		String categoryid = request.getParameter("id");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("categoryid", categoryid);
		List<TAB_WXARTICLE> articlelist = iTAB_WxArticleService.getArticleList(map);
		JSONObject json = new JSONObject();
		JSONArray datas = new JSONArray();
		for (TAB_WXARTICLE articleinfo : articlelist) {
			String id = articleinfo.getId();
			String title = articleinfo.getTitle();
			String timestamp = articleinfo.getTimestamp();
			String imgurl = articleinfo.getImgurl();
			String like = articleinfo.getLikes();
			String pageViews = articleinfo.getPageViews();
			System.err.println(timestamp);
			timestamp = TimeUtil.leadTime(timestamp);
			like = like + "人喜欢";
			pageViews = pageViews + "人阅读";

			json.put("id", id);
			json.put("title", title);
			json.put("time", timestamp);
			json.put("imgurl", imgurl);
			json.put("like", like);
			json.put("pageViews", pageViews);
			datas.add(json);
		}

		JSONObject category = new JSONObject();
		map.clear();
		map.put("id", categoryid);
		List<TAB_WXBLOGCATEGORY> clist = iTAB_WXBLOGCATEGORYService.getBolgCategoryList(map);

		TAB_WXBLOGCATEGORY c = clist.get(0);
		String categoryName = c.getCategoryName();
		String categoryIcon = c.getCategoryIcon();
		String categoryDescription = c.getCategoryDescription();
		String articleTotle = c.getArticleTotle();

		category.put("categoryName", categoryName);
		category.put("categoryIcon", categoryIcon);
		category.put("categoryDescription", categoryDescription);
		category.put("articleTotle", articleTotle);

		json.clear();
		json.put("datas", datas);
		json.put("category", category);
		return json.toString();
	}

	@RequestMapping(value = "/getArticlePageData", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getArticlePageData(HttpServletRequest request) throws InterruptedException {
		String articleid = request.getParameter("articleid");
		String openid = request.getParameter("openid");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("articleid", articleid);
		map.put("flag", 1);

		System.err.println("getWxArticleLikeList-->"+map);
		
		JSONObject alljson = new JSONObject();
		JSONObject json = new JSONObject();
		JSONArray datas = new JSONArray();

		List<TAB_WxArticleLike> articleLikeList = iTAB_WxArticlelikeService.getWxArticleLikeList(map);
		boolean isUserLike = false;

		if (articleLikeList != null && articleLikeList.size() > 0) {
			int i = 0;
			for (TAB_WxArticleLike articlelike : articleLikeList) {
				String openidtemp = articlelike.getOpenid();
				if (openid.equals(openidtemp)) {
					isUserLike = true;
				}
				if (i < 4) {
					String id = articlelike.getId();
					String username = articlelike.getUsername();
					String usericonurl = articlelike.getUsericonurl();

					json.clear();
					json.put("id", id);
					json.put("username", username);
					json.put("usericonurl", usericonurl);
					datas.add(json);
				}
				i++;
			}
			alljson.put("likelist", datas);

		}

		List<TAB_WXARTICLE> articlelist = iTAB_WxArticleService.getArticleList(map);
		if (articlelist != null) {
			TAB_WXARTICLE articleInfo = articlelist.get(0);
			if (articleInfo != null) {
				json.clear();
				String id = articleInfo.getId();
				String title = articleInfo.getTitle();
				String timestamp = articleInfo.getTimestamp();
				String imgurl = articleInfo.getImgurl();
				String like = articleInfo.getLikes();
				String pageViews = articleInfo.getPageViews();
				String messageCount = articleInfo.getMessageCount();
				System.err.println(timestamp);
				timestamp = TimeUtil.leadTime(timestamp);

				json.put("id", id);
				json.put("title", title);
				json.put("time", timestamp);
				json.put("imgurl", imgurl);
				json.put("like", like);
				json.put("pageViews", pageViews);
				json.put("messageCount", messageCount);
				json.put("articleid", "article" + id);
				json.put("isUserLike", isUserLike);

				alljson.put("articleinfo", json);
			}
		}

		int start = 0;

		map.put("start", start);

		List<TAB_WxArticleMessage> amList = iTAB_WxArticleMessageService.getArticleMessageList(map);
		if (amList != null) {
			datas.clear();
			for (TAB_WxArticleMessage am : amList) {
				String id = am.getId();
				String username = am.getUsername();
				String usericonurl = am.getUsericonurl();
				String messageContent = am.getMessageContent();
				String timestamp = am.getTimestamp();

				timestamp = TimeUtil.leadTime(timestamp);

				json.clear();
				json.put("id", id);
				json.put("username", username);
				json.put("usericonurl", usericonurl);
				json.put("messageContent", messageContent);
				json.put("time", timestamp);

				datas.add(json);

			}
			alljson.put("articleMessage", datas);

		}

		System.err.println(alljson.toString());
		
		return alljson.toString();

	}

	@RequestMapping(value = "/userViewArticle", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String userViewArticle(HttpServletRequest request) throws InterruptedException {
		String articleid = request.getParameter("articleid");
		String username = request.getParameter("username");

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("articleid", Integer.parseInt(articleid));
		map.put("username", username);
		map.put("timestamp", System.currentTimeMillis());
		map.put("time", TimeUtil.getTime());

		JSONObject alljson = new JSONObject();
		alljson = iTAB_WxArticlePageViewService.userViewArticle(map);
		alljson.put("errCode", "0000");

		return alljson.toString();
	}

	@RequestMapping(value = "/userLikeArticle", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String userLikeArticle(HttpServletRequest request) throws InterruptedException {
		String articleid = request.getParameter("articleid");
		String openid = request.getParameter("openid");
		String username = request.getParameter("username");
		String usericonurl = request.getParameter("usericonurl");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("articleid", Integer.parseInt(articleid));
		map.put("openid", openid);
		map.put("username", username);
		map.put("usericonurl", usericonurl);
		map.put("timestamp", System.currentTimeMillis());
		map.put("time", TimeUtil.getTime());
		map.put("flag", 1);

		JSONObject alljson = new JSONObject();
		boolean b = iTAB_WxArticlelikeService.userLikeArticle(map);

		if (b) {
			alljson.put("retCode", "0000");
			alljson.put("errMSG", "suc");
		} else {
			alljson.put("retCode", "0001");
		}

		map.clear();
		map.put("articleid", articleid);
		map.put("flag", 1);
		List<TAB_WxArticleLike> likeList = iTAB_WxArticlelikeService.getWxArticleLikeList(map);
		if (likeList != null) {
			JSONObject json = new JSONObject();
			JSONArray datas = new JSONArray();
			int k = likeList.size();
			if (k > 4) {
				k = 4;
			}
			for (int i = 0; i < k; i++) {
				TAB_WxArticleLike l = likeList.get(i);
				String id = l.getId();
				username = l.getUsername();
				usericonurl = l.getUsericonurl();

				json.clear();
				json.put("id", id);
				json.put("username", username);
				json.put("usericonurl", usericonurl);
				datas.add(json);

			}
			alljson.put("likelist", datas);
		}

		return alljson.toString();
	}

	@RequestMapping(value = "/userUnLikeArticle", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String userUnLikeArticle(HttpServletRequest request) throws InterruptedException {
		String articleid = request.getParameter("articleid");
		String openid = request.getParameter("openid");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("articleid", Integer.parseInt(articleid));
		map.put("openid", openid);
		map.put("timestamp", System.currentTimeMillis());
		map.put("time", TimeUtil.getTime());
		map.put("flag", 0);

		JSONObject alljson = new JSONObject();
		boolean b = iTAB_WxArticlelikeService.userUnLikeArticle(map);

		if (b) {
			alljson.put("retCode", "0000");
			alljson.put("errMSG", "suc");
		} else {
			alljson.put("retCode", "0001");
		}

		List<TAB_WxArticleLike> likeList = iTAB_WxArticlelikeService.getWxArticleLikeList(map);
		if (likeList != null) {
			JSONObject json = new JSONObject();
			JSONArray datas = new JSONArray();
			int k = likeList.size();
			if (k > 4) {
				k = 4;
			}
			for (int i = 0; i < k; i++) {
				TAB_WxArticleLike l = likeList.get(i);
				String id = l.getId();
				String username = l.getUsername();
				String usericonurl = l.getUsericonurl();

				json.clear();
				json.put("id", id);
				json.put("username", username);
				json.put("usericonurl", usericonurl);
				datas.add(json);

			}
			alljson.put("likelist", datas);
		}

		return alljson.toString();
	}

	@RequestMapping(value = "/getArticleMessageList", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getArticleMessageList(HttpServletRequest request) throws InterruptedException {
		String articleid = request.getParameter("articleid");
		String page = request.getParameter("page");
		int i = 2;
		if (page != null && !page.equals("null") && !page.equals("")) {
			i = Integer.parseInt(page);
		}
		int start = (i - 1) * 5;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("articleid", articleid);
		map.put("start", start);

		List<TAB_WxArticleMessage> amList = iTAB_WxArticleMessageService.getArticleMessageList(map);
		JSONObject json = new JSONObject();
		JSONArray datas = new JSONArray();
		for (TAB_WxArticleMessage am : amList) {
			String id = am.getId();
			String username = am.getUsername();
			String usericonurl = am.getUsericonurl();
			String messageContent = am.getMessageContent();
			String timestamp = am.getTimestamp();

			timestamp = TimeUtil.leadTime(timestamp);

			json.put("id", id);
			json.put("username", username);
			json.put("usericonurl", usericonurl);
			json.put("messageContent", messageContent);
			json.put("time", timestamp);

			datas.add(json);
		}

		json.clear();
		json.put("datas", datas);
		System.err.println(json.toString());
		return json.toString();

	}
	
	
	@RequestMapping(value = "/submitMes", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String submitMes(HttpServletRequest request) throws InterruptedException {
		String articleid = request.getParameter("articleid");
		String openid = request.getParameter("openid");
		String username = request.getParameter("username");
		String usericonurl = request.getParameter("usericonurl");
		String messageContent =  request.getParameter("mescontent");
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("articleid", Integer.parseInt(articleid));
		map.put("openid", openid);
		map.put("username", username);
		map.put("usericonurl", usericonurl);
		map.put("timestamp", System.currentTimeMillis());
		map.put("time", TimeUtil.getTime());
		map.put("messageContent", messageContent);
		
		
		JSONObject alljson = new JSONObject();
		boolean b = iTAB_WxArticleMessageService.submitMes(map);
		
		if(b) {
			alljson.put("retCode", "0000");
			alljson.put("errMSG", "suc");
		}else {
			alljson.put("retCode", "0001");
		}
		
		
		int start = 0;
		
		map.put("start", start);
		
		List<TAB_WxArticleMessage> amList = iTAB_WxArticleMessageService.getArticleMessageList(map);
		if(amList!=null) {
			JSONObject json = new JSONObject();
			JSONArray datas = new JSONArray();
			datas.clear();
			for(TAB_WxArticleMessage am : amList) {
				String id = am.getId();
				username = am.getUsername();
				usericonurl = am.getUsericonurl();
				messageContent = am.getMessageContent();
				String timestamp = am.getTimestamp();
				
				
				timestamp = TimeUtil.leadTime(timestamp);
				
				json.clear();
				json.put("id", id);
				json.put("username", username);
				json.put("usericonurl",usericonurl );
				json.put("messageContent",messageContent );
				json.put("time",timestamp );
				
				datas.add(json);		
				
			}
			alljson.put("articleMessage", datas);
			
		}
		
		return alljson.toString();
	}
	
	
	@RequestMapping(value = "/autoRead")
	public void autoRead(HttpServletRequest request,HttpServletResponse response) {
		/*
		 *	每小时访问一次 
		 * 
		 * */
		
		
		/*
		 * 头像、用户名 部分
		 * */
		//初始化所有用户头像姓名
		List<Map<String,Object>> usermaplist = new ArrayList<Map<String,Object>>();
		
		Map<String,Object> userMap = new HashMap<String,Object>();
		userMap.put("username", "小火慢炖");
		userMap.put("usericonurl", "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2146761402,1067578465&fm=200&gp=0.jpg");
		usermaplist.add(userMap);
		
		userMap = new HashMap<String,Object>();
		userMap.put("username", "雾-雨-冰");
		userMap.put("usericonurl", "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1554523034,2873630108&fm=27&gp=0.jpg");
		usermaplist.add(userMap);
		
		userMap = new HashMap<String,Object>();
		userMap.put("username", "Meiya");
		userMap.put("usericonurl", "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1899397357,205586921&fm=27&gp=0.jpg");
		usermaplist.add(userMap);
		
		userMap = new HashMap<String,Object>();
		userMap.put("username", "呐，儭儭");
		userMap.put("usericonurl", "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=351738933,3891844453&fm=27&gp=0.jpg");
		usermaplist.add(userMap);
		
		userMap = new HashMap<String,Object>();
		userMap.put("username", "加菲");
		userMap.put("usericonurl", "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3201621160,2437860141&fm=27&gp=0.jpg");
		usermaplist.add(userMap);
		
		userMap = new HashMap<String,Object>();
		userMap.put("username", "发呆");
		userMap.put("usericonurl", "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2496579759,1019997771&fm=27&gp=0.jpg");
		usermaplist.add(userMap);
		
		userMap = new HashMap<String,Object>();
		userMap.put("username", "好好好");
		userMap.put("usericonurl", "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2030012986,1102835514&fm=200&gp=0.jpg");
		usermaplist.add(userMap);
		
		userMap = new HashMap<String,Object>();
		userMap.put("username", "布布");
		userMap.put("usericonurl", "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3050062956,3206782346&fm=27&gp=0.jpg");
		usermaplist.add(userMap);
		
		userMap = new HashMap<String,Object>();
		userMap.put("username", "绿野");
		userMap.put("usericonurl", "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2207775671,3149697113&fm=27&gp=0.jpg");
		usermaplist.add(userMap);
		
		userMap = new HashMap<String,Object>();
		userMap.put("username", "零感");
		userMap.put("usericonurl", "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=841057785,3646182642&fm=200&gp=0.jpg");
		usermaplist.add(userMap);
		
		userMap = new HashMap<String,Object>();
		userMap.put("username", "Who Left");
		userMap.put("usericonurl", "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3058039098,3086037001&fm=117&gp=0.jpg");
		usermaplist.add(userMap);
		
		userMap = new HashMap<String,Object>();
		userMap.put("username", "roger");
		userMap.put("usericonurl", "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1717056030,451974468&fm=200&gp=0.jpg");
		usermaplist.add(userMap);
		
		
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		//随机选择一个用户头像和用户名
		int ir = (int)(Math.random()*usermaplist.size());
		userMap = usermaplist.get(ir);
		
		
		
		
		/*
		 * 留言部分 
		 * */
		//初始化所有留言
		List<String> meslist = new ArrayList<String>();
		meslist.add("厉害了我的哥");
		meslist.add("厉害，厉害");
		meslist.add("666666");
		meslist.add("感谢分享");
		meslist.add("可以可以");
		meslist.add("666");
		meslist.add("加油");
		meslist.add("说的啥");
		meslist.add("一头雾水");
		meslist.add("赞赞赞");
		meslist.add("不错学习了");
		meslist.add("好好好，非常好");
		meslist.add(" 学习了");
		meslist.add("看不太懂。。。");
		meslist.add("啊啊啊啊");
		meslist.add("可以");
		meslist.add("谢谢分享");
		
	    //随机选择一个留言
		int mr = (int)(Math.random()*meslist.size());
		String message = meslist.get(mr);
		
		
		/*
		 * 文章 部分
		 * */
		//取出所有文章
		map.clear();
		List<TAB_WXARTICLE> articlelist = iTAB_WxArticleService.getArticleList(map);
		//随机选择一篇文章
		int ar = (int)(Math.random()*articlelist.size());
		TAB_WXARTICLE article = articlelist.get(ar);
		
		
		/*
		 * 
		 * 
		 * */
		
		String articleid = article.getId();
		String openid = "bot";
		String username = (String) userMap.get("username");
		String usericonurl = (String) userMap.get("usericonurl");
		String messageContent =  message;
		String timestamp = TimeUtil.getTimeStamp();
		String time = TimeUtil.getTime();
		
		
		
	    HashMap<String,Object> map1 = new HashMap<String, Object>();
		String logstr = "";
		/*
		 * 	插入留言
		 * 	两天一条
		 * */
		int i = (int)(Math.random()*48);
		
		logstr = "logstr-->时间："+time+"|留言随机数(48,1)："+i+",";
		
		if(i<1) {
			map1.put("articleid", Integer.parseInt(articleid));
			map1.put("openid", openid);
			map1.put("username", username);
			map1.put("usericonurl", usericonurl);
			map1.put("timestamp", timestamp);
			map1.put("time", time);
			map1.put("messageContent", messageContent);
			iTAB_WxArticleMessageService.submitMes(map1);
			logstr = logstr + "已插入";
		}else {
			logstr = logstr + "未插入";
		}
		
		
		/*
		 * 	插入浏览
		 * 	一天两条
		 * */
		i = (int)(Math.random()*24);
		logstr = logstr + "|浏览随机数(24,2)："+i+",";
		if(i<2) {
			map1.clear();
			map1.put("articleid", articleid);
			map1.put("username", username);
			map1.put("timestamp", timestamp);
			map1.put("time", time);
			iTAB_WxArticlePageViewService.userViewArticle(map1);
			logstr = logstr + "已插入";
		}else {
			logstr = logstr + "未插入";
		}
		
		
		/*
		 * 	插入喜欢
		 * 	一天半一条
		 * */
		i = (int)(Math.random()*36);
		logstr = logstr + "|喜欢随机数(36,1)："+i+",";
		if(i<1) {
			map1.clear();
			map1.put("articleid", articleid);
			map1.put("openid", openid);
			map1.put("username", username);
			map1.put("usericonurl", usericonurl);
			map1.put("timestamp", timestamp);
			map1.put("time", time);
			iTAB_WxArticlelikeService.userLikeArticle(map1);
			logstr = logstr + "已插入";
		}else {
			logstr = logstr + "未插入";
		}
		System.err.println(logstr);
		
		
	}
}
