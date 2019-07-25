/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.kylinapp.service;

import java.util.List;
import java.util.Map;

import com.kylinapp.model.TAB_DOCUMENT;

/**    
 * @author：QYW   
 * @since：2018年12月29日下午2:53:22
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com) 
 */
public interface ITAB_DocumentService {

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
