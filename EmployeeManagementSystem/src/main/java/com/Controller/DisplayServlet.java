package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.Employee;
import com.Service.EmpService;

@WebServlet("/display")
public class DisplayServlet extends HttpServlet{
	
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
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		EmpService empservice=new EmpService();
		List<Employee> emps=empservice.fetch();
		req.setAttribute("employees", emps);
		RequestDispatcher rd=req.getRequestDispatcher("display.jsp");
		rd.forward(req, res);
	}	
}
