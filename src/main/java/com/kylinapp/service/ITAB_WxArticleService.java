/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.kylinapp.service;

import java.util.List;
import java.util.Map;

import com.kylinapp.model.TAB_WXARTICLE;

/**    
 * @author：QYW   
 * @since：2018年12月28日上午10:25:41
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com) 
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
