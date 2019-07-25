/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.kylinapp.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kylinapp.model.TAB_DOCUMENT;
import com.kylinapp.service.ITAB_DocumentService;

/**    
 * @author：QYW   
 * @since：2018年12月29日下午2:48:42
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com) 
 */
@Controller
@RequestMapping(value = "/doc")
public class DocumentController {
	@Resource
	private ITAB_DocumentService iTAB_DocumentService;
	
	@RequestMapping(value = "/getImg")
	public void getImg(HttpServletRequest request,HttpServletResponse response) {
		try {
			String uuid = (String) request.getParameter("uuid");
			
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("uuid", uuid);
			
			System.err.println("获取图片参数map-->"+map);
			
			List<TAB_DOCUMENT> TAB_OCRlist = iTAB_DocumentService.getDocumentList(map);
			TAB_DOCUMENT document= TAB_OCRlist.get(0);
			byte[] b = document.getDocument();
			if(b!=null&&b.length>0) {
				response.setContentType("img/jpeg");
		    	response.setCharacterEncoding("utf-8");
				OutputStream outputStream=response.getOutputStream();
				InputStream in=new ByteArrayInputStream(b);
				
				int len=0;
				byte[]buf=new byte[1024];
				while((len=in.read(buf,0,1024))!=-1){
					outputStream.write(buf, 0, len);
				}
				outputStream.close();
			}

	    	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
