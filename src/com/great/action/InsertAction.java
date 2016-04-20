package com.great.action;



import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.great.bean.Employee;
import com.great.db.MyDateBase;

public class InsertAction {

	private Employee emp;
	private String result;


	public String execute(){
		
		if(!"".equals(emp.getName())){
			
			MyDateBase dateuse=new MyDateBase();
			dateuse.newEmp(emp);
			dateuse.closeConn();
			result="成功录入：姓名："+emp.getName()+"ID："+"部门："+emp.getDepartment()+"职位："+emp.getJob()+"头像："+emp.getImg();
			return "sucess";
		}else{
			result="输入框不可为空！";
			HttpSession session=ServletActionContext.getRequest().getSession();
			session.setAttribute("result", result);		
			return "input";
		}
		
		
	}

	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	
	
	
}
