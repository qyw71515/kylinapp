/** 
 * Copyright: Copyright (c)2015
 * Company: ����������Ϣ���޹�˾(jxhtxx.com) 
 */
package kylinapp;

import java.rmi.RemoteException;

import javax.annotation.Resource;

import com.jx.aisino.ws.Exception;
import com.jx.aisino.ws.WebServicePortType;

/**    
 * @author��QYW   
 * @since��2019��3��22������11:42:42
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: ����������Ϣ���޹�˾(jxhtxx.com) 
 */
public class Test {
	@Resource
	private static WebServicePortType s;
	public static void main(String[] args) throws Exception, RemoteException {
		s.printInvoice("");
	}
}
