package com.great.action;



import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.great.bean.Employee;
import com.great.db.MyDateBase;

public class ChangeAction {

	private Employee emp;
	private String result;


	public String execute(){
		
		HttpSession session=ServletActionContext.getRequest().getSession();
		String name=(String) session.getAttribute("name");		
			
			MyDateBase dateuse=new MyDateBase();
			int i=dateuse.updateEmp(name, emp.getDepartment(), emp.getJob());
			dateuse.closeConn();
			if(i==0){
				result="修改失败";
			}else{
				result="成功修改：姓名："+emp.getName()+"部门："+emp.getDepartment()+"职位："+emp.getJob();
			}

			return "sucess";
	
		
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
