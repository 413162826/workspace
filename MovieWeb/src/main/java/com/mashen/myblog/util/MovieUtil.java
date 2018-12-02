package com.mashen.myblog.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MovieUtil {
	public void movieContextURL(String url) {
		URL url1;
		try {
			url1 = new URL("http://www.metvb.com/");
			BufferedReader bufr = new BufferedReader(new InputStreamReader(url1.openStream()));
			String line = null;
			while((line = bufr.readLine())!=null) {
				
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
