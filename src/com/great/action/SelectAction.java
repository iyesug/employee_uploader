package com.great.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;

import com.great.bean.Department;
import com.great.bean.Employee;
import com.great.bean.Job;
import com.great.db.MyDateBase;
import com.opensymphony.xwork2.ActionContext;

public class SelectAction {

	private List<Department> listDep;
	private List<Job> listjob;
	private String name;
	private Employee emp;
	private String result;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Department> getListDep() {
		return listDep;
	}

	public void setListDep(List<Department> listDep) {
		this.listDep = listDep;
	}

	public List<Job> getListjob() {
		return listjob;
	}

	public void setListjob(List<Job> listjob) {
		this.listjob = listjob;
	}

	public String execute() {

		MyDateBase my = new MyDateBase();
		listDep = my.getDepartment();
		listjob = my.getJob();
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
        		.get(StrutsStatics.HTTP_REQUEST);  
       String s= (String) request.getAttribute("do");
      name= (String) request.getAttribute("name");
      emp=(Employee) request.getAttribute("emp");
		my.closeConn();
		if("update".equals(s)){
			return "update";
		}else{return "sucess";}
		

	}

	
	public String upDate() throws UnsupportedEncodingException{
		String name= new String(emp.getName().getBytes("ISO-8859-1"),"UTF-8");
		MyDateBase my=new MyDateBase();
		emp=my.findEmp(name);
		my=new MyDateBase();
		listDep = my.getDepartment();
		listjob = my.getJob();
		my.closeConn();
		
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("name", name);		
        HttpServletRequest request = (HttpServletRequest) ActionContext
        		.getContext().get(StrutsStatics.HTTP_REQUEST);  
        request.setAttribute("name", name); 
        request.setAttribute("emp", emp);
        request.setAttribute("do", "update"); 
//			MyDateBase dateuse=new MyDateBase();
//			dateuse.newEmp(emp);
//			dateuse.closeConn();
			result="修改：姓名："+name;
			System.out.println(result);
			
			return "update";
		
		
		
	}
	

	public String del() throws UnsupportedEncodingException{
		
		String name= new String(emp.getName().getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(emp.getName());
			MyDateBase dateuse=new MyDateBase();
			
			int i=dateuse.delEmp(name);
			dateuse.closeConn();
			if(i==0){
				result="删除失败";
			}else{
				result="删除成功";
				}
			
			System.out.println(result);
			return "del";
	
		
		
	}


	
}
