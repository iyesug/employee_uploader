package com.great.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.great.bean.Department;
import com.great.bean.Employee;
import com.great.bean.Job;


public class MyDateBase {

	private Connection conn;
	private PreparedStatement ps;
	
	public MyDateBase(){
		DateConnect dateconn=new DateConnect();
		conn=DateConnect.getConnect();
	}
	
	
	
	
	public int delEmp(String name){
		int i = 0;
		System.out.println(name);
		try {
		String sql="DELETE FROM EMPLOYEE WHERE NAME = ?";
			ps=conn.prepareStatement(sql);
		

			ps.setString(1,name);
			 i=ps.executeUpdate();
			System.out.println(i);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return i;
	}
	
	
	public Employee findEmp(String name){
		Employee emp=null;
		ResultSet rs = null;
		int i = 0;
		try {
		String sql="SELECT * FROM EMPLOYEE  WHERE NAME = ?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,name);

		rs=ps.executeQuery();
		if(rs!=null){
			while(rs.next()){
				String name1=rs.getString("NAME");
				String department=rs.getString("DEPARTMENT");
				String job=rs.getString("JOB_TITLE");
				emp=new Employee();
				emp.setName(name);
				emp.setDepartment(department);
				emp.setJob(job);
			
			}
			rs.close();
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return emp;
		
	}
	
	
	
	public int updateEmp(String name,String dep,String job){
		int i = 0;
		try {
		String sql="UPDATE EMPLOYEE SET DEPARTMENT = ?,JOB_TITLE =?  WHERE NAME = ?";
			ps=conn.prepareStatement(sql);
		

			ps.setString(1,dep);
			ps.setString(2,job);
			ps.setString(3,name);
		i=ps.executeUpdate();
		if(i==0){
			System.out.println("修改失败");
		}else{
			System.out.println("修改了"+i+"个");
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return i;
		
	}
	
	
	
	
	
	public List<Employee> getEmp(){
	
	
	
		List<Employee> list=new ArrayList<Employee>();
		Employee emp=null;
		ResultSet rs = null;
		try {
		
		String sql="SELECT * FROM EMPLOYEE";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs!=null){
				while(rs.next()){
					String name=rs.getString("NAME");
					String department=rs.getString("DEPARTMENT");
					String job=rs.getString("JOB_TITLE");
					emp=new Employee();
					emp.setName(name);
					emp.setDepartment(department);
					emp.setJob(job);
					list.add(emp);
				}
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	
	
	
	public List<Department> getDepartment(){
	
	
	
		List<Department> list=new ArrayList<Department>();
		Department dep=null;
		ResultSet rs = null;
		try {
		
		String sql="SELECT * FROM DEPARTMENT";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs!=null){
				while(rs.next()){
					String name=rs.getString("NAME");
					int id=rs.getInt("ID");
					dep=new Department(id, name);
					list.add(dep);
				}
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		int n=list.size();
//		String [] result=new String[n];
//		for(int i=0;i<n;i++)
//		{
//		result[i]=String.valueOf(list.get(i));
//		};
		return list;
	}
	
	
	public List<Job> getJob(){
		
		List<Job> list=new ArrayList<Job>();
		Job job=null;
		ResultSet rs = null;
		try {
		String sql="SELECT * FROM JOB_TITLE";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs!=null){
				while(rs.next()){
					String name=rs.getString("NAME");
					int id=rs.getInt("ID");
					int department_id=rs.getInt("DEPARTMENT_ID");
					
					job=new Job(id, name, department_id);
					list.add(job);
				}
				rs.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		int n=list.size();
//		String [] result=new String[n];
//		for(int i=0;i<n;i++)
//		{
//		result[i]=String.valueOf(list.get(i));
//		};
		
		return list;
	
	}
	
	public void newEmp(Employee emp){
		
		try {
		String sql="INSERT INTO EMPLOYEE (DEPARTMENT,JOB_TITLE,NAME) VALUES(?,?,?)";
			ps=conn.prepareStatement(sql);
		
			ps.setString(1, emp.getDepartment());
			ps.setString(2, emp.getJob());
			ps.setString(3, emp.getName());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	
	public void closeConn(){
		
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
