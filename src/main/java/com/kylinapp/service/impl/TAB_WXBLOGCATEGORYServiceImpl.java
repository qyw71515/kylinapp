/** 
 * Copyright: Copyright (c)2015
 * Company: ����������Ϣ���޹�˾(jxhtxx.com) 
 */
package com.kylinapp.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kylinapp.model.TAB_WXBLOGCATEGORY;
import com.kylinapp.service.ITAB_WXBLOGCATEGORYService;
import com.kylinapp.dao.ITAB_WXBLOGCATEGORYDAO;

/**
 * @author��QYW
 * @since��2018��12��28������9:37:41
 * @description:
 * @version: 1.0
 * @copyright: Copyright (c)2015
 * @company: ����������Ϣ���޹�˾(jxhtxx.com)
 */
@Service
public class TAB_WXBLOGCATEGORYServiceImpl implements ITAB_WXBLOGCATEGORYService {
	@Resource
	private ITAB_WXBLOGCATEGORYDAO ITAB_WXBLOGCATEGORYDAO;

	public List<TAB_WXBLOGCATEGORY> getBolgCategoryList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		try {
			List<TAB_WXBLOGCATEGORY> categoryList = ITAB_WXBLOGCATEGORYDAO.getBolgCategoryList(map);
			return categoryList;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

}
