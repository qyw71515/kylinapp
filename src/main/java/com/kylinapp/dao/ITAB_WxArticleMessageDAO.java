/** 
 * Copyright: Copyright (c)2015
 * Company: ����������Ϣ���޹�˾(jxhtxx.com) 
 */
package com.kylinapp.dao;

import java.util.List;
import java.util.Map;

import com.kylinapp.model.TAB_WxArticleMessage;

/**    
 * @author��QYW   
 * @since��2018��12��28������3:00:53
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: ����������Ϣ���޹�˾(jxhtxx.com) 
 */
public interface ITAB_WxArticleMessageDAO {

	/**   
	 * @Title: getArticleMessageList   
	 * @Description: 
	 * @param: @param map
	 * @param: @return      
	 * @return: List<TAB_WxArticleMessage>      
	 * @throws   
	 */
	List<TAB_WxArticleMessage> getArticleMessageList(Map<String, Object> map);

	/**   
	 * @Title: submitMes   
	 * @Description: 
	 * @param: @param map
	 * @param: @return      
	 * @return: boolean      
	 * @throws   
	 */
	boolean submitMes(Map<String, Object> map);

}
