/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.kylinapp.service;

import java.util.List;
import java.util.Map;

import com.kylinapp.model.TAB_OCR;

/**    
 * @author：QYW   
 * @since：2018年12月29日上午10:21:15
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com) 
 */
public interface ITab_OCRService {

	/**   
	 * @Title: insert   
	 * @Description: 
	 * @param: @param map      
	 * @return: void      
	 * @throws   
	 */
	void insert(Map<String, Object> map);


	/**   
	 * @Title: getImgList   
	 * @Description: 
	 * @param: @param map
	 * @param: @return      
	 * @return: List<TAB_OCR>      
	 * @throws   
	 */
	List<TAB_OCR> getImgList(Map<String, Object> map);

}
