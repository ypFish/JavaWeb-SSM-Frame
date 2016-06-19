package com.sdt.oneword.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Images implements Serializable {

	/**
	 * 文件上传测试
	 */
	private static final long serialVersionUID = 132215L;
	
	private String name ;
	
	private List<MultipartFile> images ;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MultipartFile> getImages() {
		return images;
	}

	public void setImages(List<MultipartFile> images) {
		this.images = images;
	}

	

}
