/** 
 * Copyright: Copyright (c)2015
 * Company: ����������Ϣ���޹�˾(jxhtxx.com) 
 */
package com.kylinapp.dao;

import java.util.List;
import java.util.Map;

import com.kylinapp.model.TAB_WxArticleLike;

/**    
 * @author��QYW   
 * @since��2018��12��28������2:59:46
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: ����������Ϣ���޹�˾(jxhtxx.com) 
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
