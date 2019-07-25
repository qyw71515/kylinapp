/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.kylinapp.utils;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

/**    
 * @author：QYW   
 * @since：2018年12月28日上午9:13:28
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com) 
 */
public class DefaultTrustManager implements X509TrustManager {
	public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		// TODO Auto-generated method stub
		
	}

	public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		// TODO Auto-generated method stub
		
	}

	public X509Certificate[] getAcceptedIssuers() {
		// TODO Auto-generated method stub
		return null;
	}


}
