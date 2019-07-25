/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.kylinapp.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kylinapp.dao.ITab_MessageBoardDAO;
import com.kylinapp.model.Tab_MessageBoard;
import com.kylinapp.service.ITab_MessageBoardService;


/**
 * @author：QYW
 * @since：2019年1月21日上午10:38:09
 * @description:
 * @version: 1.0
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com)
 */
@Service
public class Tab_MessageBoardServiceImpl implements ITab_MessageBoardService {
	@Resource
	private ITab_MessageBoardDAO tab_MessageBoardDAO;

	public boolean submitMes(Map<String, Object> map) {
		// TODO Auto-generated method stub
		try {
			tab_MessageBoardDAO.submitMes(map);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public int getCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		try {
			int i = tab_MessageBoardDAO.getCount(map);
			return i;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<Tab_MessageBoard> getMesListByPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		try {
			List<Tab_MessageBoard> list = tab_MessageBoardDAO.getMesListByPage(map);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
