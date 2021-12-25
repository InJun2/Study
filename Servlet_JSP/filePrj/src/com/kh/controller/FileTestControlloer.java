package com.kh.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(
//		location="/tempRepo", // 운영체제마다 절대경로를 표현하는 것이 다르므로 기본 자바파일로 임시저장하는 것이 좋음 ( 설정 X )
//		fileSizeThreshold = 1024 * 1024, // 업로드한 파일의 크기가 태그값보다 크면 location에 지정한 디렉터리에 임시로 파일 복사 ( 마찬가지로 설정 X )
		maxFileSize = 1024 * 1024 * 50,
		maxRequestSize = 1024 * 1024 * 50 * 5
		)
@WebServlet("/fileTest")
public class FileTestControlloer extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
//		Part file = req.getPart("f");
		Collection<Part> parts = req.getParts();
		for(Part p : parts) {
			if(!p.getName().equals("f")) continue;
			
			// 사용자가 업로드한 파일 이름 알아오기
			String originName = p.getSubmittedFileName();
			
			// 사용자가 업로드한 파일 에다가 input 스트림 연결
			InputStream fis =  p.getInputStream();
			
			// 저장할 경로
			String realPath = req.getServletContext().getRealPath("/upload");	// ""로 기입하면 절대 경로가 나옴, /upload시 절대경로에 /upload가 추가됨
			
			// 파일 경로
			String filePath = realPath + File.separator + originName;
//			new File(filePath).mkdirs();
			
			// 파일 저장
			FileOutputStream fos = new FileOutputStream(filePath);
			
			int b;
			byte[] buf = new byte[1024];
			int size = 0;
			while((size = fis.read(buf)) != -1) {
				fos.write(buf, 0, size);
			}
			
			fis.close();
			fos.close();
		}
		
		req.setAttribute("path", "arrow2.png");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
