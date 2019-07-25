/** 
 * Copyright: Copyright (c)2015
 * Company: ����������Ϣ���޹�˾(jxhtxx.com) 
 */
package com.kylinapp.dao;

import java.util.List;
import java.util.Map;

import com.kylinapp.model.Tab_MessageBoard;

/**    
 * @author��QYW   
 * @since��2019��1��21������11:12:01
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: ����������Ϣ���޹�˾(jxhtxx.com) 
 */
public interface ITab_MessageBoardDAO {

	/**   
	 * @Title: submitMes   
	 * @Description: 
	 * @param: @param map      
	 * @return: void      
	 * @throws   
	 */
	void submitMes(Map<String, Object> map);

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
