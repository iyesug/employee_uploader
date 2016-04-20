package com.great.action;



import java.util.List;
import java.util.Map;

import com.great.bean.Employee;
import com.great.db.MyDateBase;
import com.opensymphony.xwork2.ActionContext;

public class ShowAction {
	private List<Employee> listemp;
	private Employee emp;
	private String result;
	
	public String isExist(){
		
		MyDateBase dateuse=new MyDateBase();
		listemp=dateuse.getEmp();
		dateuse.closeConn();
		String name=emp.getName();
		for(Employee st:listemp){
			if(st.getName().equals(name)){	
				result="yes";
				emp =st;
				return "exist";
			}
		}
		result="no";
		return "exist";		
	}


	public String execute(){
		
	
			
			MyDateBase dateuse=new MyDateBase();
			listemp=dateuse.getEmp();
			dateuse.closeConn();
			
            Map request=(Map) ActionContext.getContext().get("request");
            request.put("listemp", listemp);    		
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
