package com.sdt.oneword.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sdt.oneword.domain.Images;
import com.sdt.oneword.domain.User;
import com.sdt.oneword.service.impl.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login")
	public String login(User user,RedirectAttributes redirectAttributes) throws UnsupportedEncodingException{
		
		System.out.println("进入登录方法！");
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
		redirectAttributes.addFlashAttribute("message","hello World~~~");
		System.out.println("用户名："+user.getUsername()+"，密码："+user.getPassword());
		
//		User user1 = new User();
//		user1.setUsername(new String("圣人1".getBytes("utf-8"),"GBK"));
//		user1.setPassword("abc1112");
		
		System.out.println("插入User数据b："+new String(user.getUsername().getBytes("utf-8"),"utf-8"));
		int result = userService.insertUser(user);
		
		Log log = LogFactory.getLog(LoginController.class);
		log.debug("YP调试信息："+user.getUsername()+"~~~~");
		//return new ModelAndView("main","username",user.getUsername());
		return "redirect:/show?aa=123s";
	}
	
	@RequestMapping(value="/show")
	public ModelAndView show(HttpServletRequest request,RedirectAttributes redirectAttributes){
		
		Map<String, Object> map = (Map<String, Object>) redirectAttributes.getFlashAttributes();
		
		for(String key : map.keySet()){
			
			System.out.println("key:"+key+"，value:"+map.get(key).toString());
		}
		
		System.out.println("request中值:"+request.getParameter("aa"));
		System.out.println("show方法的userName:");
		
		return new ModelAndView("main");
	}

	@RequestMapping(value="/getUser")
	@ResponseBody
	public Map<String,String> getUser(){
		
		System.out.println("获取user数据json！");
		User user = new User();
		user.setUsername("圣人");
		user.setPassword("abc111");
		
		Map<String,String> map = new HashMap<String, String>();
		map.put("user", "鬼道");
		map.put("aa", "2323232");
		return map;
	}
	
	//jsonp返回数据
	@RequestMapping(value="/getJsonp")
	public void getJsonp(HttpServletRequest request,HttpServletResponse response){
		String value = request.getParameter("callback");
		String jsonData = "{\"name\":\"AAAAAwf\",\"age\":21}";
		try {
			String jsonpData = value+"("+jsonData+")";
			System.out.println(jsonpData);
			response.getWriter().write(jsonpData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/getJsonpData")
	@ResponseBody
	public JSONPObject getJsonpData(HttpServletRequest request,HttpServletResponse response){
		
		ModelAndView model = new ModelAndView();
		
		String callback = request.getParameter("callback");
		User user = new User();
		user.setUsername("圣人");
		user.setPassword("abc111");
		
		Map<String,String> map = new HashMap<String, String>();
		map.put("user", "鬼道");
		map.put("aa", "2323232");
		model.addAllObjects(map);
		return new JSONPObject(callback,model);
//		String jsonData = "{\"name\":\"AAAAAwf\",\"age\":21}";
//		try {
//			String jsonpData = value+"("+jsonData+")";
//			System.out.println(jsonpData);
//			response.getWriter().write(jsonpData);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
	
	@RequestMapping(value="/deferred")
	@ResponseBody
	public Object deferred(HttpServletRequest req){
		
		int userId = Integer.parseInt(req.getParameter("userId"));
		System.out.println("获取user数据json！userId="+userId);
		User user = userService.selectUserById(userId);
		System.out.println("打印User数据："+user.getUserId()+","+user.getUsername()+","+user.getPassword());
		String userName = user.getUsername();
		try {
			System.out.println("打印各种编码方式的中文数据GBK："+new String(userName.getBytes("GBK"),"utf-8")+","+new String(userName.getBytes("GBK"),"GBK"));
			System.out.println("打印各种编码方式的中文数据gb2312："+new String(userName.getBytes("gb2312"),"utf-8")+","+new String(userName.getBytes("gb2312"),"gb2312"));
			System.out.println("打印各种编码方式的中文数据utf-8："+new String(userName.getBytes("utf-8"),"utf-8")+","+"本身");
			System.out.println("打印各种编码方式的中文数据iso8859-1："+new String(userName.getBytes("ISO-8859-1"),"utf-8")+","+new String(userName.getBytes("ISO-8859-1"),"ISO-8859-1"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	@RequestMapping(value="/fileUpload")
	//@ResponseBody
	public String fileUpload(@ModelAttribute Images img,HttpServletRequest requset,@RequestHeader String referer){
		
		System.out.println("进入文件上传方法！");
		List<MultipartFile> listImages = img.getImages();
		String name =img.getName();
		System.out.println("referer:"+referer);
		for(MultipartFile multipartFile:listImages){
			String fileOriginalFileName = multipartFile.getOriginalFilename();
			String fileType = multipartFile.getContentType();
			String fileName = multipartFile.getName();
			long fileSize = multipartFile.getSize();
			System.out.println("文件信息：参数名称："+fileName+"，初始文件名："+fileOriginalFileName+"\t，文件大小："+fileSize+"\n，文件类型："+fileType);
			
			//创建文件夹
			System.out.println("requset.getServletContext().getContextPath():"+requset.getServletContext().getContextPath());
			File folder = new File(requset.getServletContext().getContextPath()+File.separator+name);
			if(!folder.exists()){
				folder.mkdirs();
			}
			File imageFile = new File(folder.getAbsolutePath()+File.separator+fileOriginalFileName);
			System.out.println("上传文件路径："+imageFile.getAbsolutePath());
			try {
				multipartFile.transferTo(imageFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
//		Map<String,String> map = new HashMap<String, String>();
//		map.put("result", "上传成功");
		return "main";
	}
	
	@RequestMapping(value="/download")
	public void download(HttpServletRequest request,HttpServletResponse response){
		
		System.out.println("进入下载方法！");
		String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/data"); 
		System.out.println("下载路径文件夹:"+dataDirectory);
		File file = new File(dataDirectory,"ssh框架整合步骤讲解.pdf");
		if(file.exists()){
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/octet-stream;charset=UTF-8");
			

			String downloadName = null;
			try {
				downloadName = new String("ssh框架整合步骤讲解.pdf".getBytes("GBK"), "iso8859-1");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			response.addHeader("Content-Disposition","attachment; filename="+downloadName);
			byte[] buffer = new byte[1024];
			FileInputStream fis = null;
			BufferedInputStream bis = null;
			try {
				fis=new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				OutputStream os = response.getOutputStream();
				int i = bis.read(buffer);
				while(i!=-1){
					os.write(buffer,0,i);
					i = bis.read(buffer);
					
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					if(bis!=null){
						bis.close();
					}
					if(fis!=null){
						fis.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
//		Map<String,String> map = new HashMap<String, String>();
//		map.put("result", "下载完成");
//		return map;
	}
	
}
