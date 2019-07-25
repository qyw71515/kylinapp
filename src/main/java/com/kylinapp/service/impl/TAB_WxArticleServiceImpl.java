/** 
 * Copyright: Copyright (c)2015
 * Company: ����������Ϣ���޹�˾(jxhtxx.com) 
 */
package com.kylinapp.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kylinapp.dao.ITAB_WxArticleDAO;
import com.kylinapp.model.TAB_WXARTICLE;
import com.kylinapp.service.ITAB_WxArticleService;

/**
 * @author��QYW
 * @since��2018��12��28������10:25:52
 * @description:
 * @version: 1.0
 * @copyright: Copyright (c)2015
 * @company: ����������Ϣ���޹�˾(jxhtxx.com)
 */
@Service
public class TAB_WxArticleServiceImpl implements ITAB_WxArticleService {
	@Resource
	private ITAB_WxArticleDAO iTAB_WxArticleDAO;
	
	public List<TAB_WXARTICLE> getArticleList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		try {
			List<TAB_WXARTICLE> articlelist = iTAB_WxArticleDAO.getArticleList(map);
			return articlelist;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

}
