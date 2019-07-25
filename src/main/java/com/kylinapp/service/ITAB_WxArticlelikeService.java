/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.kylinapp.service;

import java.util.List;
import java.util.Map;

import com.kylinapp.model.TAB_WxArticleLike;


/**    
 * @author：QYW   
 * @since：2018年12月28日下午2:06:43
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com) 
 */
public interface ITAB_WxArticlelikeService {

	/**   
	 * @Title: getWxArticleLikeList   
	 * @Description: 
	 * @param: @param map
	 * @param: @return      
	 * @return: List<TAB_WxArticleLike>      
	 * @throws   
	 */
	List<TAB_WxArticleLike> getWxArticleLikeList(Map<String, Object> map);

	/**   
	 * @Title: userLikeArticle   
	 * @Description: 
	 * @param: @param map
	 * @param: @return      
	 * @return: boolean      
	 * @throws   
	 */
	boolean userLikeArticle(Map<String, Object> map);

	/**   
	 * @Title: userUnLikeArticle   
	 * @Description: 
	 * @param: @param map
	 * @param: @return      
	 * @return: boolean      
	 * @throws   
	 */
	boolean userUnLikeArticle(Map<String, Object> map);

}
