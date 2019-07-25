/** 
 * Copyright: Copyright (c)2015
 * Company: ����������Ϣ���޹�˾(jxhtxx.com) 
 */
package com.kylinapp.service;

import java.util.List;
import java.util.Map;

import com.kylinapp.model.TAB_WxArticleLike;


/**    
 * @author��QYW   
 * @since��2018��12��28������2:06:43
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: ����������Ϣ���޹�˾(jxhtxx.com) 
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
