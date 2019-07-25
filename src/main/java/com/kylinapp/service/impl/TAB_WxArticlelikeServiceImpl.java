/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.kylinapp.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kylinapp.dao.ITAB_WxArticlelikeDAO;
import com.kylinapp.model.TAB_WxArticleLike;
import com.kylinapp.service.ITAB_WxArticlelikeService;


/**
 * @author：QYW
 * @since：2018年12月28日下午2:07:19
 * @description:
 * @version: 1.0
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com)
 */
@Service
public class TAB_WxArticlelikeServiceImpl implements ITAB_WxArticlelikeService {
	@Resource
	private ITAB_WxArticlelikeDAO ITAB_WxArticlelikeDAO;

	public List<TAB_WxArticleLike> getWxArticleLikeList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		try {
			List<TAB_WxArticleLike> articleLikeList = ITAB_WxArticlelikeDAO.getWxArticleLikeList(map);
			return articleLikeList;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public boolean userLikeArticle(Map<String, Object> map) {
		// TODO Auto-generated method stub
		try {
			boolean b = ITAB_WxArticlelikeDAO.userLikeArticle(map);
			return b;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}

	public boolean userUnLikeArticle(Map<String, Object> map) {
		// TODO Auto-generated method stub
		try {
			boolean b = ITAB_WxArticlelikeDAO.userUnLikeArticle(map);
			return b;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}

}
