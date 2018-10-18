package com.djl.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class ImageFileController {
	@Value("${image_filepath}")
	private String filepath; 

	private static final Logger logger =LoggerFactory.getLogger(ImageFileController.class);
	/**
	 * 读取后台的图片信息
	 * @param imgName
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/downLoadImage/{imgName}/getImage", method = RequestMethod.GET)
	public void IoReadImage(@PathVariable String imgName, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		logger.info("读取图片"+imgName);
		ServletOutputStream out = null;
		FileInputStream ips = null;
		try {
			// 获取图片存放路径
			String imgPath = filepath + imgName;
			ips = new FileInputStream(new File(imgPath));
			response.setContentType("multipart/form-data");
			out = response.getOutputStream();
			// 读取文件流
			int len = 0;
			byte[] buffer = new byte[1024 * 10];
			while ((len = ips.read(buffer)) != -1) {
				out.write(buffer, 0, len);
			}
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
			ips.close();
		}
	}
	@RequestMapping(value = "/getShowCount.do", method = RequestMethod.POST)
	@ResponseBody
	public String getShowCount(HttpServletRequest request, HttpServletResponse response) {
		return String.valueOf(ChatRoom.showcount.size());
	}
	
	
}
