/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.kylinapp.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kylinapp.dao.ITab_OCRDAO;
import com.kylinapp.model.TAB_OCR;
import com.kylinapp.service.ITab_OCRService;

/**
 * @author：QYW
 * @since：2018年12月29日上午10:22:08
 * @description:
 * @version: 1.0
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com)
 */
@Service
public class Tab_OCRServiceImpl implements ITab_OCRService {
	@Resource
	private ITab_OCRDAO tab_OCRDAO;

	public void insert(Map<String, Object> map) {
		// TODO Auto-generated method stub
		try {
			tab_OCRDAO.insert(map);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<TAB_OCR> getImgList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		try {
			List<TAB_OCR> list = tab_OCRDAO.getImgList(map);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
