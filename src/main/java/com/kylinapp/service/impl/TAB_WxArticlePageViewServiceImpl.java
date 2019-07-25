/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.kylinapp.service.impl;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kylinapp.dao.ITAB_WxArticlePageViewDAO;
import com.kylinapp.service.ITAB_WxArticlePageViewService;

import net.sf.json.JSONObject;

/**
 * @author：QYW
 * @since：2018年12月28日下午3:33:40
 * @description:
 * @version: 1.0
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com)
 */
@Service
public class TAB_WxArticlePageViewServiceImpl implements ITAB_WxArticlePageViewService {
	@Resource
	private ITAB_WxArticlePageViewDAO iTAB_WxArticlePageViewDAO;

	public JSONObject userViewArticle(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		JSONObject json = new JSONObject();
		try {

			iTAB_WxArticlePageViewDAO.userViewArticle(map);

		} catch (Exception e) {
			json.put("retCode", "0001");
			json.put("errMSG", e.getMessage());
			System.err.println(e.getMessage());
		}
		return json;
	}

}
