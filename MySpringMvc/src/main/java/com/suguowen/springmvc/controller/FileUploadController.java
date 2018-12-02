package com.suguowen.springmvc.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller(value="fileUploadController")
@RequestMapping(value="/fileUploadController")
public class FileUploadController {
	@RequestMapping("/fileUpload1")
	@ResponseBody
	public String fileUpload1(MultipartFile myFile) {
		System.out.println("---文件上传---");
		String fileName = myFile.getOriginalFilename();
		System.out.println("文件名:"+fileName);
		try {
			myFile.transferTo(new File("E:\\img\\a.jpg"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success!!";
	}
}
