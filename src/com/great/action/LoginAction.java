package com.great.action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.great.bean.Employee;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction implements SessionAware {
//	private String username;
//	private String password;
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
	
	private Employee user;
	
	private String result;
	
	public String login(){
		if("admin".equals(user.getName())){
//			Map<String,Object> sessionObj=ActionContext.getContext().getSession();
//			sessionObj.put("username1",user.getName());
//			mySession.put("username2",user.getName());
			HttpSession session=ServletActionContext.getRequest().getSession();
			session.setAttribute("username", user.getName());
			return "success";
		}else{
			result="failse...";
			return "input";
		}				
	}
	
	public String execute() throws Exception{
//		if("admin".equals(username)&&"admin".equals(password)){
//			return "success";
//		}else{
//			return "input";
//		}
		if("admin".equals(user.getName())){
			Map<String,Object> sessionObj=ActionContext.getContext().getSession();
			sessionObj.put("username1",user.getName());
			mySession.put("username2",user.getName());
			HttpSession session=ServletActionContext.getRequest().getSession();
			session.setAttribute("username", user.getName());
			return "success";
		}else{
			result="failse...";
			return "input";
		}		
	}


	public Employee getUser() {
		return user;
	}


	public void setUser(Employee user) {
		this.user = user;
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}

	Map<String ,Object> mySession;

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		mySession=session;
	}
}
