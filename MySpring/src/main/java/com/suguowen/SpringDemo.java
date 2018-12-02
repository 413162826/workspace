package com.suguowen;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo {     
    public static void main(String[] args) {     
        ApplicationContext context = new ClassPathXmlApplicationContext(     
        "applicationContext.xml");     
    
        BusinessBean business = (BusinessBean) context.getBean("businessBean");     
             
        business.save();     
    }     
} 
