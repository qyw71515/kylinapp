/** 
 * Copyright: Copyright (c)2015
 * Company: ����������Ϣ���޹�˾(jxhtxx.com) 
 */
package com.kylinapp.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kylinapp.dao.ITAB_WXAPPUSERDAO;
import com.kylinapp.service.ITAB_WXAPPUSERService;

/**    
 * @author��QYW   
 * @since��2018��12��27������4:46:06
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: ����������Ϣ���޹�˾(jxhtxx.com) 
 */
@Service
public class TAB_WXAPPUSERServiceImpl implements ITAB_WXAPPUSERService{
	@Resource
	private ITAB_WXAPPUSERDAO iTAB_WXAPPUSERDAO;
	public void insertOrUpdateWxappuser(Map<String, Object> map) {
		// TODO Auto-generated method stub
		try {
			iTAB_WXAPPUSERDAO.insertOrUpdateWxappuser(map);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}

}
