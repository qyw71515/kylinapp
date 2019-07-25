/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.kylinapp.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kylinapp.dao.ITAB_WxArticleMessageDAO;
import com.kylinapp.model.TAB_WxArticleMessage;
import com.kylinapp.service.ITAB_WxArticleMessageService;

/**
 * @author：QYW
 * @since：2018年12月28日下午2:56:47
 * @description:
 * @version: 1.0
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com)
 */
@Service
public class TAB_WxArticleMessageServiceImpl implements ITAB_WxArticleMessageService {
	@Resource
	private ITAB_WxArticleMessageDAO iTAB_WxArticleMessageDAO;

	public List<TAB_WxArticleMessage> getArticleMessageList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		try {
			List<TAB_WxArticleMessage> articleMesList = iTAB_WxArticleMessageDAO.getArticleMessageList(map);
			return articleMesList;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public boolean submitMes(Map<String, Object> map) {
		// TODO Auto-generated method stub
		try {
			boolean b = iTAB_WxArticleMessageDAO.submitMes(map);
			return b;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}

}
