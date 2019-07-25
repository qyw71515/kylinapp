/** 
 * Copyright: Copyright (c)2015
 * Company: ����������Ϣ���޹�˾(jxhtxx.com) 
 */
package com.kylinapp.service;

import java.util.List;
import java.util.Map;

import com.kylinapp.model.TAB_WXARTICLE;

/**    
 * @author��QYW   
 * @since��2018��12��28������10:25:41
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: ����������Ϣ���޹�˾(jxhtxx.com) 
 */
public interface ITAB_WxArticleService {

	/**   
	 * @Title: getArticleList   
	 * @Description: 
	 * @param: @param map
	 * @param: @return      
	 * @return: List<TAB_WXARTICLE>      
	 * @throws   
	 */
	List<TAB_WXARTICLE> getArticleList(Map<String, Object> map);

}
