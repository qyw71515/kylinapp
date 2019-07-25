/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.kylinapp.dao;

import java.util.List;
import java.util.Map;

import com.kylinapp.model.TAB_WXBLOGCATEGORY;

/**    
 * @author：QYW   
 * @since：2018年12月28日上午9:47:47
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com) 
 */
public interface ITAB_WXBLOGCATEGORYDAO {
	/**   
	 * @Title: insertOrUpdateWxappuser   
	 * @Description: 
	 * @param: @param map      
	 * @return: void      
	 * @throws   
	 */
	List<TAB_WXBLOGCATEGORY> getBolgCategoryList(Map<String, Object> map);
}
