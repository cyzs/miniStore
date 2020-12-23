package com.example.hxsp.controller;

import java.io.File;

import java.io.IOException;

import java.io.PrintWriter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import org.springframework.util.FileCopyUtils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.example.hxsp.utils.FileUtil;
import com.example.hxsp.utils.JsonResult;

@RestController
@RequestMapping(value = "/hxsp/upload")
public class UploadFileController extends BaseController {

	@Value("${web.upload-path}")
	private String path;
	@Value("${web.image-path}")
	private String imagePath;

	@RequestMapping(value = "/image", method = RequestMethod.POST)
	public JsonResult<List<String>> upImage(@RequestParam(value = "files") MultipartFile[] files) {
		if (files != null&& files.length > 0) {
			List<String> list = new ArrayList<String>();
			for(int i = 0;i < files.length;i++){
                MultipartFile file = files[i];
                String fileName = FileUtil.upload(file, path, file.getOriginalFilename());
    			if (fileName != null) {
    				list.add(imagePath + fileName);
    			}
			}
			
			return new JsonResult<List<String>>(SUCCESS, list);
		}
		return new JsonResult<List<String>>();
	}

}
