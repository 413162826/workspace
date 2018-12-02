package com.suguowen.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suguowen.model.GfCar;

@Controller
@RequestMapping("/WX")
public class WXTest {
	
	@RequestMapping("/test")
	@ResponseBody
	public List<GfCar> wxtest() {
		List<GfCar> ulist = new ArrayList();
		for(int a =0 ; a<3 ; a++) {
			ulist.add(new GfCar(a, "311500707"+a));
		}
		return ulist;
		
	}
	
}
