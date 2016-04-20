package com.great.action;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.great.bean.ImageUtil;



public class CheckCodeAction {
	private  InputStream checkIS;
	public String execute() throws Exception{
		Map<String,BufferedImage> map=ImageUtil.createImage();
		String checkCode="";
		BufferedImage image=null;
		for(Entry<String,BufferedImage> entry:map.entrySet()){
			checkCode=entry.getKey();
			image=entry.getValue();
		}
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("checkCode", checkCode);		
		System.out.println("checkCode="+checkCode);
		checkIS=ImageUtil.getInputStream(image);
		return "success";
	}
	public InputStream getCheckIS() {
		return checkIS;
	}
	public void setCheckIS(InputStream checkIS) {
		this.checkIS = checkIS;
	}
}
