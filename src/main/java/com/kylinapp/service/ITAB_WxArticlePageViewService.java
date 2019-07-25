/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.kylinapp.service;

import java.util.HashMap;

import net.sf.json.JSONObject;

/**    
 * @author：QYW   
 * @since：2018年12月28日下午3:33:28
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com) 
 */
public interface ITAB_WxArticlePageViewService {

	/**   
	 * @Title: userViewArticle   
	 * @Description: 
	 * @param: @param map
	 * @param: @return      
	 * @return: JSONObject      
	 * @throws   
	 */
	JSONObject userViewArticle(HashMap<String, Object> map);

}
