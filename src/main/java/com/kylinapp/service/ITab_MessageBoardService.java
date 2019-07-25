/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.kylinapp.service;

import java.util.List;
import java.util.Map;

import com.kylinapp.model.Tab_MessageBoard;

/**    
 * @author：QYW   
 * @since：2019年1月21日上午10:37:55
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com) 
 */
public interface ITab_MessageBoardService {

	/**   
	 * @Title: submitMes   
	 * @Description: 
	 * @param: @param map
	 * @param: @return      
	 * @return: boolean      
	 * @throws   
	 */
	boolean submitMes(Map<String, Object> map);

	/**   
	 * @Title: getCount   
	 * @Description: 
	 * @param: @param map
	 * @param: @return      
	 * @return: int      
	 * @throws   
	 */
	int getCount(Map<String, Object> map);

	/**   
	 * @Title: getMesListByPage   
	 * @Description: 
	 * @param: @param map
	 * @param: @return      
	 * @return: List<Tab_MessageBoard>      
	 * @throws   
	 */
	List<Tab_MessageBoard> getMesListByPage(Map<String, Object> map);

}
