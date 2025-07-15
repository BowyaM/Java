package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Entity.Employee;
import com.Service.EmpService;

@WebServlet("/edit")
public class EditEmp extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    	PrintWriter out=resp.getWriter();
    	int id=Integer.parseInt(req.getParameter("id")) ;
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		int sal=Integer.parseInt(req.getParameter("sal"));
		String address=req.getParameter("addr");
		
		EmpService empservice=new EmpService();
		Employee emp=new Employee();
		emp.setId(id);
		emp.setName(name);
		emp.setAge(age);
		emp.setSal(sal);
		emp.setAddress(address);
		int updatedEmp=empservice.update(emp);
		if(updatedEmp>0) {
			RequestDispatcher rd=req.getRequestDispatcher("HomePage.html");
			rd.include(req, resp);
		}
		else {
			out.println("Something went wrong!!");
		}
    }
}



 	


//package com.container;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.entity.Employee;
//import com.service.EmpService;
//
//@WebServlet("/edit")
//public class EditEmp extends HttpServlet {
//	
//	
//	@Override
//	
////	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////		String id=req.getParameter("id") ;
////		String name=req.getParameter("name");
////		String gender=req.getParameter("gender");
////		long phno=Long.parseLong(req.getParameter("phno")) ;
////		int sal=Integer.parseInt(req.getParameter("sal"));
////		String address=req.getParameter("addr");
////		
////		EmpService empservice=new EmpService();
////		Employee emp=new Employee();
////		emp.setId(id);
////		emp.setName(name);
////		emp.setGender(gender);
////		emp.setPhno(phno);
////		emp.setSal(sal);
////		emp.setAddress(address);
////		int updatedEmp=empservice.update(emp);
////		System.out.println(updatedEmp);
////		if(updatedEmp!=0) {
////			RequestDispatcher rd=req.getRequestDispatcher("HOME.html");
////			rd.include(req, resp);
////		}
//		
//	}
//	
//}
