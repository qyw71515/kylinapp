/**
 * ZzkpWebserviceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.jx.aisino.ws;

public class ZzkpWebserviceLocator extends org.apache.axis.client.Service implements com.jx.aisino.ws.ZzkpWebservice {

    public ZzkpWebserviceLocator() {
    }


    public ZzkpWebserviceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ZzkpWebserviceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WebServiceHttpPort
    private java.lang.String WebServiceHttpPort_address = "http://117.41.253.139:9001/fpzx/ws/zzkpWebservice";

    public java.lang.String getWebServiceHttpPortAddress() {
        return WebServiceHttpPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WebServiceHttpPortWSDDServiceName = "WebServiceHttpPort";

    public java.lang.String getWebServiceHttpPortWSDDServiceName() {
        return WebServiceHttpPortWSDDServiceName;
    }

    public void setWebServiceHttpPortWSDDServiceName(java.lang.String name) {
        WebServiceHttpPortWSDDServiceName = name;
    }

    public com.jx.aisino.ws.WebServicePortType getWebServiceHttpPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WebServiceHttpPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWebServiceHttpPort(endpoint);
    }

    public com.jx.aisino.ws.WebServicePortType getWebServiceHttpPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.jx.aisino.ws.ZzkpWebserviceSoapBindingStub _stub = new com.jx.aisino.ws.ZzkpWebserviceSoapBindingStub(portAddress, this);
            _stub.setPortName(getWebServiceHttpPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWebServiceHttpPortEndpointAddress(java.lang.String address) {
        WebServiceHttpPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.jx.aisino.ws.WebServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.jx.aisino.ws.ZzkpWebserviceSoapBindingStub _stub = new com.jx.aisino.ws.ZzkpWebserviceSoapBindingStub(new java.net.URL(WebServiceHttpPort_address), this);
                _stub.setPortName(getWebServiceHttpPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WebServiceHttpPort".equals(inputPortName)) {
            return getWebServiceHttpPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.aisino.jx.com", "zzkpWebservice");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.aisino.jx.com", "WebServiceHttpPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WebServiceHttpPort".equals(portName)) {
            setWebServiceHttpPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
