/**
 * ZzkpWebservice.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.jx.aisino.ws;

public interface ZzkpWebservice extends javax.xml.rpc.Service {
    public java.lang.String getWebServiceHttpPortAddress();

    public com.jx.aisino.ws.WebServicePortType getWebServiceHttpPort() throws javax.xml.rpc.ServiceException;

    public com.jx.aisino.ws.WebServicePortType getWebServiceHttpPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
