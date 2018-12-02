package com.suguowen.blog.regex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ReadProperties {
	public static void main(String[] args) throws IOException {
		Map<Integer, String> map = new HashMap<>();

        String filePath = "colorStyle.txt";
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(new FileInputStream(filePath)));
 
        String line = reader.readLine();
        while ((line = reader.readLine())!=null) {
            System.out.println(line);
		}
 
        reader.close();
	}

}
