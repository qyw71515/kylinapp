package com.jx.aisino.ws;

public class WebServicePortTypeProxy implements com.jx.aisino.ws.WebServicePortType {
  private String _endpoint = null;
  private com.jx.aisino.ws.WebServicePortType webServicePortType = null;
  
  public WebServicePortTypeProxy() {
    _initWebServicePortTypeProxy();
  }
  
  public WebServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initWebServicePortTypeProxy();
  }
  
  private void _initWebServicePortTypeProxy() {
    try {
      webServicePortType = (new com.jx.aisino.ws.ZzkpWebserviceLocator()).getWebServiceHttpPort();
      if (webServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)webServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)webServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (webServicePortType != null)
      ((javax.xml.rpc.Stub)webServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.jx.aisino.ws.WebServicePortType getWebServicePortType() {
    if (webServicePortType == null)
      _initWebServicePortTypeProxy();
    return webServicePortType;
  }
  
  public java.lang.String queryInventory(java.lang.String in0) throws java.rmi.RemoteException, com.jx.aisino.ws.Exception{
    if (webServicePortType == null)
      _initWebServicePortTypeProxy();
    return webServicePortType.queryInventory(in0);
  }
  
  public java.lang.String printList(java.lang.String in0) throws java.rmi.RemoteException, com.jx.aisino.ws.Exception{
    if (webServicePortType == null)
      _initWebServicePortTypeProxy();
    return webServicePortType.printList(in0);
  }
  
  public java.lang.String printInvoice(java.lang.String in0) throws java.rmi.RemoteException, com.jx.aisino.ws.Exception{
    if (webServicePortType == null)
      _initWebServicePortTypeProxy();
    return webServicePortType.printInvoice(in0);
  }
  
  public java.lang.String invalidInvoice(java.lang.String in0) throws java.rmi.RemoteException, com.jx.aisino.ws.Exception{
    if (webServicePortType == null)
      _initWebServicePortTypeProxy();
    return webServicePortType.invalidInvoice(in0);
  }
  
  public java.lang.String fpkjInvoice(java.lang.String in0) throws java.rmi.RemoteException, com.jx.aisino.ws.Exception{
    if (webServicePortType == null)
      _initWebServicePortTypeProxy();
    return webServicePortType.fpkjInvoice(in0);
  }
  
  public java.lang.String uploadRedInfo(java.lang.String in0) throws java.rmi.RemoteException, com.jx.aisino.ws.Exception{
    if (webServicePortType == null)
      _initWebServicePortTypeProxy();
    return webServicePortType.uploadRedInfo(in0);
  }
  
  public java.lang.String issueInvoice(java.lang.String in0) throws java.rmi.RemoteException, com.jx.aisino.ws.Exception{
    if (webServicePortType == null)
      _initWebServicePortTypeProxy();
    return webServicePortType.issueInvoice(in0);
  }
  
  public java.lang.String invalidBlankInvoice(java.lang.String in0) throws java.rmi.RemoteException, com.jx.aisino.ws.Exception{
    if (webServicePortType == null)
      _initWebServicePortTypeProxy();
    return webServicePortType.invalidBlankInvoice(in0);
  }
  
  
}