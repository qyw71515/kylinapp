/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.kylinapp.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kylinapp.dao.ITAB_DocumentDAO;
import com.kylinapp.model.TAB_DOCUMENT;
import com.kylinapp.service.ITAB_DocumentService;

/**
 * @author：QYW
 * @since：2018年12月29日下午2:55:13
 * @description:
 * @version: 1.0
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com)
 */
@Service
public class TAB_DocumentServiceImpl implements ITAB_DocumentService {
	@Resource
	private ITAB_DocumentDAO iTAB_DocumentDAO;

	public List<TAB_DOCUMENT> getDocumentList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		try {
			List<TAB_DOCUMENT> documentList = iTAB_DocumentDAO.getDocumentList(map);
			return documentList;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

}
