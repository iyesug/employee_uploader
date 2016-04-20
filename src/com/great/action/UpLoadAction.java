package com.great.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.struts2.ServletActionContext;

public class UpLoadAction {
	private File myfile;  ///----------------->目的地
	private String myfileContentType;
	private String myfileFileName;

	private String imgfile;
	
	
	public File getMyfile() {
		return myfile;
	}

	public void setMyfile(File myfile) {
		this.myfile = myfile;
	}


	public String getMyfileFileName() {
		return myfileFileName;
	}

	public void setMyfileFileName(String myfileFileName) {
		this.myfileFileName = myfileFileName;
	}

	public String getMyfileContentType() {
		return myfileContentType;
	}

	public void setMyfileContentType(String myfileContentType) {
		this.myfileContentType = myfileContentType;
	}
	
	
	public String execute(){
		return "input";
	}
	
	public String upload(){
		String destpath=ServletActionContext.getServletContext().getRealPath("\\image\\");
		File file=new File(destpath);

		System.out.println(destpath);
		try {
			if(!file.exists()){
				System.out.println("path:"+destpath);
				file.mkdir();
			}			
			String destFile=destpath+"\\"+myfileFileName;
			System.out.println(destFile);
			FileInputStream in=new FileInputStream(myfile);
			FileOutputStream on=new FileOutputStream(destFile);
			
			byte[] buff=new byte[1024];
			int count=0;
			while((count=in.read(buff))>0){
				on.write(buff, 0, count);
			}
			in.close();
			on.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imgfile="image\\"+myfileFileName;
		return "success";
	}

	public String getImgfile() {
		return imgfile;
	}

	public void setImgfile(String imgfile) {
		this.imgfile = imgfile;
	}
}
