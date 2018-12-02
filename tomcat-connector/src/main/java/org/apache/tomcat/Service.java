package org.apache.tomcat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Service extends LifecycleBase{
	ServerSocket server = null;
	
	@Override
	protected void initInternal() throws Exception {
		server = new ServerSocket(8080);
		System.out.println("Tomcat已启动，端口8080");
	}

	@Override
	protected void startInternal() throws Exception {
		//循环直到有请求过来
		while(true) {
			//有Accept过来
			Socket socket = server.accept();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String buffer = null;
			//客户端有请求打印出来
			while((buffer = br.readLine())!= null && !buffer.equals("")) {
				System.out.println(buffer);
			}
			//返回html页面给客户端
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bw.write("HTTP/1.1 200 OK\n");
			bw.write("Content-Type:text/html;charset=UTF-8\n\n");
			bw.write("<html>\n"+"<head>\n"+"<title>first page</title>\n"
					+"</head>\n"+"</body>\n"+"<h1>suguowen Hello Tomcat</h1>\n"
					+"</body>\n"+"</html>\n"
					);
			bw.flush();
			bw.close();
			br.close();
			socket.close();
		}
	}

}
