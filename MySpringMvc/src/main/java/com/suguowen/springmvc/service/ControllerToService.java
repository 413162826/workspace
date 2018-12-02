package com.suguowen.springmvc.service;

import org.springframework.stereotype.Service;

@Service(value="controllerToService")
public class ControllerToService {
	public void controllerToService() {
		System.out.println("成功访问service");
	}
}
