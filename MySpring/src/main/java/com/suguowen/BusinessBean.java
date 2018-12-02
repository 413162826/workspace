package com.suguowen;

public class BusinessBean {
    private IDeviceWriter writer;  
    private String name;
  
    public BusinessBean(IDeviceWriter writer,String name) {
		// TODO Auto-generated constructor stub
    	this.name = name;
    	this.writer = writer;
	}
    
    /*public void setDeviceWriter(IDeviceWriter writer) {  
        this.writer = writer;  
    } */ 
  
    public IDeviceWriter getDeviceWriter() {  
        return writer;  
    }  
  
    public void save() {
    	System.out.println("i am :" + name);
        if (writer == null) {  
            throw new RuntimeException("DeviceWriter needed...");  
        }  
        writer.saveToDevice();  
    }  
} 
