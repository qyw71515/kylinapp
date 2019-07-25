/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package kylinapp;

import java.rmi.RemoteException;

import javax.annotation.Resource;

import com.jx.aisino.ws.Exception;
import com.jx.aisino.ws.WebServicePortType;

/**    
 * @author：QYW   
 * @since：2019年3月22日上午11:42:42
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com) 
 */
public class Test {
	@Resource
	private static WebServicePortType s;
	public static void main(String[] args) throws Exception, RemoteException {
		s.printInvoice("");
	}
}
