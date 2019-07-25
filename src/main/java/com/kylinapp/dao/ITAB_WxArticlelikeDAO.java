/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.kylinapp.dao;

import java.util.List;
import java.util.Map;

import com.kylinapp.model.TAB_WxArticleLike;

/**    
 * @author：QYW   
 * @since：2018年12月28日下午2:59:46
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com) 
 */
public interface ITAB_WxArticlelikeDAO {
	/**   
	 * @Title: getArticleMessageList   
	 * @Description: 
	 * @param: @param map
	 * @param: @return      
	 * @return: List<TAB_WxArticleMessage>      
	 * @throws   
	 */
	List<TAB_WxArticleLike> getWxArticleLikeList(Map<String, Object> map);
	
	/**   
	 * @Title: getArticleMessageList   
	 * @Description: 
	 * @param: @param map
	 * @param: @return      
	 * @return: List<TAB_WxArticleMessage>      
	 * @throws   
	 */
	boolean userLikeArticle(Map<String, Object> map);
	
	/**   
	 * @Title: getArticleMessageList   
	 * @Description: 
	 * @param: @param map
	 * @param: @return      
	 * @return: List<TAB_WxArticleMessage>      
	 * @throws   
	 */
	boolean userUnLikeArticle(Map<String, Object> map);
}
