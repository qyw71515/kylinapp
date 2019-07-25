/** 
 * Copyright: Copyright (c)2015
 * Company: ����������Ϣ���޹�˾(jxhtxx.com) 
 */
package com.kylinapp.service;

import java.util.List;
import java.util.Map;

import com.kylinapp.model.TAB_OCR;

/**    
 * @author��QYW   
 * @since��2018��12��29������10:21:15
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: ����������Ϣ���޹�˾(jxhtxx.com) 
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
