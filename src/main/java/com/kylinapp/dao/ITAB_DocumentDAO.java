/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.kylinapp.dao;

import java.util.List;
import java.util.Map;

import com.kylinapp.model.TAB_DOCUMENT;

/**    
 * @author：QYW   
 * @since：2018年12月29日下午2:56:04
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com) 
 */
public interface ITAB_DocumentDAO {

	/**   
	 * @Title: getDocumentList   
	 * @Description: 
	 * @param: @param map
	 * @param: @return      
	 * @return: List<TAB_DOCUMENT>      
	 * @throws   
	 */
	List<TAB_DOCUMENT> getDocumentList(Map<String, Object> map);

}
