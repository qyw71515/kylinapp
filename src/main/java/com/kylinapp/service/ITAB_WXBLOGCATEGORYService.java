/** 
 * Copyright: Copyright (c)2015
 * Company: ����������Ϣ���޹�˾(jxhtxx.com) 
 */
package com.kylinapp.service;

import java.util.List;
import java.util.Map;

import com.kylinapp.model.TAB_WXBLOGCATEGORY;

/**    
 * @author��QYW   
 * @since��2018��12��28������9:37:13
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: ����������Ϣ���޹�˾(jxhtxx.com) 
 */
public interface ITAB_WXBLOGCATEGORYService {

	/**   
	 * @Title: getBolgCategoryList   
	 * @Description: 
	 * @param: @param map
	 * @param: @return      
	 * @return: ArrayList<TAB_WXBLOGCATEGORY>      
	 * @throws   
	 */
	List<TAB_WXBLOGCATEGORY> getBolgCategoryList(Map<String, Object> map);

}
