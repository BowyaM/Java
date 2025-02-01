package com.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import com.Entity.Employee;

public class EmpService extends HttpServlet {
	private static String url="jdbc:postgresql://localhost:5432/school";
	private static String usn="postgres";
	private static String pswd="123";
	static Connection con;
	static {
		try {
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection(url,usn,pswd);
		}
		catch (ClassNotFoundException e) {
		
		} catch (SQLException e) {
			
		}
	}
	
	public int save(Employee emp) {
		
		String sql="Insert into employee values(?,?,?,?,?) ";
		int result=0;
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, emp.getId());
			ps.setString(2, emp.getName());
			ps.setInt(3, emp.getAge());
			ps.setInt(4, emp.getSal());
			ps.setString(5,emp.getAddress());
			result=ps.executeUpdate();
		} 
		
		catch (SQLException e1) {
			
		}
		return result;
	}
	
	public List<Employee> fetch() {
		List <Employee> emp=new ArrayList<>();
		String sql="Select * from employee";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int age=rs.getInt(3);
				int sal=rs.getInt(4);
				String address=rs.getString(5);
				Employee e=new Employee(id,name,age,sal,address);
				emp.add(e);
			}
		}
		catch (SQLException e) {
		
		}
		return emp;
	}
	
	public int update(Employee emp) {
		int res=0;
		String sql="Update employee set name=?,age=?,sal=?,address=? where id=?";
		String sql2="SELECT * FROM employee ORDER BY id";
		try {
			System.out.println(emp.getName());
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, emp.getName());
			ps.setInt(2, emp.getAge());
			ps.setInt(3, emp.getSal());
			ps.setString(4,emp.getAddress());
			ps.setInt(5,emp.getId());
			res=ps.executeUpdate();
			ps=con.prepareStatement(sql2);
			ps.executeUpdate();
		}
		catch(SQLException e) {
			
		}
		return res;
	}
	
	public int delete(Employee emp) {
		int res=0;
		String sql="Delete from employee where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, emp.getId());
			res=ps.executeUpdate();
		}
		catch(SQLException e) {
			
		}
		return res;
	}
	
	public Employee getEmployeeById(int id) {
		Employee emp=null;
		System.out.println("Fetching employee details");
		try {
			String sql="Select * from employee where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				emp=new Employee(rs.getInt("id"),rs.getString("name"),rs.getInt("age"),rs.getInt("sal"),rs.getString("address"));
			}
		}
		catch (SQLException e1) {
			
		}
		System.out.println(emp);
		return emp;
	}
}
