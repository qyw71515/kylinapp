/** 
 * Copyright: Copyright (c)2015
 * Company: ����������Ϣ���޹�˾(jxhtxx.com) 
 */
package com.kylinapp.service;

import java.util.HashMap;

import net.sf.json.JSONObject;

/**    
 * @author��QYW   
 * @since��2018��12��28������3:33:28
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: ����������Ϣ���޹�˾(jxhtxx.com) 
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
