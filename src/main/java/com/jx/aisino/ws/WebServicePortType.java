/**
 * WebServicePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.jx.aisino.ws;

public interface WebServicePortType extends java.rmi.Remote {
    public java.lang.String queryInventory(java.lang.String in0) throws java.rmi.RemoteException, com.jx.aisino.ws.Exception;
    public java.lang.String printList(java.lang.String in0) throws java.rmi.RemoteException, com.jx.aisino.ws.Exception;
    public java.lang.String printInvoice(java.lang.String in0) throws java.rmi.RemoteException, com.jx.aisino.ws.Exception;
    public java.lang.String invalidInvoice(java.lang.String in0) throws java.rmi.RemoteException, com.jx.aisino.ws.Exception;
    public java.lang.String fpkjInvoice(java.lang.String in0) throws java.rmi.RemoteException, com.jx.aisino.ws.Exception;
    public java.lang.String uploadRedInfo(java.lang.String in0) throws java.rmi.RemoteException, com.jx.aisino.ws.Exception;
    public java.lang.String issueInvoice(java.lang.String in0) throws java.rmi.RemoteException, com.jx.aisino.ws.Exception;
    public java.lang.String invalidBlankInvoice(java.lang.String in0) throws java.rmi.RemoteException, com.jx.aisino.ws.Exception;
}
