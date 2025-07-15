package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.Employee;
import com.Service.EmpService;


@WebServlet("/register")
public class SaveEmp extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		int id=Integer.parseInt(req.getParameter("id")) ;
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age")) ;
		int sal=Integer.parseInt(req.getParameter("sal"));
		String address=req.getParameter("addr");
		
		Employee emp=new Employee();
		emp.setId(id);
		emp.setName(name);
		emp.setAge(age);
		emp.setSal(sal);
		emp.setAddress(address);
		
		EmpService es=new EmpService();
		es.save(emp);
		RequestDispatcher rd=req.getRequestDispatcher("HomePage.html");
		rd.forward(req, resp);
		
	}
}
